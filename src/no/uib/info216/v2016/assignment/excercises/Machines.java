package no.uib.info216.v2016.assignment.excercises;

import java.util.ArrayList;

/**
 * Created by cisse on 17.05.2016.
 */
public class Machines {

    private String implementsExercise = null;
    private String offers = null;
    //private ArrayList<Exercise> offers = null;

    private String name = null;
    private String definitionMachines = null;

    public Machines(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return String.format("Name: %s",this.name);
    }

    public void setImplementsExercise(String implementsExercise) {
        this.implementsExercise = implementsExercise;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefinitionMachines(String definitionMachines) {
        this.definitionMachines = definitionMachines;
    }

    public String getImplementsExercise() {

        return implementsExercise;
    }

    public String getOffers() {
        return offers;
    }

    public String getName() {
        return name;
    }

    public String getDefinitionMachines() {
        return definitionMachines;
    }

}
