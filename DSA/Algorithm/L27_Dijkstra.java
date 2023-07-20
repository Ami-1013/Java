import java.util.*;

/*		Dijkstra Algo
- It is for shortest path from a node to another node (SSSPP).
- It does'nt work with negative cycle.
	Negative cycle: There is cycle (a cycle is a path of edges or vertices where in a vertex is reachable from itself).
					Total weight of a cycle is negative number.

 */

// implementing "Comparable" for comparison in graph
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

}





public class L27_Dijkstra{
	public static void main(String[] args){

		ArrayList<WeightedNode> nodeList = new ArrayList<>();

		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));
		nodeList.add(new WeightedNode("E", 4));
		nodeList.add(new WeightedNode("F", 5));
		nodeList.add(new WeightedNode("G", 6));


		WeightGraph g = new WeightGraph(nodeList);
		g.addWeightedEdge(0, 1, 2);
		g.addWeightedEdge(0, 2, 5);
		g.addWeightedEdge(1, 2, 6);
		g.addWeightedEdge(1, 3, 1);
		g.addWeightedEdge(1, 4, 3);
		g.addWeightedEdge(2, 5, 8);
		g.addWeightedEdge(3, 4, 4);
		g.addWeightedEdge(4, 6, 9);
		g.addWeightedEdge(5, 6, 7);


		System.out.println("Printing Dijkstra for A");
		g.dijkstra(nodeList.get(0));
	}
}
