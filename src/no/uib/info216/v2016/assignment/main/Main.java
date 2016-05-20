package no.uib.info216.v2016.assignment.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.uib.info216.v2016.assignment.dataset.Datasets;
import no.uib.info216.v2016.assignment.models.Models;
/**
 * Created by 117, 103.
 */
public class Main extends Application {
    private static Datasets dataset;
    private static Models model;
    

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root ;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../GUI/GUI.fxml"));

        Controller controller = new Controller();
        controller.setMainController(controller);
        fxmlLoader.setController(controller);
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("../GUI/GUI.css").toExternalForm());
        controller.initializeGUI();

        System.out.println("Loading data from file..");

        controller.setListviewFullExercisesSource(Parser.parse());

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
