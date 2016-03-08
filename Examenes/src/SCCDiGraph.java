
import dataStructures.set.Set;

import java.util.Iterator;

import dataStructures.graph.DepthFirstTraversal;
import dataStructures.graph.DiGraph;
import dataStructures.graph.DictionaryDiGraph;
import dataStructures.set.HashSet;

public class SCCDiGraph {

	/*
	 * apartado A
	 */
	public static <v> DiGraph<v> reverseDiGraph(DiGraph<v> g) {
		DiGraph<v> reversedDiGraph = new DictionaryDiGraph<v>();
		// Vuestro Resultado aqui

		for (v ver : g.vertices()) {
			Set<v> sucs = g.successors(ver);
			for (v suc : sucs) {
				reversedDiGraph.addVertex(suc);
				reversedDiGraph.addVertex(ver);
				reversedDiGraph.addDiEdge(suc, ver);
			}
		}

		return reversedDiGraph;
	}

	/*
	 * apartado B
	 */

	
	public static <V> DiGraph<V> restrictDiGraph(DiGraph<V> g, Set<V> vs){
		DiGraph<V> restrictedGraph = new DictionaryDiGraph<V>();
		for(V v : g.vertices()){
			if(vs.isElem(v)){
				restrictedGraph.addVertex(v);
			}
		}
		for(V v : restrictedGraph.vertices()){
			for(V suc : g.successors(v)){
				if(vs.isElem(suc)){
					restrictedGraph.addDiEdge(v, suc);
				}
			}
		}
		return restrictedGraph;
	}

	/*
	 * apartado C
	 */
	public static <V> Set<V> sccOf(DiGraph<V> g, V src) {

		DepthFirstTraversal<V> graph = new DepthFirstTraversal<V>(reverseDiGraph(g),src);
		Iterable<V> it =  graph.vertices();		
		return iterableToSet(it);
	}

	/*
	 * apartado D
	 */
	
	public static <V> Set<Set<V>> stronglyConnectedComponentsDiGraph(DiGraph<V> graph) {
		Set<Set<V>> components  = new HashSet<Set<V>>();
		while(graph.numVertices()!=0){
			Iterator<V> it = graph.vertices().iterator();
			V vertice = it.next();
			Set<V> vs = sccOf(graph, vertice);
			components.insert(vs);
			DiGraph<V> graph2 = restrictDiGraph(graph, vs);
			for(V v : graph2.vertices()){
				for(V suc : graph.successors(v)){
					graph.deleteDiEdge(v, suc);
				}
			}
			for(V v : graph.vertices()){
				if(graph.successors(v).isEmpty()){
					graph.deleteVertex(v);
				}
			}
		}
		return components;
	}	
	
	static <V> Set<V> iterableToSet(Iterable<V> it) {
		Set<V> set = new HashSet<V>();
		for (V v : it)
			set.insert(v);
		return set;
	}

} 