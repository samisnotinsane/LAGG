package com.lagg.client.fxcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sameen on 11/03/2017.
 */
public class GraphViewController implements Initializable {

    @FXML
    Label lblUsername;
    @FXML
    Label lblArea;
    @FXML
    Label lblField;
    @FXML
    Label lblSubfield;
    @FXML
    WebView graphWebView;

    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleBackButton(ActionEvent event) {

    }
}
