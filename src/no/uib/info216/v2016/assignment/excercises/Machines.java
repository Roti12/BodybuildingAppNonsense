package no.uib.info216.v2016.assignment.excercises;

import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cisse on 17.05.2016.
 */
public class Machines {

    private List<Resource> implementsExercise = null;
    private List<Resource> offers = null;

    private String name = null;
    private Literal definitionMachines = null;

    public Machines(String name, List<Resource> implementsExercise, List<Resource> offers, Literal definitionMachines   )
    {
        this.name = name;
        this.implementsExercise = implementsExercise;

        this.offers = offers;
        this.definitionMachines = definitionMachines;

    }

    @Override
    public String toString()
    {
        return String.format("Name: %s",this.name);
    }

    public void setImplementsExercise(List<Resource> implementsExercise) {
        this.implementsExercise = implementsExercise;
    }

    public void setOffers(List<Resource> offers) {
        this.offers = offers;
    }

    public void setDefinitionMachines(Literal definitionMachines) {
        this.definitionMachines = definitionMachines;
    }

    public List<Resource> getImplementsExercise() {

        return implementsExercise;
    }

    public List<Resource> getOffers() {
        return offers;
    }

    public Literal getDefinitionMachines() {
        return definitionMachines;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }


}
