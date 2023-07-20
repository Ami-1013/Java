
/*      Comaparable Class

- Comaparable class works with arrays and it is implemented in node class(which object has to be sorted).

- "comapareTo" method is override in this. If this method return positive number than element is greater and 
  if return negative than element is smaller, zero for equal elements.

- Arrays.sort() is used
*/
import java.util.Arrays;

class Node implements Comparable<Node>{
    int value;

    public Node (int value){
        this.value = value;
    }

    @Override
    public int compareTo(Node a){
        return this.value - a.value; // this.value refers to this object's attribute value.

        /*  sort in ascending order.
            
            To sort in descending use-
                i- a.value - this.value

                ii- Array.sort(arr, Collections.reversOrder());

        */
         
    }
}



public class ComparableClass {

    public static void main(String[] args) {
    
        Node n1 = new Node(5);
        Node n2 = new Node(2);
        Node n3 = new Node(56);
        Node n4 = new Node(23);
        Node n5 = new Node(9);



        Node[] arr = {n1,n2,n3,n4,n5};

        Arrays.sort(arr);

        for (Node a: arr){
            System.out.println(a.value);
        }

    }


}
