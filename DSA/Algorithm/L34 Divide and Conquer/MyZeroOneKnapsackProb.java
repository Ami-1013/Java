
import java.util.Arrays;

class Node implements Comparable<Node>{

    int profit, weight;
    float profitPerWeight;

    public Node(int profit, int weight){
        this.profit = profit;
        this.weight = weight;
        this.profitPerWeight = (float)profit/weight;
    }

    @Override
    // for descending order
    public int compareTo(Node a){
        if (a.profitPerWeight> this.profitPerWeight){
            return 1;
        }
        else{
            return -1;
        }
    }
}


public class MyZeroOneKnapsackProb {

    public static void main(String[] args) {
        
        Node n1 = new Node(31,3);
        Node n2 = new Node(26,1);
        Node n3 = new Node(72,5);
        Node n4 = new Node(17,2);
        

        Node[] arr = {n1,n2,n3,n4};
        Arrays.sort(arr);

        int capacity = 7;
        int maxProfit = 0;

        // Node can be taken only one time.
        for (Node a: arr){
            if (capacity >= a.weight){
                maxProfit += a.profit;
                capacity -= a.weight;
            }

            if (capacity <= 0){
                break;
            }
        }

        System.out.println("Max Profit: "+ maxProfit);



    }
}
