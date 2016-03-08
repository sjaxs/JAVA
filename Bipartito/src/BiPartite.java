import dataStructures.dictionary.Dictionary;
import dataStructures.dictionary.HashDictionary;
import dataStructures.graph.Graph;
import dataStructures.stack.Stack;

public class BiPartite<V> {

	public class Pair<A, B> {
		private A a;
		private B b;

		public Pair(A x, B y) {
			a = x;
			b = y;
		}

		public A first() {
			return a;
		}

		public B second() {
			return b;
		}

		@Override
		public String toString() {
			return "Pair(" + a + "," + b + ")";
		}
	}

	public static enum Color {
		Red, Blue
	};

	private static Color nextColor(Color c) {
		return (c == Color.Blue) ? Color.Red : Color.Blue;
	}

	private Stack<Pair<V, Color>> stack; // stack with vertices and colors
	private Dictionary<V, Color> dict; // dictionary: vertex -> color
	private boolean biColored;

	public BiPartite(Graph<V> graph) {
		dict = new HashDictionary<V, Color>();
		stack = new StackList<Pair<V, Color>>();
		biColored = true;

		if (graph.numVertices() == 0)
			return; // empty graph is bipartite
		V src = graph.vertices().iterator().next(); // initial vertex
		stack.push(new Pair<V, Color>(src, Color.Red));
		while (!stack.isEmpty()) { // completad el bucle según el algoritmo descrito

			Pair<V, Color> vColor = stack.top();
			stack.pop();
			Color colorDic = dict.valueOf(vColor.first());
			if (colorDic == null) {
				dict.insert(vColor.first(), vColor.second());
				for (V v : graph.successors(vColor.first())) {
					stack.push(new Pair<V, Color>(v, nextColor(vColor.second())));
				}
			}

		}
	}
	
	 public boolean isBicolored() { // returns true if graph is bipartite    
		 return biColored;   
		 
	 }
	 public Dictionary<V,Color> biColored() { // returns color assignment     
		 return biColored ? dict : null;   
		 
	 }
	 }
}


