package com.lagg.client.fxcontrollers;

import com.jfoenix.controls.JFXButton;
import com.lagg.Topic;
import com.lagg.client.Main;
import com.lagg.graph.TopicGraph;
import com.lagg.graph.TopicSubgraph;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import org.pmw.tinylog.Logger;

import java.net.URL;
import java.util.HashSet;
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

        Main.rootPane.setCenter(null);

        // dynamically generate buttons on a fresh pane.
        VBox graphViewPane = new VBox();
        graphViewPane.setSpacing(10);

        Main.rootPane.setCenter(graphViewPane);
        graphViewPane.setPrefHeight(120.0);
        graphViewPane.setPrefWidth(170.0);


        TopicSubgraph topicSubgraph = TopicGraph.getTopicsUniverse().getTopics("Linear algebra");
        HashSet<Topic> topics = topicSubgraph.findEntryPoints(); // topics in graph

        while (!(topics.isEmpty())) {

            HBox hbox = new HBox(30);
            hbox.getHgrow(graphViewPane);
            hbox.setAlignment(Pos.CENTER);

            for (Topic topic : topics) {
                hbox.getChildren().add(new Button(topic.getName()));
            }
            graphViewPane.getChildren().add(hbox);

            HashSet<Topic> temps = new HashSet<>();
            for (Topic topic : topics) {
                for(Topic temp : topicSubgraph.findChildren(topic))
                    if(!topics.contains(temp))
                        temps.add(temp);
            }
            topics = new HashSet<>(temps);
        }


    }
}
