package com.lagg.client.fxcontrollers;

import com.jfoenix.controls.JFXButton;
import com.lagg.client.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sameen on 11/03/2017.
 */
public class LoginController implements Initializable {

    @FXML
    JFXButton btnFbLogin;

    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleFbLogin(ActionEvent event) throws IOException {
        Logger.trace("handleFbLogin clicked");
        try {
            Pane topNavPane = Main.loadTopNavView();
            Pane areaViewPane = Main.loadAreaViewPane();
            Main.rootPane.setTop(topNavPane);
            Main.rootPane.setCenter(null);
            Main.rootPane.setCenter(areaViewPane);
        } catch (Exception e) {
            Logger.error("Failed to load area view {}", e);
        }
    }


}
