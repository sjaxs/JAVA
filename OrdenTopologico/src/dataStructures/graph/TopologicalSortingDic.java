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
import dataStructures.queue.Queue;
import dataStructures.queue.LinkedQueue;

public class TopologicalSortingDic<V> {

	private List<V> topSort;
	private boolean hasCycle;

	public TopologicalSortingDic(DiGraph<V> graph) {
		hasCycle = false;
        topSort = new ArrayList<V>();
        // dictionary: vertex -> # of pending predecessors
        Dictionary<V, Integer> pendingPredecessors = new HashDictionary<V, Integer>();
        Queue<V> sources = new LinkedQueue<V>();
        for(V v : graph.vertices()){
        	pendingPredecessors.insert(v,graph.inDegree(v));
        }
        while(!pendingPredecessors.isEmpty()&& !hasCycle){
        	for(V v : pendingPredecessors.keys()){
        		if(pendingPredecessors.valueOf(v)==0){
        			sources.enqueue(v);
        			
        		}
        	}
        	if(sources.isEmpty()){
        		hasCycle = true;
        	}else{
        		
				while(!sources.isEmpty()){
        			pendingPredecessors.delete(sources.first());
        			topSort.append(sources.first());
        			for(V w : graph.successors(sources.first())){
        				pendingPredecessors.insert(w, pendingPredecessors.valueOf(w)-1);
        			}
        			sources.dequeue();
				}
        	}
        	
        }
     }

	public boolean hasCycle() {
		return hasCycle;
	}

	public List<V> order() {
		return hasCycle ? null : topSort;
	}
}
