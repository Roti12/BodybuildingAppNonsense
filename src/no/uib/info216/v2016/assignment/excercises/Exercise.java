package no.uib.info216.v2016.assignment.excercises;

import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;

import java.util.List;

/**
 * Created by sto020 on 03.05.2016.
 */
public class Exercise {


    private String name;
    private Literal description ;
    private Resource equipment;
    private List<Resource> can_use;
    private List<Resource> muscles;

    public Exercise(String name, Literal description, Resource equipment, List<Resource> can_use, List<Resource> muscles) {
        setName(name);
        setDescription(description);
        setEquipment(equipment);
        setCan_use(can_use);
        setMuscles(muscles);
    }


    @Override
    public String toString() {

        return String.format("%s", this.name);

      //  return String.format("%s: %s, %s, %s, %s", this.name, getMusclesString(), this.equipment, this.description, getCan_UseString());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Literal getDescription() {
        return description;
    }

    public void setDescription(Literal description) {
        this.description = description;
    }

    public Resource getEquipment() {
        return equipment;
    }

    public void setEquipment(Resource equipment) {
        this.equipment = equipment;
    }

    public List<Resource> getCan_use() {
        return can_use;
    }

    public void setCan_use(List<Resource> can_use) {
        this.can_use = can_use;
    }

    public List<Resource>  getMuscles() {
        return muscles;
    }

    public void setMuscles(List<Resource> muscles) {
        this.muscles = muscles;

    }
    public String getCan_UseString()
    {
        if (getCan_use() == null) return null;

        StringBuilder can_use = new StringBuilder();

        for (Resource s : getCan_use())
        {
            can_use.append(s.getLocalName() +", ");
        }
        return can_use.toString();
    }


    public String getMusclesString()
    {
        if (getMuscles() == null) return null;
        StringBuilder muscles = new StringBuilder();

        for (Resource s : getMuscles())
        {
            muscles.append(s.getLocalName() +", ");
        }
        return muscles.toString();
    }



}
