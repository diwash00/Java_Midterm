package com.georgiancollege.test1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Fetch employee data from the database
        EmployeeDataFetcher dataFetcher = new EmployeeDataFetcher();
        List<Employee> employees = dataFetcher.fetchEmployeesFromDatabase();

        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("employee-view.fxml"));
        Parent root = fxmlLoader.load();

        // Get the controller associated with the FXML file
        EmployeeController controller = fxmlLoader.getController();

        // Pass the employee data to the controller
        controller.setEmployees(employees);

        // Create a scene and set it on the stage
        Scene scene = new Scene(root);
        stage.setTitle("Employee Viewer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
