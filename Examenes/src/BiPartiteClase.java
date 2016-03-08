/**
 *Data Structures, Grado en Inform‡tica. UMA.
 *
 * Control 2. 13-Febrero-2012
 * Estudio de grafos bipartitos por coloreado con búsqueda en profundidad
 */


import dataStructures.dictionary.Dictionary;
import dataStructures.dictionary.HashDictionary;
import dataStructures.graph.Graph;
import dataStructures.stack.Stack;
import dataStructures.stack.LinkedStack;



public class BiPartiteClase<V> {
	
	class Pair<A,B> {
        private A a;
        private B b;
        public Pair(A x, B y) { a = x; b = y; }
        public A first() { return a; }
        public B second() { return b; }
        @Override public String toString() { return "Pair("+a+","+b+")"; }
      }
	public static enum Color {Red, Blue;}

	private static Color nextColor(Color c) {
		return (c == Color.Blue) ?Color.Red:Color.Blue; 
	}
	
	private Stack<Pair<V,Color>> stack; // stack with pair of vertex and color
	private Dictionary<V,Color> dict; // dictionary: Vertices -> Color
	private boolean isBiColored;

	public BiPartiteClase(Graph<V> graph) {
		dict      = new HashDictionary<V, Color>();
		stack = new LinkedStack<Pair<V,Color>>();
		isBiColored       = true;
		if (graph.numVertices() == 0)
			return; 

		V src = graph.vertices().iterator().next(); // initial vertex
		
		stack.push(new Pair<V,Color>(src,Color.Red));
		
		while (!stack.isEmpty() && isBiColored) {
			Pair<V,Color> vColor = stack.top();
			stack.pop();
			// COMPLETAR
			if(!dict.isDefinedAt(vColor.first())){
				dict.insert(vColor.first(), vColor.second());
				for (V v : graph.successors(vColor.first())){
				//	if(!dict.isDefinedAt(v)){
						stack.push(new Pair<V,Color>(v,nextColor(vColor.second())));
					//}
				}
			}else if(dict.valueOf(vColor.first()) != vColor.second()){
				isBiColored = false;
			}
		} 
	}	
	
	public Dictionary<V,Color> biColored() {
		return dict;
	}
	
	public boolean isBicolored() {
		return isBiColored;
	}
	
}
