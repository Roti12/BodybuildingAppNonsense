package no.uib.info216.v2016.assignment.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.uib.info216.v2016.assignment.excercises.Exercise;
import no.uib.info216.v2016.assignment.excercises.FullExercise;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {

    private static final String filePath = ".\\Full_Exercises.json";

    public static ObservableList<FullExercise> parse() {

        final ObservableList<FullExercise> exercises =
                FXCollections.observableArrayList(
                );

        try {
            // read the json file
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
            int count = 0;
            for (int i = 0; i < jsonArray.size(); i++) {
                // System.out.println("The " + i + " element of the array:
                // "+jsonArray.get(i));

                count++;
                String innerObj = remove(jsonArray.get(i).toString());
                String[] objects = innerObj.split("[:]+", 2);
                JSONArray innerObjArray = (JSONArray) jsonParser.parse(objects[1]);

                // System.out.println(jsonObject.toString());

                Iterator<?> i1 = innerObjArray.iterator();

                // take each value from the json array separately
                while (i1.hasNext()) {
                    JSONObject innerObj2 = (JSONObject) i1.next();


                    String name = objects[0].substring(1, objects[0].length() - 1);
                    String link = (innerObj2.get("link").toString());
                    String mainMuscles = (innerObj2.get("Main Muscle Worked").toString());
                    String sport = (innerObj2.get("Sport").toString());
                    String otherMuscles = null;
                    try {
                        otherMuscles = (innerObj2.get("Other Muscles").toString());
                    } catch (NullPointerException nil) {
//nada
                    }
                    String mechanicsType = (innerObj2.get("Mechanics Type").toString());
                    String type = (innerObj2.get("Type").toString());
                    String level = (innerObj2.get("Level").toString());
                    String equipment = (innerObj2.get("Equipment").toString());
                    String force = (innerObj2.get("Force").toString());
                    String imageMaleStart = (innerObj2.get("male_image_start").toString());
                    String imageMaleEnd = (innerObj2.get("male_image_end").toString());
                    String imageFemaleStart = (innerObj2.get("female_image_start").toString());
                    String imagefemaleEnd = (innerObj2.get("female_image_end").toString());
                    String heatmap = (innerObj2.get("mucle_heatmap").toString());
                    String guide = (innerObj2.get("guide").toString().substring(1,
                            innerObj2.get("guide").toString().length() - 1));
                    List<String> guideList = new ArrayList<>();

//fix guide to fit array
                    for (String s : guide.split("\",\"")) {
                        s = s.replace("\"", "");
                        s = s.replace("\\r\\n", "");

                        s = s.trim();
                        guideList.add(s);

                    }


                    exercises.add(new FullExercise(name, mainMuscles, force, level, heatmap, imagefemaleEnd, imageFemaleStart, guideList, imageMaleStart, equipment, link, imageMaleEnd, sport, type, mechanicsType));

                }

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return exercises;
    }

    public static String remove(String str) {
        if (str.length() > 0) {
            str = str.substring(1, str.length() - 1);

        }

        return str;
    }

}