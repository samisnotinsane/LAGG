package com.lagg.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;
import org.pmw.tinylog.Logger;
import org.pmw.tinylog.writers.ConsoleWriter;
import org.pmw.tinylog.writers.FileWriter;

import java.io.File;
import java.net.URL;
import java.util.Locale;

/**
 * Created by sameen on 11/03/2017.
 */
public class Main extends Application {

    public static final String ABSOLUTE_PATH_TO_RESOURCES_DIR =
            "/Users/sameenislam/Documents/Repositories/FacebookHack/LAGG/src/main/resources";

    public static void main(String[] args) {
        configureLog();
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Logger.trace("Welcome to LAGG");

        String pathToMainLayout = ABSOLUTE_PATH_TO_RESOURCES_DIR + "/MainLayout.fxml";
        String pathToLoginPane  = ABSOLUTE_PATH_TO_RESOURCES_DIR + "/Login.fxml";

        URL urlToMainLayout;
        URL urlToLoginPane;

        Parent root = null;
        Pane loginPane = null;

        try {
            urlToMainLayout = new File(pathToMainLayout).toURI().toURL();
            urlToLoginPane = new File(pathToLoginPane).toURI().toURL();
            root = FXMLLoader.load( urlToMainLayout );
            loginPane = FXMLLoader.load( urlToLoginPane );
        } catch (Exception e) {
            Logger.error("Failed to load MainLayout.fxml", e);
        }

        BorderPane rootPane = (BorderPane)root;
        rootPane.setCenter(loginPane);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void configureLog() {
        Configurator.defaultConfig()
                .writer(new ConsoleWriter())
                .locale(Locale.UK)
                .formatPattern("[{level}] ({date:yyyy-MM-dd HH:mm:ss}) [{class}.{method}()]: {message}")
                .level(Level.TRACE)
                .activate();
    }
}
