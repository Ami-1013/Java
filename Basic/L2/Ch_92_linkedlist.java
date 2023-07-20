/*      Linked list 

- It is also a predefine class in java.
- Its methods are all most as "ArrayList" but internal operation and their time is different.

- Linked list is better in insertion and deletion and bad at searching values. Where as l1ay list is good at searching but
  bad at insertion and deletion.

-  

*/ 

import java.util.LinkedList;

public class Ch_92_linkedlist {
    public static void main(String[] args) {
        
        LinkedList<Integer> l1 = new LinkedList<>();

        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(2);


        System.out.println(l1.addAll(1,l1)); 

        System.out.println(l1.contains(5)); 
        System.out.println(l1.indexOf(2));
        System.out.println(l1.lastIndexOf(2));
        System.out.println(l1.set(9, 222));

        // linked list methods

        l1.addLast(1000);
        l1.addFirst(1111);

        System.out.println("\n-----------------------\n");
        
        for (int i=0; i< l1.size(); ++i){
            // l1[i], will give error.
            System.out.println(l1.get(i));
        }
        

    }
}
