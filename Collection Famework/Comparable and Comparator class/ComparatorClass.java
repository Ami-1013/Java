/*      Comparator 

- It works with list such as ArrayList, queue, stack etc. It does'nt support Array.

- Bascially class is created which implements Comparator abstract class.
  This class "compare" method is overridden. It takes 2 parameter unlike comparabel which take one.
  
  However a comparator can be created by 3 ways (up to my knowledge)


  If "compare" method return positive then it is greater and if return negative then smaller and for 0 that is 
  equal.

- Collections.sort(arr, comparator); is used for sorting.


*/
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;


class Node2{
    int value;

    public Node2(int value){
        this.value = value;
    }
}

// Node class Comparator
class NodeComparator implements Comparator<Node2>{
    public int compare(Node2 a, Node2 b){
        return a.value - b.value;
    }
}

public class ComparatorClass {
    public static void main(String[] args) {
        
        Node2 n1 = new Node2(72);
        Node2 n2 = new Node2(13);
        Node2 n3 = new Node2(7);
        Node2 n4 = new Node2(100);
        Node2 n5 = new Node2(36);
        Node2 n6 = new Node2(56);


        ArrayList<Node2> arrList = new ArrayList<>();
        arrList.add(n1);
        arrList.add(n2);
        arrList.add(n3);
        arrList.add(n4);
        arrList.add(n5);
        arrList.add(n6);


        NodeComparator nc = new NodeComparator();

        Collections.sort(arrList, nc);
        /*      Another way

        i- Collections.sort(arrList, new NodeComparator());  // creation of obj within the method.
        
        ii- Directly creating a oject

            Comparator<Node2> comp = new Comparator<>(){
                @Override
                public int compare(Node2 a, Node2 b){
                    return a.value - b.value;
                }
            }

            Collections.sort(arr, comp);
        */

        for(Node2 a: arrList){
            System.out.println(a.value);
        }

    }
    
}
