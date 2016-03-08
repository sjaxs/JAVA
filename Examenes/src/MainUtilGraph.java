import dataStructures.graph.DiGraph;
import dataStructures.graph.DictionaryDiGraph;
import dataStructures.graph.DictionaryGraph;
import dataStructures.graph.Graph;

public class MainUtilGraph {
	public static void main(String[] args) {

		Graph<String> g = new DictionaryGraph<String>();

		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
	
		g.addEdge("A", "B");
 		g.addEdge("A", "D");
 		g.addEdge("B", "C");
 		g.addEdge("B", "D");
 		g.addEdge("B", "E");
 		g.addEdge("C", "E");
 		g.addEdge("E", "F");
 		g.addEdge("F", "G");

 		
 		DiGraph<String> g1 = new DictionaryDiGraph<String>();

 		g1.addVertex("A");
 		g1.addVertex("B");
 		g1.addVertex("C");
		g1.addVertex("D");
		g1.addVertex("E");
		g1.addVertex("F");
		g1.addVertex("G");
		g1.addVertex("H");
	
		g1.addDiEdge("A", "B");
		g1.addDiEdge("B", "F");
		g1.addDiEdge("B", "E");
		g1.addDiEdge("C", "D");
		g1.addDiEdge("C", "G");
		g1.addDiEdge("D", "C");
		g1.addDiEdge("D", "H");
		g1.addDiEdge("E", "F");
		g1.addDiEdge("E", "A");
		g1.addDiEdge("F", "G");
		g1.addDiEdge("G", "F");
		g1.addDiEdge("H", "D");
		g1.addDiEdge("H", "G");

 		
		for (String v : g.vertices()) {
			System.out.println(v + " " + GraphUtilClase.eccentricity(g, v));
		}
		System.out.println(GraphUtilClase.diameter(g));
		
		System.out.println(SCCDiGraph.sccOf(g1, "A"));

		
		System.out.println(SCCDiGraph.stronglyConnectedComponentsDiGraph(g1));


	}
}
