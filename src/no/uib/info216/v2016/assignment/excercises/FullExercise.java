package no.uib.info216.v2016.assignment.excercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullExercise {

    private String name;
    private String MainMuscleWorked;
    private String Force;
    private String Level;
    private String mucleHeatmap;
    private String femaleImageEnd;
    private String femaleImageStart;
    private List<String> guide = new ArrayList<>();
    private String maleImageStart;
    private String Equipment;
    private String link;
    private String maleImageEnd;
    private String Sport;
    private String Type;
    private String MechanicsType;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public FullExercise() {
    }

    /**
     * @param name
     * @param guide
     * @param Equipment
     * @param femaleImageEnd
     * @param Type
     * @param link
     * @param MechanicsType
     * @param maleImageEnd
     * @param mucleHeatmap
     * @param Force
     * @param maleImageStart
     * @param MainMuscleWorked
     * @param femaleImageStart,
     * @param Level
     * @param Sport
     */
    public FullExercise(String name, String MainMuscleWorked, String Force, String Level, String mucleHeatmap, String femaleImageEnd, String femaleImageStart, List<String> guide, String maleImageStart, String Equipment, String link, String maleImageEnd, String Sport, String Type, String MechanicsType) {
        this.name = name;
        this.MainMuscleWorked = MainMuscleWorked;
        this.Force = Force;
        this.Level = Level;
        this.mucleHeatmap = mucleHeatmap;
        this.femaleImageEnd = femaleImageEnd;
        this.femaleImageStart = femaleImageStart;
        this.guide = guide;
        this.maleImageStart = maleImageStart;
        this.Equipment = Equipment;
        this.link = link;
        this.maleImageEnd = maleImageEnd;
        this.Sport = Sport;
        this.Type = Type;
        this.MechanicsType = MechanicsType;
    }

    @Override
    public String toString()
    {
        return String.format("%s: %s", this.name,this.link);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The MainMuscleWorked
     */
    public String getMainMuscleWorked() {
        return MainMuscleWorked;
    }

    /**
     *
     * @param MainMuscleWorked
     *     The Main Muscle Worked
     */
    public void setMainMuscleWorked(String MainMuscleWorked) {
        this.MainMuscleWorked = MainMuscleWorked;
    }

    public FullExercise withMainMuscleWorked(String MainMuscleWorked) {
        this.MainMuscleWorked = MainMuscleWorked;
        return this;
    }

    /**
     *
     * @return
     *     The Force
     */
    public String getForce() {
        return Force;
    }

    /**
     *
     * @param Force
     *     The Force
     */
    public void setForce(String Force) {
        this.Force = Force;
    }

    public FullExercise withForce(String Force) {
        this.Force = Force;
        return this;
    }

    /**
     *
     * @return
     *     The Level
     */
    public String getLevel() {
        return Level;
    }

    /**
     *
     * @param Level
     *     The Level
     */
    public void setLevel(String Level) {
        this.Level = Level;
    }

    public FullExercise withLevel(String Level) {
        this.Level = Level;
        return this;
    }

    /**
     *
     * @return
     *     The mucleHeatmap
     */
    public String getMucleHeatmap() {
        return mucleHeatmap;
    }

    /**
     *
     * @param mucleHeatmap
     *     The mucle_heatmap
     */
    public void setMucleHeatmap(String mucleHeatmap) {
        this.mucleHeatmap = mucleHeatmap;
    }

    public FullExercise withMucleHeatmap(String mucleHeatmap) {
        this.mucleHeatmap = mucleHeatmap;
        return this;
    }

    /**
     *
     * @return
     *     The femaleImageEnd
     */
    public String getFemaleImageEnd() {
        return femaleImageEnd;
    }

    /**
     *
     * @param femaleImageEnd
     *     The female_image_end
     */
    public void setFemaleImageEnd(String femaleImageEnd) {
        this.femaleImageEnd = femaleImageEnd;
    }

    public FullExercise withFemaleImageEnd(String femaleImageEnd) {
        this.femaleImageEnd = femaleImageEnd;
        return this;
    }

    /**
     *
     * @return
     *     The femaleImageStart
     */
    public String getFemaleImageStart() {
        return femaleImageStart;
    }

    /**
     *
     * @param femaleImageStart
     *     The female_image_start
     */
    public void setFemaleImageStart(String femaleImageStart) {
        this.femaleImageStart = femaleImageStart;
    }

    public FullExercise withFemaleImageStart(String femaleImageStart) {
        this.femaleImageStart = femaleImageStart;
        return this;
    }

    /**
     *
     * @return
     *     The guide
     */
    public List<String> getGuide() {
        return guide;
    }

    /**
     *
     * @param guide
     *     The guide
     */
    public void setGuide(List<String> guide) {
        this.guide = guide;
    }

    public FullExercise withGuide(List<String> guide) {
        this.guide = guide;
        return this;
    }

    /**
     *
     * @return
     *     The maleImageStart
     */
    public String getMaleImageStart() {
        return maleImageStart;
    }

    /**
     *
     * @param maleImageStart
     *     The male_image_start
     */
    public void setMaleImageStart(String maleImageStart) {
        this.maleImageStart = maleImageStart;
    }

    public FullExercise withMaleImageStart(String maleImageStart) {
        this.maleImageStart = maleImageStart;
        return this;
    }

    /**
     *
     * @return
     *     The Equipment
     */
    public String getEquipment() {
        return Equipment;
    }

    /**
     *
     * @param Equipment
     *     The Equipment
     */
    public void setEquipment(String Equipment) {
        this.Equipment = Equipment;
    }

    public FullExercise withEquipment(String Equipment) {
        this.Equipment = Equipment;
        return this;
    }

    /**
     *
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    public FullExercise withLink(String link) {
        this.link = link;
        return this;
    }

    /**
     *
     * @return
     *     The maleImageEnd
     */
    public String getMaleImageEnd() {
        return maleImageEnd;
    }

    /**
     *
     * @param maleImageEnd
     *     The male_image_end
     */
    public void setMaleImageEnd(String maleImageEnd) {
        this.maleImageEnd = maleImageEnd;
    }

    public FullExercise withMaleImageEnd(String maleImageEnd) {
        this.maleImageEnd = maleImageEnd;
        return this;
    }

    /**
     *
     * @return
     *     The Sport
     */
    public String getSport() {
        return Sport;
    }

    /**
     *
     * @param Sport
     *     The Sport
     */
    public void setSport(String Sport) {
        this.Sport = Sport;
    }

    public FullExercise withSport(String Sport) {
        this.Sport = Sport;
        return this;
    }

    /**
     *
     * @return
     *     The Type
     */
    public String getType() {
        return Type;
    }

    /**
     *
     * @param Type
     *     The Type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    public FullExercise withType(String Type) {
        this.Type = Type;
        return this;
    }

    /**
     *
     * @return
     *     The MechanicsType
     */
    public String getMechanicsType() {
        return MechanicsType;
    }

    /**
     *
     * @param MechanicsType
     *     The Mechanics Type
     */
    public void setMechanicsType(String MechanicsType) {
        this.MechanicsType = MechanicsType;
    }

    public FullExercise withMechanicsType(String MechanicsType) {
        this.MechanicsType = MechanicsType;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public FullExercise withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
