/*          Priority Queue

- It can be made in two ways.
    1- Queue interface implementing PriorityQueue class.
    2- From PriorityQueue class.

- It allow min heap and max heap because it has priority.
    So it also have heapify method in it.



*/   


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class L4_Priority_Queue {
    public static void main(String[] args) {

        // for max heap.
        // Queue<Integer> pqq = new PriorityQueue<>(Comparator.reverseOrder());
        
        Queue<Integer> pq = new PriorityQueue<>();

        // By default it show "min heap".
        pq.offer(45);
        pq.offer(10);
        pq.offer(33);
        pq.offer(75);

        System.out.println(pq);

        pq.poll();

        // after "poll", heapify is done, so the order is rearranged.
        System.out.println(pq);

    }
    
}
