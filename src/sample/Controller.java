package sample;

import com.sun.javaws.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

import java.awt.*;

//Need to adjust all objects to current screen size/frame size

public class Controller {

    @FXML
    Rectangle BKG;

    @FXML
    TextField compInput;

    @FXML
    Pane mainPane;

    @FXML
    Button searchButton;

    @FXML
    ChoiceBox eventBox;

    @FXML
    VBox rankingVBox,timesVBox;

    @FXML
    ScrollBar scrollBar;

    public void initialize(){

        Rectangle2D screen = Screen.getPrimary().getBounds();

        double screenWidth = screen.getWidth();
        double screenHeight = screen.getHeight();

        mainPane.setPrefHeight(screenHeight);
        mainPane.setPrefWidth(screenWidth);

        BKG.setWidth(screenWidth);
        BKG.setHeight(screenHeight);

        //think this is wrong? Maybe not though
        searchButton.setLayoutX(.5*screenWidth-(.5*searchButton.getWidth()));

        //compInput.setPrefWidth(screenWidth-((.0390625)*()));

        eventBox.setVisible(false);
        searchButton.setVisible(true);
        compInput.setVisible(true);
        rankingVBox.setVisible(false);
        scrollBar.setVisible(false);

        //Image img = new Image("C:\\Users\\JP\\Desktop\\hello.jpg");

        compInput.setOnKeyPressed(e->{

            if(e.getCode() == KeyCode.ENTER){
                String compName;
                compName = compInput.getText();

            }
        });

    }

    public void compName(){

        String compName = compInput.getText();

        eventBox.setVisible(true);
        compInput.setVisible(false);
        searchButton.setVisible(false);
        rankingVBox.setVisible(true);

        //Event box list, probably need to get comp events and put them in the list
        ObservableList<String> List = FXCollections.observableArrayList("3x3","4x4");

        eventBox.setItems(List);

        int numberOfCompetitors;

        for(numberOfCompetitors = 0; numberOfCompetitors <= 10;numberOfCompetitors++) {

            if (numberOfCompetitors > 10){
                scrollBar.setVisible(true);}

            Rectangle competitors = new Rectangle();
            competitors.setArcWidth(5);
            competitors.setArcHeight(5);
            competitors.setVisible(true);
            competitors.setFill(Color.WHITE);
            competitors.setWidth(250);
            competitors.setHeight(40);
            competitors.setX(0);
            competitors.setY(0);
            competitors.setLayoutX(0);
            competitors.setLayoutY(numberOfCompetitors*40);
            competitors.setStroke(Color.BLACK);

            rankingVBox.getChildren().add(competitors);

            Rectangle times = new Rectangle();
            times.setArcWidth(5);
            times.setArcHeight(5);
            times.setVisible(true);
            times.setFill(Color.WHITE);
            times.setWidth(100);
            times.setHeight(40);
            times.setX(0);
            times.setY(0);
            times.setLayoutX(0);
            times.setLayoutY(numberOfCompetitors*40);
            times.setStroke(Color.BLACK);

            timesVBox.getChildren().add(times);

        }
    }

}