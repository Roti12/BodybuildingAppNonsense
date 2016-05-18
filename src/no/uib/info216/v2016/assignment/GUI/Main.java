package no.uib.info216.v2016.assignment.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root ;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI.fxml"));

        Controller controller = new Controller();
        controller.setMainController(controller);
        fxmlLoader.setController(controller);
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        controller.initializeGUI();

        primaryStage.setTitle("Workout Planner");
        primaryStage.setScene(scene);
      //  primaryStage.setOnCloseRequest(we -> );


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
