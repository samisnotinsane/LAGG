package com.lagg.client.fxcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by serem on 12/03/2017.
 */
public class ProgressScreenController implements Initializable {

    @FXML
    TableColumn colLearningTools;
    @FXML
    TableColumn colTests;

    @FXML
    TableView tableView;
    private final ObservableList<Button> learningTools =
            FXCollections.observableArrayList(
                    new Button("Coursera/Lesson-3"),
                    new Button("Medium/HTML Table for beginners"),
                    new Button("Udemy/Tables"));

    private final ObservableList<Button> tests =
            FXCollections.observableArrayList(
                    new Button("Test"),
                    new Button("Test"),
                    new Button("Test")
                    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colLearningTools.setCellValueFactory( new PropertyValueFactory<>( "learningTools" ) );
        colTests.setCellValueFactory( new PropertyValueFactory<>( "tests" ) );

        Callback<TableColumn<Button, Button>, TableCell<Button, Button>> cellFactory = //
                new Callback<TableColumn<Button, Button>, TableCell<Button, Button>>()
                {
                    @Override
                    public TableCell call(final TableColumn<Button, Button> param )
                    {
                        final TableCell<Button, Button> cell = new TableCell<Button, Button>()
                        {

                            final Button btn = new Button( "Just Do It" );

                            @Override
                            public void updateItem( Button item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                    {

                                        System.out.println( "transition to did you like this content" );
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
    }

}
