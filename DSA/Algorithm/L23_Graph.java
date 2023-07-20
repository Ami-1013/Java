
/*		Graphs

- Graph consist of finite set of vertices( or nodes) and a set of edges which connect a pair of nodes.

- Graph terminology
	1- Vertices:  Vertices are the node of the graph.
	2- Edge:	Edge is the line that connects pair of vertices.
	3- Unweighted graph:	A graph which does not have a weight associated with any edge.
	4- Weighted graph:	A graph which has weight associated with any edge.
	5- Undirected graph:	In case the edge of the graph do not have a direction associated with them.
	6- Directed graph:	If the edge in the graph have a direction associated with them.
	7- Cyclic graph:	A graph which at least have one loop.
	8- Acyclic graph:	A graph with no loop.
	9- Tree:	It is a special case of directed acyclic graph.

- Graph of two type:
	1- Directed graph - Which is of two type weighted & unweighted. Weighted graph of two type - positive and
						negative.
	2- Undirected graph - Which is of two type weighted & unweighted. Weighted graph of two type - positive and
							negative.

	ex
		1, Unweighted-undirected
		2, Unweighted-directed
		3, Positive-weighted-undirected
		4, Positive-weighted-directed
		5, Negative-weighted-undirected
		6, Negative-weighted-directed


- Graph Representation
	1, Adjacency Matrix- An adjacency is a square matrix or you can say a 2-D array and the element of the array
			indicate whether pair of vertices are adjacency or not in the graph.
			As it a adjacency it diagonal elements are zero(a node can't be connected to itself).
	
	2, Adjacency List- An adjacency list is a collection of unordered list used to represent a graph. Each list
				describe the set of neighbors of vertex in graph.
	
	- If a graph is complete or almost complete we should use Adjacency matrix
	- If the numbers of edges are few then we should use Adjacency list.

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class GraphNode{

	public String name;
	public int index;
	public boolean isVisited = false;	// for traversal

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

	/* Breadth first search: It is an algo for traversing Graph data structure. Its start at some arbitary node
	 	of the graph and explore the neighbor nodes(which are at current level) first, before moving to the 
		next level neighbors.
	*/
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
				/*	Because there might be a case where a graph node point to some nodes but no node point to it
				 	So thats why we traversal through all nodes in nodeList, so that we don't miss any node
					with out respect of edges(links btw nodes)
				 
				 */
			}
		}
	}

	/* Depth first search(DFS) : It is an algo for traversing a graph structure which start selecting some 
	 	arbitary node and explores as far as possible along each edge before backtracking.
	*/
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



}




public class L23_Graph{
	public static void main (String[] args){

		ArrayList<GraphNode> nodeList = new ArrayList<>();
		nodeList.add(new GraphNode("A", 0));
		nodeList.add(new GraphNode("B", 1));
		nodeList.add(new GraphNode("C", 2));
		nodeList.add(new GraphNode("D", 3));
		nodeList.add(new GraphNode("E", 4));

		Graph g = new Graph(nodeList);
		g.addUndirectedEdge(0,1);
		g.addUndirectedEdge(0,2);
		g.addUndirectedEdge(0,3);
		g.addUndirectedEdge(1,4);
		g.addUndirectedEdge(2,3);
		g.addUndirectedEdge(3,4);

		System.out.println(g.toString());

		//g.bfs();

		g.dfs();

	}

}
