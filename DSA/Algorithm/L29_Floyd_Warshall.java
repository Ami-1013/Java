/*		All Pair Shortest Path

i- Single source shortest path
	It is about finding a path between a given vertex(called source) to all other vertices in a graph such that the total
	distance between them (source and destination) is minimum.

ii- All Pair Shortest path
	It is about finding a path between "every vertex" to all other vertices in a graph such that the total distance
	between them (source and destination) is minimum
 
	In this we run All pair Shortest Path for every vertices.

			*******************************************
						Floyd Warshall algo
- Abstract
	A iteration if done v(vertices) times and every vertex is taken as "viaX" at a time. Short path is then calculated.
		Short path also get modified in the process.


- Format
	- Its is in 2-D matrix form.
	- Directed edge value from one vertex to another is inserted in matrix if it is present.
	- If a vertex has no direct connection to another vertex then it is set to infinity.
	- Distance of vertex from itself is 0 (immutable).

- Logic 
	if distance[u][v] > distance[u][viaX] + distance[viaX][v]{			u=source, v=destination, viaX=connecting vertex
		distance[u][v] = distance[u][viaX] + distance[viaX][v];
	}
	
	viaX plays a imp role. As it connect source to destination i.e viaX has the reference of destination or shortest 
			distance to destination(if another shortest distance is found at any iteration then shortest path form 
			viaX to destination is modified).


- A vertex can be reached by 3 ways:
		i- The vertex is not reachable
		ii- Two vertex are directly connected.
		iii- Two vertex are connected via another vertex.
 
- Floyd Warshall algo on negative cycle
	- To go through cycle we need to go via negative cycle participating vertex at least twice.
	- It never run loop twice via same vertex.
	- Hence Floyd Warshall alog never detect negative cycle.
 

*/


import java.util.*;

class WeightedNode implements Comparable<WeightedNode>{
	
	public String name;
	public ArrayList<WeightedNode> neighbors = new ArrayList<>();
	public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
	public boolean isVisited = false;
	public WeightedNode parent;
	public int distance, index;

	public WeightedNode(String name, int index){
		this.name = name;
		this.index = index;
		distance = Integer.MAX_VALUE;
	}

	@Override
	public String toString(){
		return name;
	}

	@Override
	public int compareTo(WeightedNode o){
		return this.distance - o.distance;
	}

}

class WeightGraph{
	
	ArrayList<WeightedNode> nodeList = new ArrayList<>();

	public WeightGraph(ArrayList<WeightedNode> nodeList){
		this.nodeList = nodeList;
	}
	
	void pathPrint(WeightedNode node){
		if (node.parent != null){
			pathPrint(node.parent);
		}

		System.out.print(node.name + " ");

	}


	void dijkstra(WeightedNode node){
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
		node.distance = 0;
		queue.addAll(this.nodeList);

		while(!queue.isEmpty()){
			WeightedNode currentNode = queue.remove();
				// logic in below 3 lines
			for(WeightedNode neighbor: currentNode.neighbors){
				if (queue.contains(neighbor)){ 
					if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)){
						neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);

						neighbor.parent = currentNode;
						
						// to refresh priority queue.
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}

		for (WeightedNode testNode : this.nodeList){
			System.out.print("Node " + testNode + ", distance: " + testNode.distance + ", Path: ");
			pathPrint(testNode);
			System.out.println();
		}

	}
	
	void addWeightedEdge(int fromIndex, int toIndex, int weight){
		WeightedNode node1 = this.nodeList.get(fromIndex);
		WeightedNode node2 = this.nodeList.get(toIndex);

		node1.weightMap.put(node2, weight);
		node1.neighbors.add(node2);
	}

	// ******************* Bellman Ford algo ****************************
	
	void bellmanFord(WeightedNode sourceNode){
		sourceNode.distance = 0;
		for (int i=0; i<this.nodeList.size(); ++i){
			for (WeightedNode currentNode : this.nodeList){
				for (WeightedNode neighbor : currentNode.neighbors){
					if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)){
							neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
							neighbor.parent = currentNode;
					}	
				}
			}	
		}

		System.out.println("Checking for negative cycle...");
		
		for (WeightedNode currentNode: this.nodeList){
			for (WeightedNode neighbor: currentNode.neighbors){
				if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)){
						
					System.out.println("Negative cycle is found");
					System.out.println("Vertex name: " + neighbor.name);
					System.out.println("Old cost: " + neighbor.distance);
					System.out.println("New cost: " + currentNode.distance + currentNode.weightMap.get(neighbor));
				
					return;
				}
			}
		}
		System.out.println("Negative cycle is not found.");

		for (WeightedNode nodeToCheck: this.nodeList){
			System.out.println("Node " + nodeToCheck.name + ", distance: "+ nodeToCheck.distance + ", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}

	void floydWarshall(){
		int size = this.nodeList.size();
		int[][] matrix = new int[size][size];

		for (int i=0; i<size; ++i){
			WeightedNode first = this.nodeList.get(i);

			for (int j=0; j<size; ++j){
				WeightedNode second = this.nodeList.get(j);

				if (i==j){
					matrix[i][j] = 0;
				}
				else if (first.weightMap.containsKey(second)){
					matrix[i][j] = first.weightMap.get(second);
				}
				else{
					matrix[i][j] = Integer.MAX_VALUE/10;  // div by 10 to avoid arithmetic error.
				}
			}
		}

		for (int k=0; k<this.nodeList.size(); ++k){
			for(int i=0; i<this.nodeList.size(); ++i){
				for (int j=0; j<this.nodeList.size(); ++j){
					if (matrix[i][j] > matrix[i][k] + matrix[k][j]){
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}			
				}
			}
		}

		for (int i=0; i<size; ++i){
			System.out.print("Printing the distance for node " + this.nodeList.get(i) +" :");

			for (int j=0; j<size; ++j){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}



}



 class L29_Floyd_Warshall{
	public static void main(String[] args){

		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));

		WeightGraph g = new WeightGraph(nodeList);
		
		g.addWeightedEdge(0, 3, 1);
		g.addWeightedEdge(0, 1, 8);
		g.addWeightedEdge(1, 2, 1);
		g.addWeightedEdge(2, 0, 4);
		g.addWeightedEdge(3, 1, 2);
		g.addWeightedEdge(3, 2, 9);

		System.out.println("Printing Floyd Warshall algo starting from Source: A");

		g.floydWarshall();




	}

}
