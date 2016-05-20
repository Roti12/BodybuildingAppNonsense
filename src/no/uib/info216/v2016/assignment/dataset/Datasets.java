package no.uib.info216.v2016.assignment.dataset;

import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;
/**
 * Created by 117, 103.
 */
public class Datasets {

	private static Dataset dataset = TDBFactory.createDataset();
	
	public void addModelToSet(Model model, String name) {
		String namedGraphURI = name;
		dataset.addNamedModel(name, model);

		//dataset.getNamedModel(name).write(System.out, "TURTLE");
	}

	public static Dataset getDataset() {
		return dataset;
	}


}
