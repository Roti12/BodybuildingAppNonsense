package no.uib.info216.v2016.assignment.excercises;

import no.uib.info216.v2016.assignment.SPARQLQueries.QueryItems;
import no.uib.info216.v2016.assignment.SPARQLQueries.strings.QueryStrings;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qrtmain on 18.05.2016.
 */
public class ProgramCreator {

    private List<Exercise> monday = null;
    private List<Exercise> tuesday = null;
    private List<Exercise> wednesday = null;
    private List<Exercise> thursday = null;
    private List<Exercise> friday = null;
    private List<Exercise> saturday = null;
    private List<Exercise> sunday = null;


    public ProgramCreator() {
        monday = new ArrayList<>();
        tuesday = new ArrayList<>();
        wednesday = new ArrayList<>();
        thursday = new ArrayList<>();
        friday = new ArrayList<>();
        saturday = new ArrayList<>();
        sunday = new ArrayList<>();

    }
    /* less than six months
    Quads – squats, lunges, one legged squats, box jumps.
     Butt and Hamstrings – hip raises, deadlifts, straight leg deadlifts, good mornings, step ups.
     Push (chest, shoulders, and triceps) – overhead press, bench press, incline dumbbell press, push ups, dips.
     Pull (back, biceps, and forearms) – chin ups, pull ups, inverse body weight rows, dumbbell rows.
     Core (abs and lower back) – planks, side planks, exercise ball crunches, mountain climbers, jumping knee tucks, hanging leg raises.
     Pick one exercise from each category above for a workout, and you’ll work almost every single muscle in your body.
     These are just a few examples for what you can do, but you really don’t need to make things more complicated than this.
     */

    public void create() {
        createMonday();
        for (Exercise e: monday
             ) {System.out.println(e);

        }
    }

    private void createMonday() {
        monday.add(getSquat());
        monday.add(getDeadlift());
        monday.add(getBenchPress());
        monday.add(getCableRow());
        monday.add(getBicepCurl());

    }

    private Exercise getSquat() {
        //	System.out.println("Hello, you have pressed a button");
        ResultSet result = QueryItems.queryOntology("Workout Planner", QueryStrings.querySquat);
        List<Resource> muscles = new ArrayList<>();
        Literal label = null;

        while (result.hasNext()) {
            QuerySolution binding = result.nextSolution();
            Resource muscle = (Resource) binding.get("Muscles");
            if(!muscles.contains(muscle)) {
                muscles.add(muscle);
            }
            label = binding.getLiteral("label");


        }
        return new Exercise("Squats", label, null, null, muscles);

    }

    private Exercise getDeadlift() {
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
            if(!muscles.contains(muscle)) {

                muscles.add(muscle);
            }
            equipment = (Resource) binding.get("Required_Equipment");
            Resource tempUse = null;
            label = binding.getLiteral("label");

            tempUse = (Resource) binding.get("Can_Use");
            if (tempUse.equals(can_use)) {
                break;
            }
            can_use = (Resource) binding.get("Can_Use");
            if(!can_useList.contains(can_use)) {

                can_useList.add(can_use);
            }

        }

        return new Exercise("Deadlift", label, equipment, can_useList, muscles);


    }

    private Exercise getBenchPress() {
        ResultSet result = QueryItems.queryOntology("Workout Planner", QueryStrings.queryBenchPress);
        List<Resource> can_useList = new ArrayList<>();

        Resource can_use;
        while (result.hasNext()) {

            // ResultSetFormatter.out(result);
            QuerySolution binding = result.nextSolution();

            can_use = (Resource) binding.get("Can_Use");

            can_useList.add(can_use);

        }

        return new Exercise("Bench Press", null, null, can_useList, null);
    }

    private Exercise getCableRow() {
        ResultSet result = QueryItems.queryOntology("Workout Planner", QueryStrings.querySeatedCableRowMachine);
        Literal label = null;

        while (result.hasNext()) {

            // ResultSetFormatter.out(result);
            QuerySolution binding = result.nextSolution();

            label = binding.getLiteral("label");


        }

        return new Exercise("Seated Cable Row", label, null, null, null);
    }


    private Exercise getBicepCurl() {
        ResultSet result = QueryItems.queryOntology("Workout Planner", QueryStrings.queryBicepCurl);
        List<Resource> can_useList = new ArrayList<>();
        List<Resource> muscles = new ArrayList<>();
        Literal label = null;
        Resource can_use;
        while (result.hasNext()) {

            // ResultSetFormatter.out(result);
            QuerySolution binding = result.nextSolution();
            label = binding.getLiteral("label");

            Resource muscle = (Resource) binding.get("Muscles");
            if(!muscles.contains(muscle)) {

                muscles.add(muscle);
            }

            can_use = (Resource) binding.get("Equipment");
            if(!can_useList.contains(can_use)) {

                can_useList.add(can_use);
            }

        }

        return new Exercise("Bicep Curls", label, null, can_useList, muscles);
    }
}
