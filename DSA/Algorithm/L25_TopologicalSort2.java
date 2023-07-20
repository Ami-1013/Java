
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class GraphNode3{

	public String name;
	public int index;
	public boolean isVisited = false;	// for traversal

	public GraphNode3(String name, int index){
		this.name = name;
		this.index = index;
	}
} 

class Graph5{ 

	ArrayList<GraphNode3> nodeList = new ArrayList<>();
	int[][] adjacencyMatrix;	


	public Graph5(ArrayList<GraphNode3> nodeList){
		this.nodeList = nodeList;
		this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];	// default value in int Array is zero.
	}


	public void addUndirectedEdge(int index1, int index2){

		if (index1 == index2){
			System.out.println("A graphNode can't be connected to it self.");
		}

		adjacencyMatrix[index1][index2] = 1;
		adjacencyMatrix[index2][index1] = 1;	
	}

	public String toString(){

		StringBuilder s = new StringBuilder();
		s.append("   ");

		for(int i=0; i<this.nodeList.size(); ++i){
			s.append(nodeList.get(i).name + " ");
		}

		s.append("\n");
		for(int i=0; i<this.nodeList.size(); ++i){
			s.append(this.nodeList.get(i).name + ": ");
			for(int j: this.adjacencyMatrix[i]){
				s.append((j) + " ");
			}
			s.append("\n");
		}

		return s.toString();
	}

	// get neighbor
	public ArrayList<GraphNode3> getNeighbors (GraphNode3 node){
		ArrayList<GraphNode3> neighbors = new ArrayList<>();
		int nodeIndex = node.index;

		for (int i=0; i<this.adjacencyMatrix.length; ++i){	// in 2-D matrix no. of row = coloums.
			if (this.adjacencyMatrix[nodeIndex][i] == 1){
				neighbors.add(this.nodeList.get(i));	
			}
		}
		return neighbors;
	}

	// Graph traversal ------------------------------------------
	
	// BSF internal
	void bfsVisit (GraphNode3 node){
		LinkedList<GraphNode3> queue = new LinkedList<GraphNode3>();
		queue.add(node);

		while(!queue.isEmpty()){
			GraphNode3 currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");

			ArrayList<GraphNode3> neighbors = this.getNeighbors(currentNode);
			for(GraphNode3 neighbor: neighbors){
				if (!neighbor.isVisited){
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
			// tc - O(V+E)	&	sc - O(V+E) , where V= vertices and E = edges.
		}
	}

	public void bfs(){
		for (GraphNode3 node: this.nodeList){
			if (!node.isVisited){
				bfsVisit(node);
			
			}
		}
	}

	void dfsVisit(GraphNode3 node){
		Stack<GraphNode3> stack = new Stack<>();
		stack.push(node);

		while(!stack.isEmpty()){
			GraphNode3 currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");

			ArrayList<GraphNode3> neighbors = this.getNeighbors(currentNode);
			for (GraphNode3 neighbor : neighbors){
				if (!neighbor.isVisited){
					stack.push(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	// tc - O(V+E)	&	sc - O(V+E),	where V is vertics and E is edges of graph.
	}

	void dfs(){
		for (GraphNode3 node: this.nodeList){
			if (!node.isVisited){
				dfsVisit(node);
			}
		}
	}

	// Topological Sort
	public void addDirectedEdge(int from, int to){
		this.adjacencyMatrix[from][to] = 1;		// position of 'from' and 'to' is important for right edge direction.
	}

	void topologicalVisit(GraphNode3 node, Stack<GraphNode3> stack){
		ArrayList<GraphNode3> neighbors = getNeighbors(node);

		for (GraphNode3 neighbor: neighbors){
			if (!neighbor.isVisited){
				topologicalVisit(neighbor, stack);
			}
		}

		node.isVisited = true;
		stack.push(node);
	}

	void topologicalSort(){
		Stack<GraphNode3> stack = new Stack<>();
		for (GraphNode3 node : this.nodeList){
			if (!node.isVisited){
				topologicalVisit(node, stack);
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().name + " ");
		}
	}


}

public class L25_TopologicalSort2{
	public static void main(String[] args){

		ArrayList<GraphNode3> nodeList = new ArrayList<>();
		nodeList.add(new GraphNode3("A", 0));
		nodeList.add(new GraphNode3("B", 1));
		nodeList.add(new GraphNode3("C", 2));
		nodeList.add(new GraphNode3("D", 3));
		nodeList.add(new GraphNode3("E", 4));
		nodeList.add(new GraphNode3("F", 5));
		nodeList.add(new GraphNode3("G", 6));
		nodeList.add(new GraphNode3("H", 7));

		Graph5 g = new Graph5(nodeList);
		
		g.addDirectedEdge(0, 2);
		g.addDirectedEdge(2, 4);
		g.addDirectedEdge(4, 7);
		g.addDirectedEdge(4, 5);
		g.addDirectedEdge(5, 6);
		g.addDirectedEdge(1, 2);
		g.addDirectedEdge(1, 3);
		g.addDirectedEdge(3, 5);

		System.out.println(g.toString());
		g.topologicalSort();
	


	}
}
