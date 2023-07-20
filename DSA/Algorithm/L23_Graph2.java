import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class GraphNodeLinked{

    public String name;
    public int index;
	public boolean isVisited = false;
    public ArrayList<GraphNodeLinked> neighbors = new ArrayList<>();  //for those nodes which have edge to
																		//this node.

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
	
	void topologicalVisit(GraphNodeLinked node, Stack<GraphNodeLinked> stack){
		for (GraphNodeLinked neighbor: node.neighbors){
			
		}
	}

}




public class L23_Graph2 {
   public static void main(String[] args) {
    
        ArrayList<GraphNodeLinked> nodeList = new ArrayList<>();

        nodeList.add(new GraphNodeLinked("A", 0));
        nodeList.add(new GraphNodeLinked("B", 1));
        nodeList.add(new GraphNodeLinked("C", 2));
        nodeList.add(new GraphNodeLinked("D", 3));
        nodeList.add(new GraphNodeLinked("E", 4));

        Graph2 g = new Graph2(nodeList);

        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);

        System.out.println(g.toString());
		
		//g.bfs();

		System.out.println("------------------");

		//g.bfs(); // won't show as "isVisited" is true for all graphnodes.

		
		System.out.println("------------------");

		g.dfs();

   } 
}
