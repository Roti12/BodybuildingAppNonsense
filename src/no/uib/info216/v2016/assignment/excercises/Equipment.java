package no.uib.info216.v2016.assignment.excercises;

/**
 * Created by can013 on 17.05.2016.
 */
public class Equipment {


    private String name = null;

    private String used_in = null;
    private String definition = null;
    private double weight  =0.0;


    public Equipment(String name)
    {
        this.name = name;
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


    public String getUsed_in() {
        return used_in;
    }

    public void setUsed_in(String used_in) {
        this.used_in = used_in;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}
