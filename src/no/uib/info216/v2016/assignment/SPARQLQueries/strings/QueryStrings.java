package no.uib.info216.v2016.assignment.SPARQLQueries.strings;

public class QueryStrings {


	//Excercises

	public static String showAll = "PREFIX ont: <http://machine&excercises.com/ontology.owl#>"
			+ "SELECT * WHERE { ?x ?y ?z . }";

	public static String queryDeadlift = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Deadlift ont:Works ?Muscles ;"
			+ "ont:Requires ?Required_Equipment ;"
			+ "ont:label ?label ;"
			+ "ont:Can_Use ?Equipment . }";

	public static String querySquat = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Squat ont:Works ?Muscles ;"
			+ "ont:Can_Use ?Equipment ; "
			+ "ont:label ?label . }";

	public static String queryBenchPress = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:BenchPress ont:Works ?Muscles ;"
			+ "ont:Requires ?Required_Equipment ;"
			+ "ont:label ?label ;"
			+ "ont:Can_Use ?Equipment . }";

	public static String queryBicepCurl = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Bicep_Curl ont:label ?label ;"
			+ "ont:Works ?Muscles ;"
			+ "ont:Can_Use ?Equipment . }";

	public static String queryOverheadPress = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Overhead_press ont:Can_Use ?Equipment . }";

	public static String queryLPulldownMachine = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Lat_Pulldown_Machine ont:Implements ?Excercise . }";

	public static String querySeatedCableRow = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row ont:Can_Be_Performed_With ?Machine ;"
			+ "ont:Works ?Muscles ;"
			+ "ont:label ?label . }";

	public static String queryTricepExtension = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row ont:Works ?Muscles ;"
			+ "ont:Can_Be_Performed_With ?Equipment ;"
			+ "ont:label ?label . }";

	//Machines

	public static String queryAllMachines = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
			+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
			+ "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "?Machine rdf:type owl:NamedIndividual ;"
			+ 	 		"rdf:type ont:Machines ;"
			+ 			"ont:Implements ?Exercise ;"
			+  			"ont:label ?label . }";

	public static String queryCableCrossMachine = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row ont:Implements ?Exercises ;"
			+ "ont:label ?label . }";

	public static String queryLatPullMachine = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Lat_Pulldown_Machine ont:Implements ?Exercises ;"
			+ "ont:label ?label . }";

	public static String queryPreacherCurlMachine = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Preacher_Curl ont:Implements ?Exercises ;"
			+ "ont:label ?label . }";

	public static String querySeatedCableRowMachine = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Seated_Cable_Row_Machine ont:Implements ?Exercises ;"
			+ "ont:label ?label . }";



	/*********************
	 // Equipment
	 ***********************/
	public static String queryOlympiaBar = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Olympic_Barbell_Men ont:Is_Used_In ?Exercises ;"
			+ "ont:Weight ?weight ;"
			+ "ont:label ?label . }";

	public static String queryCapDumbbell = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Cap_Barbell_Dumbells ont:Is_Used_In ?Exercises ;"
			+ "ont:label ?label ;"
			+ "ont:Weight ?weight . }";


	public static String queryBench = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Bench ont:Is_Used_In ?Exercises ;"
			+ "ont:label ?label . }";

	public static String queryBenchPressRack = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Bench_Press_Rack ont:Is_Used_In ?Exercises ;"
			+ "ont:label ?label . }";

	public static String querySquatRack = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Squat_Rack ont:Is_Used_In ?Exercises ;"
			+ "ont:label ?label . }";

	public static String queryKettleBells = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Kettebells ont:Is_Used_In ?Exercises ;"
			+ "ont:label ?label ;"
			+ "ont:Weight ?weight . }";

	public static String queryWeightedPlates = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Weighted_Plates ont:Is_Used_In ?Exercises ;"
			+ "ont:label ?label ;"
			+ "ont:Weight ?weight . }";


	public static String queryHexDumbbell = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Hexagonal_Dumbells ont:Is_Used_In ?Exercises ;"
			+ "ont:label ?label ;"
			+ "ont:Weight ?weight . }";

	public static String queryRoundedDumbell = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Rounded_Dumbells ont:Is_Used_In ?Exercises ;"
			+ "ont:label ?label ;"
			+ "ont:Weight ?weight . }";

	public static String querySquaredDumbell = "PREFIX ont: <http://machinesandexercises.com/ontology.owl#>"
			+ "SELECT * WHERE {"
			+ "ont:Squared_Dumbells ont:Is_Used_In ?Exercises ;"
			+ "ont:label ?label ;"
			+ "ont:Weight ?weight . }";



}
