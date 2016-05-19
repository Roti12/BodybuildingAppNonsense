package no.uib.info216.v2016.assignment.excercises;

/**
 * Created by can013 on 17.05.2016.
 */

import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;

import java.util.List;

public class Equipment {


    private String name = null;

    private List<Resource> used_in = null;
    private Literal definition = null;
    private Literal weight  = null;


    public Equipment(String name, List<Resource> used_in, Literal definition, Literal weight)
    {
        this.name = name;
        this.used_in = used_in;
        this.definition = definition;
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return String.format("Name: %s",this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsed_in(List<Resource> used_in) {
        this.used_in = used_in;
    }

    public void setDefinition(Literal definition) {
        this.definition = definition;
    }

    public void setWeight(Literal weight) {
        this.weight = weight;
    }

    public List<Resource> getUsed_in() {

        return used_in;
    }

    public Literal getDefinition() {
        return definition;
    }

    public Literal getWeight() {
        return weight;
    }




}
