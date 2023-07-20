/*			Single Source Short Path Problems

- Is is about finding a path between a given vertex(called source) to all other vertices in a graph such that the total distance
	between them (source and destination) is minimum.

	Algorithm for solution
	i- BFS (Breadth first search)
	ii- Dijkstra's algo
	iii- Bellman ford

- It can't be used with weighted graph.
- It does'nt work with SSSPP because DFS has a tendency to go "as far as possible" from source, hence it can never find the
	shortest path.


*/



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class GraphNodeLinked{

    public String name;
    public int index;
	public boolean isVisited = false;
    public ArrayList<GraphNodeLinked> neighbors = new ArrayList<>();  //for those nodes which have edge to
																		//this node.
	public GraphNodeLinked parent;	// for BFS in Single source sort path problem

    public GraphNodeLinked(String name, int index){
        this.name = name;
        this.index = index;
    }
}

class Graph2{

    ArrayList<GraphNodeLinked> nodeList = new ArrayList<>();

    public Graph2(ArrayList<GraphNodeLinked> nodeList){
        this.nodeList = nodeList;
    }

    // in "UndirectedEdge" both nodes have reference of each other. As it is bi-directional edge.
    public void addUndirectedEdge(int index1, int index2){
        GraphNodeLinked first = this.nodeList.get(index1);
        GraphNodeLinked second = this.nodeList.get(index2);

        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        
        for(int i=0; i<nodeList.size(); ++i){
            s.append(nodeList.get(i).name + ": ");

            for (int j=0; j<nodeList.get(i).neighbors.size(); ++j){
                if (j==nodeList.get(i).neighbors.size() - 1){
                    s.append((nodeList.get(i).neighbors.get(j).name));
                }

                else{
                    s.append((nodeList.get(i).neighbors.get(j).name)+ " -> ");
                }
            }    
            s.append("\n");
        }
        return s.toString();
    }

	// Breadth first traversal -------------------------------------------
	void bfsVisit(GraphNodeLinked node){
		LinkedList<GraphNodeLinked> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()){
			GraphNodeLinked currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			
			for (GraphNodeLinked neighbor: currentNode.neighbors){
				if (!neighbor.isVisited){
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	void bfs(){
		for (GraphNodeLinked node: this.nodeList){
			if (!node.isVisited){
				bfsVisit(node);
			}
		}
		System.out.println();
	}

	// Depth first search ----------------------------
	void dfsVisit(GraphNodeLinked node){
		Stack<GraphNodeLinked> stack = new Stack<>();
		stack.push(node);

		while (!stack.isEmpty()){
			GraphNodeLinked currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");

			for (GraphNodeLinked neighbor: currentNode.neighbors){
				if (!neighbor.isVisited){
					neighbor.isVisited = true;
					stack.push(neighbor);
				}
			}
		}
	}

	void dfs(){
		for(GraphNodeLinked node : this.nodeList){
			if (!node.isVisited){
				dfsVisit(node);
			}
		}
	}

	// Topological Sort
	public void addDirectedEdge(int from, int to){
		GraphNodeLinked first  = this.nodeList.get(from);
		GraphNodeLinked second = this.nodeList.get(to);

		first.neighbors.add(second);
	}
	
	void topologicalVisit(GraphNodeLinked node, Stack<GraphNode> stack){
		for (GraphNodeLinked neighbor: node.neighbors){
			
		}
	}


	//********************** BFS for Single source sort path*****************************

	public static void printPath(GraphNodeLinked node){
		if (node.parent != null){
			printPath(node.parent);
		}

		System.out.print(node.name + " ");
	}

	public void BFSForSSSPP(GraphNodeLinked node){
		LinkedList<GraphNodeLinked> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			GraphNodeLinked currentNode = queue.remove(0);
			currentNode.isVisited = true;

			System.out.print("Printing path for node " + currentNode.name + ": ");

			printPath(currentNode);
			System.out.println();

			for (GraphNodeLinked neighbor: currentNode.neighbors){
				if (!neighbor.isVisited){
					queue.add(neighbor);
					neighbor.isVisited = true;
					neighbor.parent = currentNode;
				}
			}
		}
	}
}






public class L26_SingleSourceShortPathLinked{
	public static void main(String[] args){


        ArrayList<GraphNodeLinked> nodeList = new ArrayList<>();

        nodeList.add(new GraphNodeLinked("A", 0));
        nodeList.add(new GraphNodeLinked("B", 1));
        nodeList.add(new GraphNodeLinked("C", 2));
        nodeList.add(new GraphNodeLinked("D", 3));
        nodeList.add(new GraphNodeLinked("E", 4));
        nodeList.add(new GraphNodeLinked("F", 5));
        nodeList.add(new GraphNodeLinked("G", 6));

		Graph2 g = new Graph2(nodeList);

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
