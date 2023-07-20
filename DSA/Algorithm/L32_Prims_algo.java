/*              Prims Algo

- It a greedy alog.

- It find MST for weighted undirected graps in following ways.
  
  i- Take any vertex as a source set it weight to 0 and all other's vertices weight to infinity.
  ii- For every adjacent vertices if the current weight is more than current edge then we set it to current
        edge.
  iii- Then we mark the current vertex as visited.
  iv- Repeat this steps for all vertices in increasing order of weight.


*/

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;


//*********************************************************************
class WeightedNode implements Comparable<WeightedNode>{
    
    public String name;
    public ArrayList<WeightedNode> neighbors = new ArrayList<>();
    public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    public boolean isVisited = false;
    public WeightedNode parent;
    public int distance, index;

    public DisjointSet set;		// for set properties

    // New constructor **************************
    public WeightedNode(String name){
        this.name = name;
        this.distance = Integer.MAX_VALUE;
    }

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


class DisjointSet{
    private ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public static  void makeSet(ArrayList<WeightedNode> nodeList){
        for (WeightedNode node: nodeList){
                DisjointSet set = new DisjointSet();
                set.nodeList.add(node);
                node.set = set;
        }
    }

    public static DisjointSet findSet(WeightedNode node){
        return node.set;
    }

    public static DisjointSet union(WeightedNode node1, WeightedNode node2){
        if (node1.set.equals(node2.set)){
            return null;
        }

        else{
            DisjointSet set1 = node1.set;
            DisjointSet set2 = node2.set;


            if (set1.nodeList.size() > set2.nodeList.size()){
                ArrayList<WeightedNode> nodeSet2 = set2.nodeList;
                for (WeightedNode node: nodeSet2){
                    node.set = set1;
                    set1.nodeList.add(node);
                }
                return set1;
            }
            
            else{
                ArrayList<WeightedNode> nodeSet1 = set1.nodeList;
                for (WeightedNode node: nodeSet1){
                    node.set = set2;
                    set2.nodeList.add(node);
                }
                return set2;	
            }
        }
    }		

    public void printAllNodesOfThisSet(){
        System.out.println("Printing all nodes of the set: ");
        for (WeightedNode node: this.nodeList){
            System.out.print(node + " ");
        }
        System.out.println();
    }
}

//  UndirectedEdge clas **********************************
class UndirectedEdge{
    public WeightedNode first;
    public WeightedNode second;
    public int weight;

    public UndirectedEdge(WeightedNode first, WeightedNode second, int weight){
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return  "Edge (" + first + ", " + second + " ), weight = " + weight;
    }
}
// *************************************************************


class Prims{
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public Prims(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addWeightedUndirectedEdge(int i, int j, int k){
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);

        first.neighbors.add(second);
        second.neighbors.add(first);

        first.weightMap.put(second, k);
        second.weightMap.put(first,k);
    }

    // Prims Algo
    void prims(WeightedNode sourceNode){
        for (WeightedNode currentNode : nodeList){
            currentNode.distance = Integer.MAX_VALUE;
        }

        sourceNode.distance = 0;
        PriorityQueue<WeightedNode> pq = new PriorityQueue<>(); // WeightedNode, compareTo method
        pq.addAll(nodeList);

        while(!pq.isEmpty()){
            WeightedNode currentNode = pq.remove();
            for (WeightedNode neighbor: currentNode.neighbors){
                if (pq.contains(neighbor)){ // that mean neighbor is not marked
                    if (neighbor.distance > currentNode.weightMap.get(neighbor)){
                        neighbor.distance = currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        pq.remove(neighbor);
                        pq.add(neighbor);
                    }
                }
            }
        }

        int cost = 0;
        for (WeightedNode nodeToCheck: nodeList){
            System.out.println("Node " + nodeToCheck + ", key " + nodeToCheck.distance + " Parent: " +
                nodeToCheck.parent);
            cost += nodeToCheck.distance;
        }
        System.out.println("\n Total cost of MST: " + cost);

    }

}




public class L32_Prims_algo {
    public static void main(String[] args) {

        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        
        nodeList.add(new WeightedNode("A"));
        nodeList.add(new WeightedNode("B"));
        nodeList.add(new WeightedNode("C"));
        nodeList.add(new WeightedNode("D"));
        nodeList.add(new WeightedNode("E"));

        Prims graph = new Prims(nodeList);
        
        graph.addWeightedUndirectedEdge(0,1,5);
        graph.addWeightedUndirectedEdge(0,2,13);
        graph.addWeightedUndirectedEdge(0,4,15);
        graph.addWeightedUndirectedEdge(1,2,10);
        graph.addWeightedUndirectedEdge(1,3,8);
        graph.addWeightedUndirectedEdge(2,3,6);
        graph.addWeightedUndirectedEdge(2,4,20);

        System.out.println("Running Prims Algo on graph");

        graph.prims(nodeList.get(4));

        

    }
}
