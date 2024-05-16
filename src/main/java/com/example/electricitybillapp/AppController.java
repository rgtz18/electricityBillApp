package com.example.electricitybillapp;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
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

    @FXML
    protected void compareCompanies() {
        double rate1 = Double.parseDouble(wattageRateCompanyOne.getText());
        double rate2 = Double.parseDouble(wattageRateCompanyTwo.getText());

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Company 1");
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Company 2");

        TextField[] wattages = {janWattage, febWattage, marWattage, aprWattage, mayWattage, junWattage, julWattage, augWattage, sepWattage, octWattage, novWattage, decWattage};
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        for (int i = 0; i < months.length; i++) {
            double usage1 = getWattageFromTextField(wattages[i]) * rate1;
            double usage2 = getWattageFromTextField(wattages[i]) * rate2;
            series1.getData().add(new XYChart.Data<>(months[i], usage1));
            series2.getData().add(new XYChart.Data<>(months[i], usage2));
        }

        lineChart.getData().clear();
        lineChart.getData().addAll(series1, series2);
    }

    private double getWattageFromTextField(TextField textField) {
        try {
            return Double.parseDouble(textField.getText());
        } catch (NumberFormatException e) {
            return 0; // Return 0 or handle the error as appropriate for your application
        }
    }
}
