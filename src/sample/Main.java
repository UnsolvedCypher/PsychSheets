package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public String eventCodeOf(String eventName) {
        switch(eventName) {
            case "2x2":
                return "222";
            case "3x3":
                return "333";
            case "4x4":
                return "4x4";
            case "5x5":
                return "555";
            case "6x6":
                return "666";
            case "7x7":
                return "777";
            case "FMC":
                return "333fm";
            case "Multi":
                return "333mbf";
            case "Feet":
                return "333ft";
            case "3BLD":
                return "333bf";
            case "FMC":
                return "333fm";
            
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
