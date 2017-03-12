package com.lagg.client.fxcontrollers;

import com.jfoenix.controls.JFXButton;
import com.lagg.client.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by serem on 12/03/2017.
 */
public class ProgressScreenController implements Initializable {

    @FXML
    JFXButton btnLearningTools;
    @FXML
    TableColumn btnTests;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleLearningTools(ActionEvent e) {
        // open did you like this content
        // open likeView.fxml

        try {
            ScrollPane scrollPane = Main.loadLikeView();
            Main.rootPane.setCenter(null);
            Main.rootPane.setCenter(scrollPane);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void handleBtnTests(ActionEvent e) {
        try {
            ScrollPane scrollPane = Main.loadRankScreen();
            Main.rootPane.setCenter(null);
            Main.rootPane.setCenter(scrollPane);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
