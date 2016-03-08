/**
 * APELLIDOS :                         NOMBRE:
 *
 * TITULACION: .
 *
 * Computes Topological Sorting for DiGraphs
 */

package dataStructures.graph;


import dataStructures.dictionary.Dictionary;
import dataStructures.dictionary.HashDictionary;
import dataStructures.list.List;
import dataStructures.list.ArrayList;
import dataStructures.set.Set;
import dataStructures.set.HashSet;

public class TopologicalSortingDicPar<V> {

    private List<Set<V>> topSort;
    private boolean hasCycle;

    public TopologicalSortingDicPar(DiGraph<V> graph) {

        topSort = new ArrayList<Set<V>>();
        // dictionary: vertex -> # of pending predecessors
        Dictionary<V, Integer> pendingPredecessors = new HashDictionary<V, Integer>();
        Set<V> sources = new HashSet<V>();

        for(V v : graph.vertices()){
        	pendingPredecessors.insert(v,graph.inDegree(v));
        }
        while(!pendingPredecessors.isEmpty()&& !hasCycle){
        	for(V v : pendingPredecessors.keys()){
        		if(pendingPredecessors.valueOf(v)==0){
        			sources.insert(v);
        			
        		}
        	}
        	if(sources.isEmpty()){
        		hasCycle = true;
        	}else{
        		topSort.append(sources);
				for(V v:sources){
        			pendingPredecessors.delete(v);
        			for(V w : graph.successors(v)){
        				pendingPredecessors.insert(w, pendingPredecessors.valueOf(w)-1);
        			}
        			
				}
				sources = new HashSet<V>();
				
        	}
        	
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public List<Set<V>> order() {
        return hasCycle ? null : topSort;
    }

}
