// Time Complexity: O(E+V)
// Space Coplexity : O(V)
// This is improved algorithm, It also checks if graph is DAG or not

import java.util.*;

class Graph {
	int v_num;
	List<Integer> adj[];

	Graph(int v_num) {
		this.v_num = v_num;
		adj = new LinkedList[v_num];
		for (int i = 0; i < v_num; i++)
			adj[i] = new LinkedList<>();
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < v_num; i++)
			result += i + " ==> " + adj[i] + "\n";
		return result;
	}

	void addEdge(int u, int v) {
		adj[u].add(0, v);
	}

	boolean topologicalSortUtil(int node, int visited[], Stack<Integer> stack) {
		visited[node] = 2;

		for (int v : adj[node]) {
			if (visited[v] == 0) {
				if (topologicalSortUtil(v, visited, stack)) {
					return true;
				}
			} else if (visited[v] == 2) {
				return true;
			}
		}

		stack.push(node);
		visited[node] = 1;
		return false;
	}

	void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		int visited[] = new int[v_num];

		for (int i = 0; i < v_num; i++) {
			if (visited[i] == 0) {
				if (topologicalSortUtil(i, visited, stack)) {
					System.out.println("The graph is not DAG");
					return;
				}
			}
		}

		// printing the oredering of the stack
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
}

public class TopologicalSortUsingDFS {
	public static void main(String[] args) {
		Graph graph = new Graph(7);

		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 5);
		// graph.addEdge(5, 4); //Egde causing cycle
		graph.addEdge(2, 5);
		graph.addEdge(5, 6);
		graph.addEdge(4, 2);

		System.out.println(graph);
		graph.topologicalSort();
	}
}