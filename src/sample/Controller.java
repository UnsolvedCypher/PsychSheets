package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

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
    VBox rankingVBox;

    public void initialize(){

        eventBox.setVisible(false);
        searchButton.setVisible(true);
        compInput.setVisible(true);

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

    }

}