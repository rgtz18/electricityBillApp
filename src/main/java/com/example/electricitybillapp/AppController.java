package com.example.electricitybillapp;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.chart.CategoryAxis;

public class AppController {
    @FXML private ComboBox<String> companyOneComboBox;
    @FXML private ComboBox<String> companyTwoComboBox;
    @FXML private TextField wattageRateCompanyOne;
    @FXML private TextField wattageRateCompanyTwo;
    @FXML private TextField janWattage, febWattage, marWattage, aprWattage, mayWattage, junWattage, julWattage, augWattage, sepWattage, octWattage, novWattage, decWattage;
    @FXML private LineChart<String, Number> lineChart;
    @FXML private CategoryAxis monthAxis;
    @FXML private TextField baseRateCompanyOne;
    @FXML private TextField baseRateCompanyTwo;
    @FXML private TextField tduCompanyOne;
    @FXML private TextField tduCompanyTwo;
    @FXML private TextArea comparisonReport;

    @FXML
    public void initialize() {
        populateCompanyChoices();
        addTextLimiter(wattageRateCompanyOne, 10);
        addTextLimiter(wattageRateCompanyTwo, 10);
        addTextLimiter(baseRateCompanyOne, 10);
        addTextLimiter(baseRateCompanyTwo, 10);
        addTextLimiter(tduCompanyOne, 10);
        addTextLimiter(tduCompanyTwo, 10);
        TextField[] wattages = {janWattage, febWattage, marWattage, aprWattage, mayWattage, junWattage, julWattage, augWattage, sepWattage, octWattage, novWattage, decWattage};
        for (TextField wattage : wattages) {
            addTextLimiter(wattage, 10);
        }
    }

    @FXML
    protected void compareCompanies() {
        if (isInputInvalid()) {
            comparisonReport.setText("Please fill in all required fields before comparing.");
            return;
        }

        double rate1 = Double.parseDouble(wattageRateCompanyOne.getText());
        double rate2 = Double.parseDouble(wattageRateCompanyTwo.getText());
        double base1 = Double.parseDouble(baseRateCompanyOne.getText());
        double base2 = Double.parseDouble(baseRateCompanyTwo.getText());
        double tdu1 = Double.parseDouble(tduCompanyOne.getText());
        double tdu2 = Double.parseDouble(tduCompanyTwo.getText());

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName(companyOneComboBox.getValue());
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName(companyTwoComboBox.getValue());

        TextField[] wattages = {janWattage, febWattage, marWattage, aprWattage, mayWattage, junWattage, julWattage, augWattage, sepWattage, octWattage, novWattage, decWattage};
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        StringBuilder report = new StringBuilder("Monthly Cost Comparison:\n");
        report.append(String.format("%-10s %-15s %-15s %-15s\n", "Month", "Company A ($)", "Company B ($)", "Difference (%)"));
        report.append("--------------------------------------------------------------\n");

        for (int i = 0; i < months.length; i++) {
            double usage1 = calculateCost(rate1, getWattageFromTextField(wattages[i]), base1, tdu1);
            double usage2 = calculateCost(rate2, getWattageFromTextField(wattages[i]), base2, tdu2);

            double difference = usage1 == 0 ? 0 : ((usage2 - usage1) / usage1) * 100;
            report.append(String.format("%-10s %-15.2f %-15.2f %-15.2f\n", months[i], usage1, usage2, difference));

            series1.getData().add(new XYChart.Data<>(months[i], usage1));
            series2.getData().add(new XYChart.Data<>(months[i], usage2));
        }

        lineChart.getData().clear();
        lineChart.getData().addAll(series1, series2);
        comparisonReport.setText(report.toString());
    }

    private void populateCompanyChoices() {
        String[] companies = {"TXU Energy", "4 Change", "Reliant Energy", "Green Mountain Energy", "Direct Energy", "NRG Energy"};
        companyOneComboBox.getItems().addAll(companies);
        companyTwoComboBox.getItems().addAll(companies);
        companyOneComboBox.setValue("Company A");
        companyTwoComboBox.setValue("Company B");
    }

    private double calculateCost(double rate, double wattage, double base, double tdu) {
        return wattage * rate + base + tdu;
    }

    private double getWattageFromTextField(TextField textField) {
        try {
            return Double.parseDouble(textField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void addTextLimiter(TextField textField, int maxLength) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > maxLength) {
                textField.setText(oldValue);
            } else if (!newValue.matches("\\d*\\.?\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d.]", ""));
            }
        });
    }

    private boolean isInputInvalid() {
        TextField[] requiredFields = {wattageRateCompanyOne, wattageRateCompanyTwo, baseRateCompanyOne, baseRateCompanyTwo, tduCompanyOne, tduCompanyTwo};
        for (TextField field : requiredFields) {
            if (field.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
