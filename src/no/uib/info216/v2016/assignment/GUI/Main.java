package no.uib.info216.v2016.assignment.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.uib.info216.v2016.assignment.dataset.Datasets;
import no.uib.info216.v2016.assignment.models.Models;

public class Main extends Application {
    private static Datasets dataset;
    private static Models model;
    

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root ;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI.fxml"));

        Controller controller = new Controller();
        controller.setMainController(controller);
        fxmlLoader.setController(controller);
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("GUI.css").toExternalForm());
        controller.initializeGUI();

        primaryStage.setTitle("Workout Planner");
        primaryStage.setScene(scene);
      //  primaryStage.setOnCloseRequest(we -> );


        primaryStage.show();
    }


    public static void main(String[] args) {


        System.out.println("Loading model..");
        dataset = new Datasets();
        model = new Models();
        dataset.addModelToSet(model.addFileModel("MachinesAndExcercises.owl"), "Workout Planner");

        launch(args);
    }
}
