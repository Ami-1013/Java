
/*		Topological Sort
- Sort given actions in such a way that if there is a depedency of one action on another, then the dependent action always comes
	later than its parent action.
- There can be many solution of topological sort. Its answer is not unique. 
 
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

// Topological sort of Adjacency List.
class GraphNodeLinked2{

    public String name;
    public int index;
	public boolean isVisited = false;
    public ArrayList<GraphNodeLinked2> neighbors = new ArrayList<>();  //for those nodes which have edge to
																		//this node.

    public GraphNodeLinked2(String name, int index){
        this.name = name;
        this.index = index;
    }
}

class Graph3{

    ArrayList<GraphNodeLinked2> nodeList = new ArrayList<>();

    public Graph3(ArrayList<GraphNodeLinked2> nodeList){
        this.nodeList = nodeList;
    }

    // in "UndirectedEdge" both nodes have reference of each other. As it is bi-directional edge.
    public void addUndirectedEdge(int index1, int index2){
        GraphNodeLinked2 first = this.nodeList.get(index1);
        GraphNodeLinked2 second = this.nodeList.get(index2);

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
	void bfsVisit(GraphNodeLinked2 node){
		LinkedList<GraphNodeLinked2> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()){
			GraphNodeLinked2 currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			
			for (GraphNodeLinked2 neighbor: currentNode.neighbors){
				if (!neighbor.isVisited){
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	void bfs(){
		for (GraphNodeLinked2 node: this.nodeList){
			if (!node.isVisited){
				bfsVisit(node);
			}
		}
		System.out.println();
	}

	// Depth first search ----------------------------
	void dfsVisit(GraphNodeLinked2 node){
		Stack<GraphNodeLinked2> stack = new Stack<>();
		stack.push(node);

		while (!stack.isEmpty()){
			GraphNodeLinked2 currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");

			for (GraphNodeLinked2 neighbor: currentNode.neighbors){
				if (!neighbor.isVisited){
					neighbor.isVisited = true;
					stack.push(neighbor);
				}
			}
		}
	}

	void dfs(){
		for(GraphNodeLinked2 node : this.nodeList){
			if (!node.isVisited){
				dfsVisit(node);
			}
		}
	}

	// *********************************  Topological Sort  *********************************************
	public void addDirectedEdge(int from, int to){
		GraphNodeLinked2 first  = this.nodeList.get(from);
		GraphNodeLinked2 second = this.nodeList.get(to);

		first.neighbors.add(second);
	}
	
	void topologicalVisit(GraphNodeLinked2 node, Stack<GraphNodeLinked2> stack){
		for (GraphNodeLinked2 neighbor: node.neighbors){
			if (!neighbor.isVisited){	// bacially we are going through a nodes edges.
				topologicalVisit(neighbor, stack);
			}	
		}
		node.isVisited = true;
		stack.push(node);
	}

	void topologicalSort(){
		Stack<GraphNodeLinked2> stack = new Stack<>();
		for(GraphNodeLinked2 node : this.nodeList){ // going through all vertices.
			if (!node.isVisited){
				topologicalVisit(node, stack);
			}	
		} 
		while (!stack.isEmpty()){
			System.out.print(stack.pop().name + " ");
		}
		//	t.c - O(V+E) &  s.c - O(V+E), where "V" is vertices and "E" is edges.
	}








}



public class L25_TopologicalSort{
	public static void main(String[] args){
		ArrayList<GraphNodeLinked2> nodeList = new ArrayList<>();

		nodeList.add(new GraphNodeLinked2("A", 0));
		nodeList.add(new GraphNodeLinked2("B", 1));
		nodeList.add(new GraphNodeLinked2("C", 2));
		nodeList.add(new GraphNodeLinked2("D", 3));
		nodeList.add(new GraphNodeLinked2("E", 4));
		nodeList.add(new GraphNodeLinked2("F", 5));
		nodeList.add(new GraphNodeLinked2("G", 6));
		nodeList.add(new GraphNodeLinked2("H", 7));
		
		Graph3 g = new Graph3(nodeList);

		g.addDirectedEdge(0,2);
		g.addDirectedEdge(2,4);
		g.addDirectedEdge(4,7);
		g.addDirectedEdge(4,5);
		g.addDirectedEdge(5,6);
		g.addDirectedEdge(1,2);
		g.addDirectedEdge(1,3);
		g.addDirectedEdge(3,5);

		System.out.println(g.toString());

		g.topologicalSort();

	}	



}
