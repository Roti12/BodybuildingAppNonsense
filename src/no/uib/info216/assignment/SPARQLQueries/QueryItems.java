package no.uib.info216.assignment.SPARQLQueries;



import no.uib.info216.assignment.dataset.Datasets;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

public class QueryItems {

	
	public static ResultSet queryOntology(String modelName, String queryString) {
		Model model = Datasets.getDataset().getNamedModel("Workout Planner");

		Query query = QueryFactory.create(queryString);

		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
			ResultSet results = qexec.execSelect();
			results = ResultSetFactory.copyResults(results);
			return results;    // Passes the result set out of the try-resources

		}
	}
	
}
