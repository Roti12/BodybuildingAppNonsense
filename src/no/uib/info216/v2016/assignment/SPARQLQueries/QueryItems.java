package no.uib.info216.v2016.assignment.SPARQLQueries;


import no.uib.info216.v2016.assignment.dataset.Datasets;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
/**
 * Created by 117, 103.
 */
public class QueryItems {

	
	public static ResultSet queryOntology(String queryString) {
		Model model = Datasets.getDataset().getNamedModel("Workout Planner");

		Query query = QueryFactory.create(queryString);

		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
			ResultSet results = qexec.execSelect();
			results = ResultSetFactory.copyResults(results);
			return results;    // Passes the result set out of the try-resources

		}
	}
	
}
