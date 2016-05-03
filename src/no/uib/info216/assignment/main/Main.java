package no.uib.info216.assignment.main;

import no.uib.info216.assignment.GUI.GUI;
import no.uib.info216.assignment.GUI.PopupEquipment;
import no.uib.info216.assignment.GUI.PopupExercises;
import no.uib.info216.assignment.SPARQLQueries.QueryItems;
import no.uib.info216.assignment.SPARQLQueries.strings.QueryStrings;
import no.uib.info216.assignment.dataset.Datasets;
import no.uib.info216.assignment.excercises.Exercise;
import no.uib.info216.assignment.models.Models;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static Datasets dataset;
    static Models model;
    private static PopupExercises popEx;
    private static PopupEquipment popEq;

    public static void main(String[] args) {
        setup();
    }

    public static void setup() {
        System.out.println("Loading model..");
        GUI.getInstance();
        dataset = new Datasets();
        model = new Models();
        dataset.addModelToSet(model.addFileModel("MachinesAndExcercises.owl"), "Workout Planner");
        appendActions();

    }

    public static void appendActions() {


        MouseClicks(GUI.getInstance().getEquipmentList());


        GUI.getInstance().getDeadliftButton().addActionListener(e ->{


                //	System.out.println("Hello, you have pressed a button");
                ResultSet result = QueryItems.queryOntology("Workout Planner", QueryStrings.queryDeadlift);
                List<Resource> muscles = new ArrayList<>();
                List<Resource> can_useList = new ArrayList<>();

                Resource equipment = null;
                Literal label = null;
                Resource can_use = null;
                while (result.hasNext()) {
                    //ResultSetFormatter.out(result);
                    QuerySolution binding = result.nextSolution();

                    Resource muscle = (Resource) binding.get("Muscles");
                    muscles.add(muscle);
                    equipment = (Resource) binding.get("Required_Equipment");

                    label = binding.getLiteral("label");

                    can_use = (Resource) binding.get("Can_Use");

                    can_useList.add(can_use);

                }

                Exercise exercise = new Exercise(label, equipment, can_useList, muscles);
                System.out.println(exercise);
                popEx = new PopupExercises("Deadlift",exercise);


            });


        GUI.getInstance().getSquatButton().addActionListener(e ->{

                //	System.out.println("Hello, you have pressed a button");
                ResultSet result = QueryItems.queryOntology("Workout Planner", QueryStrings.querySquat);
                List<Resource> muscles = new ArrayList<>();
                Literal label = null;

                while (result.hasNext()) {
                    // ResultSetFormatter.out(result);
                    QuerySolution binding = result.nextSolution();

                    Resource muscle = (Resource) binding.get("Muscles");
                    muscles.add(muscle);

                    label = binding.getLiteral("label");


                }

                Exercise exercise = new Exercise(label, null, null, muscles);
                System.out.println(exercise);
                popEx = new PopupExercises("Squat", exercise);



        });

        GUI.getInstance().getBenchPressButton().addActionListener(e -> {
                //	System.out.println("Hello, you have pressed a button");
                ResultSet result = QueryItems.queryOntology("Workout Planner", QueryStrings.queryBenchPress);
                List<Resource> can_useList = new ArrayList<>();

                Resource can_use;
                while (result.hasNext()) {

                   // ResultSetFormatter.out(result);
                    QuerySolution binding = result.nextSolution();

                    can_use = (Resource) binding.get("Can_Use");

                    can_useList.add(can_use);

                }

                Exercise exercise = new Exercise(null, null, can_useList, null);
                System.out.println(exercise);
                popEx = new PopupExercises("Benchpress",exercise);



        });


    }

    public static void MouseClicks(Object e) {
        ((Component) e).addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (e.getSource() == GUI.getInstance().getEquipmentList()) {
                        String x = e.getComponent().toString().substring(41);
                        String y = x.substring(0, x.length() - 1);
                        popEq = new PopupEquipment(y);
                    }
                }
            }

        });
    }
}



