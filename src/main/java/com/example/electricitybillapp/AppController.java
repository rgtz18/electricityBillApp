package com.example.electricitybillapp;


import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class AppController {
    @FXML
    private ComboBox<String> companyOneComboBox;
    @FXML
    private ComboBox<String> companyTwoComboBox;
    @FXML
    private TextField wattageRateCompanyOne;
    @FXML
    private TextField wattageRateCompanyTwo;
    @FXML
    private TextField janWattage;
    @FXML
    private TextField febWattage;
    @FXML
    private TextField marWattage;
    @FXML
    private TextField aprWattage;
    @FXML
    private TextField mayWattage;
    @FXML
    private TextField junWattage;
    @FXML
    private TextField julWattage;
    @FXML
    private TextField augWattage;
    @FXML
    private TextField sepWattage;
    @FXML
    private TextField octWattage;
    @FXML
    private TextField novWattage;
    @FXML
    private TextField decWattage;
    @FXML
    private LineChart<Number, Number> lineChart;

    @FXML
    protected void compareCompanies() {

        double rate1 = Double.parseDouble(wattageRateCompanyOne.getText());
        double rate2 = Double.parseDouble(wattageRateCompanyTwo.getText());
        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("Company 1");
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        series2.setName("Company 2");

        // Use the input wattage for each month
        double janUsage = Double.parseDouble(janWattage.getText());
        double febUsage = Double.parseDouble(febWattage.getText());
        double marUsage = Double.parseDouble(marWattage.getText());
        double aprUsage = Double.parseDouble(aprWattage.getText());
        double mayUsage = Double.parseDouble(mayWattage.getText());
        double junUsage = Double.parseDouble(junWattage.getText());
        double julUsage = Double.parseDouble(julWattage.getText());
        double augUsage = Double.parseDouble(augWattage.getText());
        double sepUsage = Double.parseDouble(sepWattage.getText());
        double octUsage = Double.parseDouble(octWattage.getText());
        double novUsage = Double.parseDouble(novWattage.getText());
        double decUsage = Double.parseDouble(decWattage.getText());


        series1.getData().add(new XYChart.Data<>(1, rate1 * janUsage));
        series1.getData().add(new XYChart.Data<>(2, rate1 * febUsage));
        series1.getData().add(new XYChart.Data<>(3, rate1 * marUsage));
        series1.getData().add(new XYChart.Data<>(4, rate1 * aprUsage));
        series1.getData().add(new XYChart.Data<>(5, rate1 * mayUsage));
        series1.getData().add(new XYChart.Data<>(6, rate1 * junUsage));
        series1.getData().add(new XYChart.Data<>(7, rate1 * julUsage));
        series1.getData().add(new XYChart.Data<>(8, rate1 * augUsage));
        series1.getData().add(new XYChart.Data<>(9, rate1 * sepUsage));
        series1.getData().add(new XYChart.Data<>(10, rate1 * octUsage));
        series1.getData().add(new XYChart.Data<>(11, rate1 * novUsage));
        series1.getData().add(new XYChart.Data<>(12, rate1 * decUsage));


        series2.getData().add(new XYChart.Data<>(1, rate2 * janUsage));
        series2.getData().add(new XYChart.Data<>(2, rate2 * febUsage));
        series2.getData().add(new XYChart.Data<>(3, rate2 * marUsage));
        series2.getData().add(new XYChart.Data<>(4, rate2 * aprUsage));
        series2.getData().add(new XYChart.Data<>(5, rate2 * mayUsage));
        series2.getData().add(new XYChart.Data<>(6, rate2 * junUsage));
        series2.getData().add(new XYChart.Data<>(7, rate2 * julUsage));
        series2.getData().add(new XYChart.Data<>(8, rate2 * augUsage));
        series2.getData().add(new XYChart.Data<>(9, rate2 * sepUsage));
        series2.getData().add(new XYChart.Data<>(10, rate2 * octUsage));
        series2.getData().add(new XYChart.Data<>(11, rate2 * novUsage));
        series2.getData().add(new XYChart.Data<>(12, rate2 * decUsage));


        lineChart.getData().addAll(series1, series2);


    }
}