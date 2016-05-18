package no.uib.info216.v2016.assignment.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.uib.info216.v2016.assignment.excercises.Exercise;
import no.uib.info216.v2016.assignment.excercises.ProgramCreator;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The controller for the GUI, handles all button presses and actions the GUI has to perform
 * Created by sto020 on 05.05.2016.
 *
 * @author sto020
 */
public class Controller implements Initializable {

    private final ObservableList<Exercise> mondayList =
            FXCollections.observableArrayList(
            );
    private final ObservableList<Exercise> tuesdayList =
            FXCollections.observableArrayList(
            );
    private final ObservableList<Exercise> wednesdayList =
            FXCollections.observableArrayList(
            );
    private final ObservableList<Exercise> thursdayList =
            FXCollections.observableArrayList(
            );
    private final ObservableList<Exercise> fridayList =
            FXCollections.observableArrayList(
            );
    private final ObservableList<Exercise> saturdayList =
            FXCollections.observableArrayList(
            );
    private final ObservableList<Exercise> sundayList =
            FXCollections.observableArrayList(
            );

    private final ObservableList<String> experienceList =
            FXCollections.observableArrayList(
                    "Never worked out in my entire life",
                    "Less than 6 months",
                    "More than 6 months",
                    "Less than a year",
                    "More than a year",
                    "Less than 2 years",
                    "More than 2 years"
            );

    private final ObservableList<String> equipmentList =
            FXCollections.observableArrayList(

                    "Bench",
                    "Bench Press Rack",
                    "Squat Rack",
                    "Olympic Barbell Men",
                    "Cap Barbell Dumbells",
                    "Rounded Dumbells",
                    "Hexagonal Dumbells",
                    "Squared Dumbells",
                    "Kettlebells",
                    "Weighted Plates"
            );

    @FXML
    TabPane tabHolder;
    @FXML
    Tab tabProgram, tabExercises, tabMachines, tabEquipment;
    @FXML
    private
    ListView<Exercise> listviewMonday, listviewTuesday, listviewWednesday, listviewThursday, listviewFriday, listviewSaturday, listviewSunday;
    @FXML
    ListView listviewEquipment;
    @FXML
    Button buttonCreate_Program, buttonClose_Exercise, buttonClose_Machine, buttonClose_Equipment;
    @FXML
    private
    ComboBox<String> comboboxExperience;

    private Stage stage;

    private Controller mainController = null;
    private final MenuItem detailsMenuItem = new MenuItem("Details");


    private ProgramCreator program = null;

    /**
     * Sets the Main controller, meaning the one from the first windows eg. the GUI
     *
     * @param controller The main controller, not a window controller
     */
    public void setMainController(Controller controller) {
        this.mainController = controller;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        program = new ProgramCreator();
        comboboxExperience.setItems(experienceList);
        getEquipment();
        //Set days items list's
        listviewMonday.setItems(mondayList);
        listviewTuesday.setItems(tuesdayList);
        listviewWednesday.setItems(wednesdayList);
        listviewThursday.setItems(thursdayList);
        listviewFriday.setItems(fridayList);
        listviewSaturday.setItems(saturdayList);
        listviewSunday.setItems(sundayList);

        listviewEquipment.setItems(equipmentList);
        addListeners();


    }


    /**
     * Initializes the main GUI window.
     * Adds all necessary lists and listeners
     * Gets data from database
     */
    public void initializeGUI() {

    }


    /**
     * Adds listeners to the different TableView's
     * When a table item is selected the listeners will perform their specified action
     */
    private void addListeners() {
        tabHolder.getSelectionModel().selectedItemProperty().addListener(
                (ov, t, t1) -> {
                    if (t1.getId().equals(tabProgram.getId())) {
                        //dosomething


                    } else if (t1.getId().equals(tabExercises.getId())) {
                        //dosomething


                    } else if (t1.getId().equals(tabMachines.getId())) {
                        //dosomething


                    } else if (t1.getId().equals(tabEquipment.getId())) {
                        //dosomething

                    }


                }
        );

        comboboxExperience.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        });


        buttonCreate_Program.setOnAction(event -> createNewProgram());


    }

    private void getEquipment() {
        program.getEquipment();
    }

    private void createNewProgram() {

        mondayList.clear();
        tuesdayList.clear();
        wednesdayList.clear();
        thursdayList.clear();
        fridayList.clear();
        saturdayList.clear();
        sundayList.clear();

        int workoutLevel = comboboxExperience.getSelectionModel().getSelectedIndex();

        if (workoutLevel > -1) {
            System.out.println("creating");
            program.create(workoutLevel); //implement levels  ?

            //add newly created program to schedule
            mondayList.addAll(program.getMonday());
            tuesdayList.addAll(program.getTuesday());
            wednesdayList.addAll(program.getWednesday());
            thursdayList.addAll(program.getThursday());
            fridayList.addAll(program.getFriday());
            saturdayList.addAll(program.getSaturday());
            sundayList.addAll(program.getSunday());
        }
    }


    /********************************
     * Code For the Popup Windows
     ********************************/


    /**
     * Creates a Popup for equipment
     */
    public void showEquipment() {
        createDialog("/dialogs/dialogEquipment.fxml", "title");
    }

    /**
     * Creates a Popup for exercise
     */
    public void showExercise() {

        createDialog("/dialogs/dialogExercise.fxml", "title");

    }

    /**
     * Creates a Popup for machines
     */
    public void showMachine() {
        createDialog("/dialogs/dialogMachine.fxml", "title");

    }

    /**
     * Creates a Popup Dialog from the given fxml file
     *
     * @param fxmlFile - The fxml file with the Layout of the Popup
     */
    private void createDialog(String fxmlFile, String title) {
        VBox root;
        stage = new Stage();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Controller controller = new Controller();
            controller.setMainController(this.mainController);
            fxmlLoader.setController(controller);
            root = fxmlLoader.load();

            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(buttonCreate_Program.getScene().getWindow());
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Closes the dialog
     */
    public void closeEquipment() {

        stage = (Stage) buttonClose_Equipment.getScene().getWindow(); //change

        stage.close();


    }

    /**
     * Closes the dialog
     */
    public void closeExercise() {


        stage = (Stage) buttonClose_Exercise.getScene().getWindow(); //change

        stage.close();


    }

    /**
     * Closes the dialog
     */
    public void closeMachine() {

        stage = (Stage) buttonClose_Machine.getScene().getWindow(); //change

        stage.close();
    }


}
