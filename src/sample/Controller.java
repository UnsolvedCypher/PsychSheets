package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
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

    public void initialize(){

        Image img = new Image("C:\\Users\\JP\\Desktop\\hello.jpg");

        compInput.setOnKeyPressed(e->{

            if(e.getCode() == KeyCode.ENTER){
                String compName;
                compName = compInput.getText();

            }
        });

    }

    public void compName(){

        String compName = compInput.getText();

    }

}