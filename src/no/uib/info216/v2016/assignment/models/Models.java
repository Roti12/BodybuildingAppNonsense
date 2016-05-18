package no.uib.info216.v2016.assignment.models;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;


public class Models {
	
	private Model testModel = ModelFactory.createDefaultModel();
	
	public Model addFileModel(String path) {
		FileManager.get().addLocatorClassLoader(Models.class.getClassLoader());
		testModel = FileManager.get().loadModel(path);
		
		return testModel;
	}
	
}
