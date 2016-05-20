package no.uib.info216.v2016.assignment.excercises;

import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 117,103 on 17.05.2016.
 */
public class Machine {

    private List<Resource> implementsExercise = null;

    private String name = null;
    private Literal definitionMachines = null;

    public Machine(String name, List<Resource> implementsExercise, Literal definitionMachines   )
    {
        this.name = name;
        this.implementsExercise = implementsExercise;

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


    public void setDefinitionMachines(Literal definitionMachines) {
        this.definitionMachines = definitionMachines;
    }

    public List<Resource> getImplementsExercise() {

        return implementsExercise;
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
