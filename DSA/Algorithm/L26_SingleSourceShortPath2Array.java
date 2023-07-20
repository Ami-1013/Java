
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class GraphNode{

	public String name;
	public int index;
	public boolean isVisited = false;	// for traversal
	public GraphNode parent;

	public GraphNode(String name, int index){
		this.name = name;
		this.index = index;
	}
} 

class Graph{

	ArrayList<GraphNode> nodeList = new ArrayList<>();
	int[][] adjacencyMatrix;	


	public Graph(ArrayList<GraphNode> nodeList){
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

	// get neighbors
	public ArrayList<GraphNode> getNeighbors (GraphNode node){
		ArrayList<GraphNode> neighbors = new ArrayList<>();
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
	void bfsVisit (GraphNode node){
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);

		while(!queue.isEmpty()){
			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");

			ArrayList<GraphNode> neighbors = this.getNeighbors(currentNode);
			for(GraphNode neighbor: neighbors){
				if (!neighbor.isVisited){
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
			// tc - O(V+E)	&	sc - O(V+E) , where V= vertices and E = edges.
		}
	}

	public void bfs(){
		for (GraphNode node: this.nodeList){
			if (!node.isVisited){
				bfsVisit(node);
			}
		}
	}

	void dfsVisit(GraphNode node){
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);

		while(!stack.isEmpty()){
			GraphNode currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");

			ArrayList<GraphNode> neighbors = this.getNeighbors(currentNode);
			for (GraphNode neighbor : neighbors){
				if (!neighbor.isVisited){
					stack.push(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	// tc - O(V+E)	&	sc - O(V+E),	where V is vertics and E is edges of graph.
	}

	void dfs(){
		for (GraphNode node: this.nodeList){
			if (!node.isVisited){
				dfsVisit(node);
			}
		}
	}

	// ******************* Single Source Short Path **********************************
	public void addDirectedEdge(int from, int to){
		this.adjacencyMatrix[from][to] = 1;		// position of 'from' and 'to' is important for right edge direction.
	}


	public void printPath(GraphNode node){
		if (node.parent != null){
			printPath(node.parent);
		}

		System.out.print(node.name + " ");
	}

	public void BFSForSSSPP(GraphNode node){
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(node);

		while(!queue.isEmpty()){
			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print("Printing path for node " + currentNode.name + ": ");
			printPath(currentNode);

			System.out.println();

			ArrayList<GraphNode> neighbors = new ArrayList<>();
			neighbors = this.getNeighbors(currentNode);

			for (GraphNode neighbor : neighbors){
				if (!neighbor.isVisited){
					neighbor.parent = currentNode;
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			} 

		}
		// t.c - O(V * adj) = O(E)	&	s.c - O(V), where v= vertices, adj = adjacent, E = edges.
	}

}


public class L26_SingleSourceShortPath2Array{
	public static void main(String[] args){

		ArrayList<GraphNode> nodeList = new ArrayList<>();

        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));

		Graph g = new Graph(nodeList);

		g.addDirectedEdge(0, 1);
		g.addDirectedEdge(0, 2);
		g.addDirectedEdge(1, 3);
		g.addDirectedEdge(1, 6);
		g.addDirectedEdge(2, 3);
		g.addDirectedEdge(2, 4);
		g.addDirectedEdge(3, 5);
		g.addDirectedEdge(4, 5);
		g.addDirectedEdge(5, 6);

		g.BFSForSSSPP(nodeList.get(0));




	}
}
