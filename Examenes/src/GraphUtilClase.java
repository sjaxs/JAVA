/** ------------------------------------------------------------------------------
  * Estructuras de Datos. 2º Curso. ETSI Informática. UMA
  *
  * Control del día 11-2-2013
  * 
  * Diámetro de un grafo conexo 
  *
  * (completa y sustituye los siguientes datos)
  * Titulación: Grado en Ingeniería …………………………………… [Informática | del Software | de Computadores].
  *
  * Alumno: APELLIDOS, NOMBRE
  *
  * -------------------------------------------------------------------------------
  */

import java.util.Iterator;

import dataStructures.graph.BreadthFirstTraversal;
import dataStructures.graph.Graph;

public class GraphUtilClase {

	/**
	 * LENGTH: Calcula el número de elementos que contiene un iterable
	 * 
	 * @param it  El iterador
	 * @return   Número de elementos en el iterador
	 */
	@SuppressWarnings("unused")
	public static <T> int length(Iterable<T> it) {
		int num = -1;
		
		for(T t : it){
			num++;
		}
		
		return num;
	}

	/**
	 * ECCENTRICITY: Calcula la excentricidad de un vértice en un grafo El algoritmo toma la
	 * longitud del camino máximo en un recorrido en profundidad del grafo
	 * comenzando en el vértice dado.
	 * 
	 * @param graph    Grafo
	 * @param v        Vértice del grafo
	 * @return         Excentricidad del vértice
	 */
	public static <T> int eccentricity(Graph<T> graph, T v) {

		BreadthFirstTraversal g = new BreadthFirstTraversal(graph,v);
		
		Iterable it = g.paths();
		int ecc = 0;
		
		Iterator iter = it.iterator();

		while(iter.hasNext()){
			Iterable next = (Iterable) iter.next();
			if(length(next) >= ecc){
				ecc =  length(next);
			}
			
		}
		
		return ecc;
	}

	/**
	 * DIAMETER: Se define como la máxima excentricidad de los vértices del grafo.
	 * 
	 * @param graph
	 * @return
	 */

	public static <T> int diameter(Graph<T> graph) {
		int diameter = 0; 
		for(T v : graph.vertices()){
			if(eccentricity(graph,v) >= diameter){
				diameter = eccentricity(graph,v);
			}
		}
		return diameter;
	}
	
	/** 
	 * Estima y justifica la complejidad del método diameter
	 */
}
