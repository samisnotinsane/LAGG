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
            "src/main/resources";

    public static final String ABSOLUTE_PATH_TO_MAINLAYOUT =
            "src/main/resources/MainLayout.fxml";

    public static final String ABSOLUTE_PATH_TO_TOP_NAV_VIEW =
            "src/main/resources/TopPaneView.fxml";


    public static final String ABSOLUTE_PATH_TO_LOGIN =
            "src/main/resources/Login.fxml";

    public static final String ABSOLUTE_PATH_TO_AREA_VIEW =
            "src/main/resources/AreaView.fxml";

    public static final String ABSOLUTE_PATH_TO_GRAPH_VIEW =
            "src/main/resources/GraphView.fxml";

    public static BorderPane rootPane;

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
            Logger.error("Failed to load MainLayout.fxml {}", e);
        }

        rootPane = (BorderPane)root;
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

    public static URL loadUrl(String path) throws Exception {
        return new File(path).toURI().toURL();
    }

    public static Pane loadAreaViewPane() throws Exception {
        URL urlToAreaView = loadUrl(ABSOLUTE_PATH_TO_AREA_VIEW);
        return FXMLLoader.load(urlToAreaView);
    }

    public static Pane loadTopNavView() throws Exception {
        URL urlToTopPane = loadUrl(ABSOLUTE_PATH_TO_TOP_NAV_VIEW);
        return FXMLLoader.load(urlToTopPane);
    }

    public static Pane loadGraphViewPane() throws Exception {
        URL urlToGraphView = loadUrl(ABSOLUTE_PATH_TO_GRAPH_VIEW);
        return FXMLLoader.load(urlToGraphView);
    }
}
