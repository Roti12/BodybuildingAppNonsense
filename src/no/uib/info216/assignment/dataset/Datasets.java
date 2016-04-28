package no.uib.info216.assignment.dataset;

import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;

public class Datasets {

	private static Dataset dataset = TDBFactory.createDataset();
	
	public void addModelToSet(Model model, String name) {
		@SuppressWarnings("unused")
		String namedGraphURI = name;
		dataset.addNamedModel(name, model);

		// dataset.getNamedModel(name).write(System.out, "N-TRIPLE");
	}

	public static Dataset getDataset() {
		return dataset;
	}

	@SuppressWarnings("static-access")
	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}
	
}
