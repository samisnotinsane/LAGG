package com.lagg.client.fxcontrollers;

import com.lagg.client.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;

/**
 * Created by sameen on 12/03/2017.
 */
public class TestRankScreenController {

    @FXML
    public void handleBtnHappy(ActionEvent e) {
        // go back to progressScreen

        try {
            ScrollPane pane = Main.loadProgressScreenPane();
            Main.rootPane.setCenter(null);
            Main.rootPane.setCenter(pane);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
