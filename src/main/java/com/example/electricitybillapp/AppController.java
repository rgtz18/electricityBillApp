package com.example.electricitybillapp;


import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;


public class AppController {
    @FXML
    private ComboBox<String> companyOneComboBox;
    @FXML
    private ComboBox<String> companyTwoComboBox;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private LineChart<Number, Number> lineChart;

    @FXML
    protected void compareCompanies() {
        // logic to fetch data, compare and plot
        lineChart.getData().clear();
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(1, 200));  // Sample data
        series.getData().add(new XYChart.Data<>(2, 150));
        lineChart.getData().add(series);
    }
}