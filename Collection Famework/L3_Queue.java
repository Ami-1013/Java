/*
- Queue is a interface that can be created with the help of "LinkedList" or "PriorityQueue" class.
- It take "wrapping class", not primitive data type.

- add, remove, element methods are similar to offer, poll, peek but they throw exception where as they throw. 
    offer - when operation crashes it return boolean, true/false.
    poll - If queue is empty return null.
    peek - If queue is empty return null.

*/ 



import java.util.Queue;
import java.util.LinkedList;


public class L3_Queue {
    public static void main(String[] args) {
        
        Queue<Integer> qu = new LinkedList<>(); 

        // "offer" for addition
        qu.offer(2);
        qu.offer(3);
        qu.offer(4);
        qu.offer(5);

        System.out.println(qu);

        // "poll" for deletion and return deleted element.
        qu.poll();

        System.out.println(qu);

        // "peek" 
        System.out.println(qu.peek());

        

    }
}
