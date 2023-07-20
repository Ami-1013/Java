/*      Array Deque

- It is a class.
- It is double ended queue.
    - It can add, delete, peek from both end of queue i.e from start and end.

- It has all method and properties of a queue. So offer,peek,poll method show nature of queue. 

- It has "First" and "Last" to do operation at start or end.
    ex-     
        offerFirst(), offerLast()
        peekFirst(), peekLast()

- You can create "stack" and "queue" from ArrayDeque. But either to use "Last" or "First" in method depend on data structure.


*/ 

import java.util.ArrayDeque;

public class L5_Array_Deque {
    public static void main(String[] args) {
        
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        // offer and offerLast are same in functionality.
        ad.offer(33);
        ad.offerFirst(67);
        ad.offerLast(55);

        System.out.println(ad);


        // peek and peekFirst same in functionality.
        System.out.println(ad.peekFirst());
        System.out.println(ad.peek());
        System.out.println(ad.peekLast());

    }
    
}
