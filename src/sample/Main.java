package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Profile matt = new Profile("2012MCMI01");

        Parent root = FXMLLoader.load(getClass().getResource("PsychSheets.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }

    // using names as specified in the pb section of WCA results pages
    public static String officialNameOf(String eventName) {
        switch(eventName) {
            case "2x2x2 Cube":
            case "2x2":
                return "2x2x2 Cube";
            case "Rubik's Cube":
            case "3x3":
                return "Rubik's Cube";
            case "4x4x4 Cube":
            case "4x4":
                return "4x4x4 Cube";
            case "5x5x5 Cube":
            case "5x5":
                return "5x5x5 Cube";
            case "6x6x6 Cube":
            case "6x6":
                return "6x6x6 Cube";
            case "7x7x7 Cube":
            case "7x7":
                return "7x7x7 Cube";
            case "3x3x3 Fewest Moves":
            case "FMC":
                return "3x3x3 Fewest Moves";
            case "3x3x3 Multi-Blind":
            case "MBLD":
                return "3x3x3 Multi-Blind";
            case "3x3x3 With Feet":
            case "Feet":
                return "3x3x3 With Feet";
            case "3x3x3 One-Handed":
            case "OH":
                return "3x3x3 One-Handed";
            case "3x3x3 Blindfolded":
            case "BLD":
                return "3x3x3 Blindfolded";
            case "4x4x4 Blindfolded":
            case "4-BLD":
                return "4x4x4 Blindfolded";
            case "5x5x5 Blindfolded":
            case "5-BLD":
                return "5x5x5 Blindfolded";
            case "Rubik's Clock":
            case "Clock":
                return "Rubik's Clock";
            case "Megaminx":
            case "Mega":
                return "Megaminx";
            case "Skewb":
                return "Skewb";
            case "Square-1":
            case "Sq-1":
                return "Square-1";
            case "Pyraminx":
            case "Pyra":
                return "Pyraminx";
            default:
                System.out.println("unable to get name for " + eventName);
                return null;

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
