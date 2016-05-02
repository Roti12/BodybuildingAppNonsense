package no.uib.info216.assignment.main;

import no.uib.info216.assignment.GUI.GUI;
import no.uib.info216.assignment.dataset.Datasets;
import no.uib.info216.assignment.models.Models;

public class Main {

	static Datasets dataset;
	static Models model;
	
	public static void main(String [] args) {
		setup();
	}
	
	public static void setup() {
		System.out.println("Loading model..");
		GUI.getInstance();
		dataset = new Datasets();
		model = new Models();
		dataset.addModelToSet(model.addFileModel("MachinesAndExcercises.owl"), "Workout Planner");
	}
	
}

