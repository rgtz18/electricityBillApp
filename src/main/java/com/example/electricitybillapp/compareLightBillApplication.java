package com.example.electricitybillapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

// Define the main class that extends from Application, which is JavaFX framework class
public class compareLightBillApplication extends Application {

    // The start method is the main entry point for all JavaFX applications
    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader loads an FXML document to create a new scene. "hello-view.fxml" defines the GUI layout
        FXMLLoader fxmlLoader = new FXMLLoader(compareLightBillApplication.class.getResource("hello-view.fxml"));

        // Create a new scene with the FXML layout, set its width to 320 and height to 240
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Set the title of the window (Stage) to "Hello!"
        stage.setTitle("Hello!");

        // Set the scene for this stage to the one we just created
        stage.setScene(scene);

        // Display the stage. Until this is called, the application window will not be visible
        stage.show();
    }

    // The main method is where teh JVM starts execution of any Java program
    public static void main(String[] args) {
        // launch() is a static method of the Application class that launches the JavaFX application
        // It takes care of the initial setup and calls the start() method defined above
        launch();
    }
}