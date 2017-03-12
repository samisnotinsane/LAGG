package com.lagg.client.fxcontrollers;

import com.jfoenix.controls.JFXButton;
import com.lagg.client.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import org.pmw.tinylog.Logger;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sameen on 12/03/2017.
 */
public class AreaViewController implements Initializable {

    @FXML
    JFXButton btnTopLeft;
    @FXML
    JFXButton btnTopCentre;
    @FXML
    JFXButton btnTopRight;

    @FXML
    JFXButton btnCentreLeft;
    @FXML
    JFXButton btnCentreRight;
    @FXML
    JFXButton btnBottomLeft;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleBtnTopCentre(ActionEvent event) {
        Logger.trace("btnTopCentre clicked");

        // change button text to reflect field
        btnTopLeft.setText("Drawing & Animation");
        btnTopCentre.setText("Database Development");
        btnTopRight.setText("Web Development");
        btnCentreLeft.setText("Programming");
        btnCentreRight.setText("Computer Science");

        btnBottomLeft.setText("");
        btnBottomLeft.setVisible(false);
    }

    @FXML
    public void handleBtnTopRight(ActionEvent event) {
        Logger.trace("btnTopRight clicked");
        // user clicked on 'web development'
        // show graph screen.
        try {
            Pane graphViewPane = Main.loadGraphViewPane();
            Main.rootPane.setCenter(null);
            Main.rootPane.setCenter(graphViewPane);
        } catch (Exception e) {
            Logger.error("Failed to load area view {}", e);
        }
    }
}
