import java.util.*;

public class GraphNode {

	ArrayList<Node> adj;
	int element;
	boolean marked;

	public GraphNode(int element) {
		adj = new ArrayList<>();
		this.element = element;
		marked = false;
	}

	public List<Node> getAdjacent() {
		return adj;
	}

	public String toString() {
		return element + "";
	}

}
