package com.scenebuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class SceneBuilderDemoApplication extends Application {

    public static void main(String[] args) {
        SpringApplication.run(SceneBuilderDemoApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("demo.fxml")));
        primaryStage.setTitle("application");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }
}
