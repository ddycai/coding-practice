import java.util.*;

/**
 * Simple graph class kind of using adjacency list
 * Each node keeps list of its neighbours
 */
public class Graph {

	ArrayList<GraphNode> nodes;

	public Graph() {
		nodes = new ArrayList<>();
	}

	public List<GraphNode> getNodes() {
		return nodes;
	}

	/**
	 * Read a graph from standard input
	 */
	public static Graph readGraph() {
		Graph g = new Graph();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		for(int i = 0; i < n; i++)
			g.nodes.add(new Node(i));

		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			g.nodes.get(a).adj.add(g.nodes.get(b));
		}
		sc.close();
		return g;
	}

}
