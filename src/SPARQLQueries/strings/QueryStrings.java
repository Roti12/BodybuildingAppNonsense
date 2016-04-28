package SPARQLQueries.strings;

public class QueryStrings {

	
	//Excercises
	
	public static String showAll = "PREFIX ont: <http://machine&excercises.com/ontology.owl#>"
			+ "SELECT * WHERE { ?x ?y ?z . }";
	
	public static String queryDeadlift = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Deadlift ont:Works ?Muscles ;"
			+ "ont:Requires ?Required_Equipment ;"
			+ "ont:label ?label ;"
			+ "ont:Can_Use ?Can_Use . }";
	
	public static String olympicBar = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Olympic_Barbell_Men ont:Is_Used_In ?z ;"
			+ "ont:Weight ?Weight . }";
	
	public static String querySquat = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Squat ont:Works ?Muscles ;"
			+ "ont:label ?label . }";
	
	public static String queryBenchPress = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:BenchPress ont:Can_Use ?Can_Use . }";
	
	public static String queryBicepCurl = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Bicep_Curl ont:label ?label ;"
			+ "ont:Works ?Muscles ;"
			+ "ont:Can_Use ?Equipment . }";
	
	public static String queryOverheadPress = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Overhead_press ont:Can_Use ?Equipment . }";
	
	public static String queryBench = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Bench ont:Is_Used_In ?Excercise . }";

	public static String queryLPulldownMachine = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Lat_Pulldown_Machine ont:Implements ?Excercise . }";
	
	public static String querySeatedCableRow = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row ont:Can_Be_Performed_With ?Machine ;"
			+ "ont:Works ?Muscles ;"
			+ "ont:label ?label . }";
	
	public static String queryTricepExtension = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row ont:Works ?Muscles ;"
			+ "ont:Can_Be_Performed_With ?Equipment ;"
			+ "ont:label ?label . }";
	
	//Machines
	
	public static String queryCableCrossMachine = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row ont:Offers ?Excercises ;"
			+ "ont:label ?label . }";
	
	public static String queryLatPullMachine = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row ont:Implements ?Excercises ;"
			+ "ont:label ?label . }";
	
	public static String queryPreacherCurlMachine = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row ont:Implements ?Excercises ;"
			+ "ont:label ?label . }";
	
	public static String querySeatedCableRowMachine = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row ont:Implements ?Excercises ;"
			+ "ont:label ?label . }";
	
	// Equipment
	
	public static String queryBenchPressRack = "PREFIX ont: <http://machines&excercises.com/ontology.owl#>" 
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row ont:Is_Used_In ?Excercises ;"
			+ "ont:label ?label . }";
	
}
