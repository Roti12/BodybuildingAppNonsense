package no.uib.info216.v2016.assignment.main;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import no.uib.info216.v2016.assignment.SPARQLQueries.QueryItems;
import no.uib.info216.v2016.assignment.SPARQLQueries.strings.QueryStrings;
import no.uib.info216.v2016.assignment.excercises.Equipment;
import no.uib.info216.v2016.assignment.excercises.Exercise;
import no.uib.info216.v2016.assignment.excercises.FullExercise;
import no.uib.info216.v2016.assignment.excercises.ProgramCreator;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * The controller for the GUI, handles all button presses and actions the GUI has to perform
 * Created by sto020 on 05.05.2016.
 *
 * @author sto020
 * @author can013
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

    private final ObservableList<Equipment> equipmentList =
            FXCollections.observableArrayList(

                    new Equipment("Bench"),
                    new Equipment("Bench Press Rack"),
                    new Equipment("Squat Rack"),
                    new Equipment("Olympic Barbell Men"),
                    new Equipment("Cap Barbell Dumbells"),
                    new Equipment("Rounded Dumbells"),
                    new Equipment("Hexagonal Dumbells"),
                    new Equipment("Squared Dumbells"),
                    new Equipment("Kettlebells"),
                    new Equipment("Weighted Plates")
            );
    private final ObservableList<Exercise> equipmentCanUseList =
            FXCollections.observableArrayList(
            );

    private final ObservableList<String> equipmentUseList =
            FXCollections.observableArrayList(
            );

    private final ObservableList<String> musclesList =
            FXCollections.observableArrayList(
            );


    @FXML
    private TabPane tabHolder;
    @FXML
    private Tab tabProgram, tabExercises, tabMachines, tabEquipment;
    @FXML
    private ListView<Exercise> listviewMonday, listviewTuesday, listviewWednesday, listviewThursday, listviewFriday, listviewSaturday, listviewSunday, listviewEquipmentUsedIn;
    @FXML
    private ListView<Equipment> listviewEquipment;
    @FXML
    private ListView<FullExercise> listviewFullExercises;
    @FXML
    private ListView<String> listviewExerciseMusclesWorked, listviewExerciseCanUse;
    @FXML
    private Label labelExerciseRequires;
    @FXML
    private TextArea textExerciseDefinition, textEquipmentDefinition, textEquipmentWeight, textEquipmentUsedIn;
    @FXML
    private Button buttonCreate_Program, buttonClose_Exercise, buttonClose_FullExercise, buttonClose_Machine, buttonClose_Equipment;
    @FXML
    private
    ComboBox<String> comboboxExperience;
    @FXML
    ImageView imageHeatmap;

    private Stage stage;
    private Controller mainController = null;
    private Exercise currentExerciseSelected;
    private FullExercise currentFullExerciseSelected;
    private Equipment currentEquipmentSelected;
    private ProgramCreator program = null;

    /**
     * Sets the Main controller, meaning the one from the first windows eg. the GUI
     *
     * @param controller The main controller, not a window controller
     */
    public void setMainController(Controller controller) {
        this.mainController = controller;
    }

    public void setCurrentExerciseSelected(Exercise currentExerciseSelected) {
        this.currentExerciseSelected = currentExerciseSelected;
    }
    public void setCurrentFullExerciseSelected(FullExercise currentFullExerciseSelected) {
        this.currentFullExerciseSelected = currentFullExerciseSelected;
    }


    public void setCurrentEquipmentSelected(Equipment currentEquipmentSelected) {
        this.currentEquipmentSelected = currentEquipmentSelected;
    }

    public void setListviewFullExercisesSource(ObservableList<FullExercise> exercises) {
        this.listviewFullExercises.setItems(exercises);
        setFullExerciseCellFactory(this.listviewFullExercises);
        setFullExerciseListener(this.listviewFullExercises);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    /**
     * Initializes the main GUI window.
     * Adds all necessary lists and listeners
     * Gets data from database
     */
    public void initializeGUI() {
        program = new ProgramCreator();

        comboboxExperience.setItems(experienceList);
        //getEquipment();


        setEquipmentListener(listviewEquipment);

        //Set days items list's
        listviewMonday.setItems(mondayList);
        setExerciseCellFactory(listviewMonday);
        setExerciseListener(listviewMonday);

        listviewTuesday.setItems(tuesdayList);
        setExerciseCellFactory(listviewTuesday);
        setExerciseListener(listviewTuesday);

        listviewWednesday.setItems(wednesdayList);
        setExerciseCellFactory(listviewWednesday);
        setExerciseListener(listviewWednesday);

        listviewThursday.setItems(thursdayList);
        setExerciseCellFactory(listviewThursday);
        setExerciseListener(listviewThursday);

        listviewFriday.setItems(fridayList);
        setExerciseCellFactory(listviewFriday);
        setExerciseListener(listviewFriday);

        listviewSaturday.setItems(saturdayList);
        setExerciseCellFactory(listviewSaturday);
        setExerciseListener(listviewSaturday);

        listviewSunday.setItems(sundayList);
        setExerciseCellFactory(listviewSunday);
        setExerciseListener(listviewSunday);


        listviewEquipment.setItems(equipmentList);
        setEquipmentCellFactory(listviewEquipment);


        addListeners();

    }

    public void initializeExerciseDialog() {
        addExerciseData(currentExerciseSelected);
    }


    public void initializeEquipmentDialog() {
        addEquipmentData();
    }

    public void initializeFullExerciseDialog() {
        addFullExerciseData();
    }

    /**
     * Will set the listviews cell to a custom exercise cell. this is to display the correct data.
     *
     * @param listview The listview to be customised
     */
    private void setExerciseCellFactory(ListView<Exercise> listview) {

        listview
                .setCellFactory(new Callback<ListView<Exercise>, ListCell<Exercise>>() {

                    public ListCell<Exercise> call(ListView<Exercise> param) {
                        final ContextMenu contextMenu = new ContextMenu();
                        final MenuItem detailsMenuItem = new MenuItem();

                        final Label leadLbl = new Label();
                        final Tooltip tooltip = new Tooltip();
                        final ListCell<Exercise> cell = new ListCell<Exercise>() {
                            @Override
                            public void updateItem(Exercise item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    leadLbl.setText(item.getName());
                                    setText(item.getName());
                                    if (item.getDescription() != null) {
                                        tooltip.setText(item.getDescription().getString());
                                    }
                                    setTooltip(tooltip);
                                }
                            }
                        }; // ListCell


                        detailsMenuItem.textProperty().bind(Bindings.format("Show \"%s\"", cell.itemProperty().getName()));
                        detailsMenuItem.setOnAction(event -> showExercise());

                        contextMenu.getItems().addAll(detailsMenuItem);

                        cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(contextMenu);
                            }
                        });
                        return cell;
                    }
                }); // setCellFactory
    }

    /**
     * Will set the listviews cell to a custom exercise cell. this is to display the correct data.
     *
     * @param listview The listview to be customised
     */
    private void setEquipmentCellFactory(ListView<Equipment> listview) {

        listview
                .setCellFactory(new Callback<ListView<Equipment>, ListCell<Equipment>>() {

                    public ListCell<Equipment> call(ListView<Equipment> param) {
                        final ContextMenu contextMenu = new ContextMenu();
                        final MenuItem detailsMenuItem = new MenuItem();

                        final Label leadLbl = new Label();
                        final Tooltip tooltip = new Tooltip();
                        final ListCell<Equipment> cell = new ListCell<Equipment>() {
                            @Override
                            public void updateItem(Equipment item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    leadLbl.setText(item.getName());
                                    setText(item.getName());
                                    if (item.getDefinition() != null) {
                                        tooltip.setText(item.getDefinition().getString());
                                    }
                                    setTooltip(tooltip);
                                }
                            }
                        }; // ListCell


                        detailsMenuItem.textProperty().bind(Bindings.format("Show \"%s\"", cell.itemProperty().getName()));
                        detailsMenuItem.setOnAction(event -> showExercise());

                        contextMenu.getItems().addAll(detailsMenuItem);

                        cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(contextMenu);
                            }
                        });
                        return cell;
                    }
                }); // setCellFactory
    }


    /**
     * Will set the listviews cell to a custom exercise cell. this is to display the correct data.
     *
     * @param listview The listview to be customised
     */
    private void setFullExerciseCellFactory(ListView<FullExercise> listview) {

        listview
                .setCellFactory(new Callback<ListView<FullExercise>, ListCell<FullExercise>>() {

                    public ListCell<FullExercise> call(ListView<FullExercise> param) {
                        final ContextMenu contextMenu = new ContextMenu();
                        final MenuItem detailsMenuItem = new MenuItem();

                        final Label leadLbl = new Label();
                        final Tooltip tooltip = new Tooltip();
                        final ListCell<FullExercise> cell = new ListCell<FullExercise>() {
                            @Override
                            public void updateItem(FullExercise item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    leadLbl.setText(item.getName());
                                    setText(item.getName());
                                    if (item.getGuide() != null) {
                                        tooltip.setText(item.getGuide().toString());
                                    }
                                    setTooltip(tooltip);
                                }
                            }
                        }; // ListCell


                        detailsMenuItem.textProperty().bind(Bindings.format("Show \"%s\"", cell.itemProperty().getName()));
                        detailsMenuItem.setOnAction(event -> showExercise());

                        contextMenu.getItems().addAll(detailsMenuItem);

                        cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(contextMenu);
                            }
                        });
                        return cell;
                    }
                }); // setCellFactory
    }

    /**
     * Will set the listviews listener to open correct window
     *
     * @param listview The listview to be listened
     */
    private void setFullExerciseListener(ListView<FullExercise> listview) {

        listview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            currentFullExerciseSelected = newValue;//Updates when item selection changed
        });

        listview.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    showFullExercise();
                }
            }
        });

    }

    /**
     * Will set the listviews listener to open correct window
     *
     * @param listview The listview to be listened
     */
    private void setExerciseListener(ListView<Exercise> listview) {

        listview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            currentExerciseSelected = newValue;//Updates when item selection changed
        });

        listview.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    showExercise();
                }
            }
        });

    }


    private void setEquipmentListener(ListView<Equipment> listview) {

        listview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            currentEquipmentSelected = newValue;//Updates when item selection changed
        });

        listviewEquipment.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    showEquipment(currentEquipmentSelected.getName());
                }
            }
        });
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


        buttonCreate_Program.setOnAction(event -> createNewProgram());


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
            program.create(workoutLevel); //create from level, based on input from user

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


    private Equipment searchEquipment() {
        String search = currentEquipmentSelected.getName();

        String query = null;

        if (search.equals("Bench Press Rack")) {
            query = QueryStrings.queryOlympiaBar;
        }
        if (search.equals("Squat Rack")) {
            query = QueryStrings.queryOlympiaBar;
        }
        if (search.equals("Olympic Barbell Men")) {
            query = QueryStrings.queryOlympiaBar;
        }
        if (search.equals("Cap Barbell Dumbells")) {
            query = QueryStrings.queryOlympiaBar;
        }
        if (search.equals("Rounded Dumbells")) {
            query = QueryStrings.queryOlympiaBar;
        }
        if (search.equals("Hexagonal Dumbells")) {
            query = QueryStrings.queryOlympiaBar;
        }
        if (search.equals("Squared Dumbells")) {
            query = QueryStrings.queryOlympiaBar;
        }
        if (search.equals("Kettlebells")) {
            query = QueryStrings.queryOlympiaBar;
        }
        if (search.equals("Weighted Plates")) {
            query = QueryStrings.queryOlympiaBar;
        }
        if (search.equals("Bench")) {
            query = QueryStrings.queryBenchPressRack;
        }if (search.equals("Squat Rack")) {
            query = QueryStrings.querySquatRack;
        }if (search.equals("Olympic Barbell Men")) {
            query = QueryStrings.queryOlympiaBar;
        }if (search.equals("Cap Barbell Dumbells")) {
            query = QueryStrings.queryCapDumbbell;
        }if (search.equals("Rounded Dumbells")) {
            query = QueryStrings.queryRoundedDumbell;
        }if (search.equals("Hexagonal Dumbells")) {
            query = QueryStrings.queryHexDumbbell;
        }if (search.equals("Squared Dumbells")) {
            query = QueryStrings.querySquaredDumbell;
        }if (search.equals("Kettlebells")) {
            query = QueryStrings.queryKettleBells;
        }if (search.equals("Weighted Plates")) {
            query = QueryStrings.queryWeightedPlates;
        }if (search.equals("Bench")) {
            query = QueryStrings.queryBench;
        }
        ResultSet result = QueryItems.queryOntology(query);
        List<Resource> is_used_in = new ArrayList<>();
        Literal weight = null;
        Literal label = null;

        while (result.hasNext()) {
            QuerySolution binding = result.nextSolution();
            Resource exercise = (Resource) binding.get("Exercises");
            if (!is_used_in.contains(exercise)) {
                is_used_in.add(exercise);
            }
            weight = binding.getLiteral("weight");
            try {
                label = binding.getLiteral("weight");
            } catch (Exception e) {
            }
        }



            return new Equipment(currentEquipmentSelected.getName(), is_used_in, label, weight);

    }

    /********************************
     * Code For the Popup Windows
     ********************************/


    /**
     * Creates a Popup for equipment
     */
    public void showEquipment(String title) {
        createDialog("../GUI/dialogs/dialogEquipment.fxml", title);
    }

    /**
     * Creates a Popup for exercise
     */
    public void showExercise() {

        createDialog("../GUI/dialogs/dialogExercise.fxml", currentExerciseSelected.getName());

    }

    /**
     * Creates a Popup for full exercise
     */
    public void showFullExercise() {

        createDialog("../GUI/dialogs/dialogFullExercise.fxml", currentFullExerciseSelected.getName());

    }

    /**
     * Creates a Popup for machines
     */
    public void showMachine() {
        createDialog("../GUI/dialogs/dialogMachine.fxml", "title");

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
            controller.setCurrentExerciseSelected(currentExerciseSelected);
            controller.setCurrentEquipmentSelected(currentEquipmentSelected);
            controller.setCurrentFullExerciseSelected(currentFullExerciseSelected);
            fxmlLoader.setController(controller);

            root = fxmlLoader.load();

            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(buttonCreate_Program.getScene().getWindow());


            if (fxmlFile.contains("dialogExercise.fxml")) controller.initializeExerciseDialog();
            if (fxmlFile.contains("dialogEquipment.fxml")) controller.initializeEquipmentDialog();
            if (fxmlFile.contains("dialogFullExercise.fxml")) controller.addFullExerciseData();


            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addExerciseData(Exercise data) {

        listviewExerciseMusclesWorked.setItems(musclesList);
        listviewExerciseCanUse.setItems(equipmentUseList);

        if (data.getMuscles() != null) {
            musclesList.addAll(data.getMuscles().stream().map(Resource::getLocalName).collect(Collectors.toList()));
        }

        if (data.getCan_use() != null) {
            equipmentUseList.addAll(data.getCan_use().stream().map(Resource::getLocalName).collect(Collectors.toList()));
        }

        if (data.getEquipment() != null) {
            labelExerciseRequires.setText(data.getEquipment().getLocalName());
        }
        if (data.getDescription() != null) {
            textExerciseDefinition.setText(data.getDescription().getString());
        }

        buttonClose_Exercise.setOnAction((EventHandler<ActionEvent>) event -> {
            closeExercise();
        });

    }

    private void addFullExerciseData() {

        imageHeatmap.setImage(new Image(currentFullExerciseSelected.getMucleHeatmap()));


        buttonClose_FullExercise.setOnAction((EventHandler<ActionEvent>) event -> {
            closeFullExercise();
        });

    }

    private void addEquipmentData() {


        listviewEquipmentUsedIn.setItems(equipmentCanUseList);

       currentEquipmentSelected = searchEquipment();

        if (currentEquipmentSelected.getDefinition() != null) {
            textEquipmentDefinition.setText(currentEquipmentSelected.getDefinition().getString());
        }

        if (currentEquipmentSelected.getUsed_in() != null) {
            equipmentCanUseList.addAll(currentEquipmentSelected.getUsed_in().stream().map(e -> new Exercise(e.getLocalName())).collect(Collectors.toList()));
        }
        if (currentEquipmentSelected.getWeight() != null) {

            textEquipmentWeight.setText(currentEquipmentSelected.getWeight().getString());
        }
        buttonClose_Equipment.setOnAction((EventHandler<ActionEvent>) event -> {
            closeExercise();
        });

    }

    /**
     * Closes the dialog
     */
    public void closeEquipment() {

        stage = (Stage) buttonClose_Equipment.getScene().getWindow();

        stage.close();


    }

    /**
     * Closes the dialog
     */
    public void closeExercise() {


        stage = (Stage) buttonClose_Exercise.getScene().getWindow();

        stage.close();


    }

    /**
     * Closes the dialog
     */
    public void closeFullExercise() {


        stage = (Stage) buttonClose_FullExercise.getScene().getWindow();

        stage.close();


    }

    /**
     * Closes the dialog
     */
    public void closeMachine() {

        stage = (Stage) buttonClose_Machine.getScene().getWindow();

        stage.close();
    }


}
