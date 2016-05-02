package no.uib.info216.assignment.SPARQLQueries;



import no.uib.info216.assignment.dataset.Datasets;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;

public class QueryItems {

	
	public static void queryOntology(String modelName, String queryString) {
		Model model = Datasets.getDataset().getNamedModel("http://test.com");
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
		ResultSet result = qexec.execSelect();
		while(result.hasNext()) {
			ResultSetFormatter.out(result);
		}
		} finally {
			qexec.close();
		}
	}
	
}
