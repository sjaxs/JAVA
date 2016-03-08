package demos.graph;

import dataStructures.graph.BreadthFirstTraversal;
import dataStructures.graph.DepthFirstTraversal;
import dataStructures.graph.DiGraph;
import dataStructures.graph.DictionaryDiGraph;
import dataStructures.graph.Traversal;

public class DiGraphDemo {
	public static void main(String[] args) {
		DiGraph<Integer> g = new DictionaryDiGraph<>();

		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);

		g.addDiEdge(1, 2);
		g.addDiEdge(1, 5);
		g.addDiEdge(2, 5);
		g.addDiEdge(3, 1);
		g.addDiEdge(3, 2);
		g.addDiEdge(3, 6);
		g.addDiEdge(5, 3);
		g.addDiEdge(5, 4);
		g.addDiEdge(6, 7);

		Traversal<Integer> dfs = new DepthFirstTraversal<>(g, 1);
		System.out.println("DF traversal from node 1:");
		for (Integer vertex : dfs.vertices())
			System.out.println(vertex);

		System.out.println("DF paths traversal from node 1:");
		for (Iterable<Integer> path : dfs.paths())
			System.out.println(path);

		Traversal<Integer> bfs = new BreadthFirstTraversal<>(g, 1);
		System.out.println("BF traversal from node 1:");
		for (Integer vertex : dfs.vertices())
			System.out.println(vertex);

		System.out.println("BF paths traversal from node 1:");
		for (Iterable<Integer> path : bfs.paths())
			System.out.println(path);
	}
}
