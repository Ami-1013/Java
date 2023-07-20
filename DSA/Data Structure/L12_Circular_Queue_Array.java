/*      Circular Queue

- It utilize the empty cell.
*/ 


//      Circular Queue
class CircularQueue{

    int[] arr;
    private int size, beginningOfQueue, lastOfQueue;

    public CircularQueue(int queueSize){
        this.arr = new int[queueSize];
        this.size = queueSize;
        this.beginningOfQueue = this.lastOfQueue = -1;
        System.out.println("The Circular Queue has been successfully.");
    }

    public boolean isEmpty(){
        if (beginningOfQueue == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFull(){
        if (beginningOfQueue==0 && lastOfQueue +1 == size){
            return true;
        }
        else if (beginningOfQueue == lastOfQueue +1){
        /* this is for when circular insert occur i.e lastOfQueue goes to start. Hence lastOfQueue < beginningOfQueue, in index.
        That why is "beginningOfQueue == lastOfQueue +1"
           
        */
            return true;
        }
        else{
            return false;
        }
    }

    public void enQueue(int value){
        // 3 conditions - full, empty and insert in between.

        if (isFull() == true){
            System.out.println("The Circular queue is full, can't insert value: " + value);
        }
        else if (isEmpty() == true){
            beginningOfQueue = lastOfQueue = 0;
            arr[lastOfQueue] = value;
            System.out.println("The enQueue is successful of value: " + value);
        }
        else{
            // we know queue has space because of "isFull" method in above "if" condition.
            if (lastOfQueue +1 == size){
                lastOfQueue = 0;
            }
            else{
                lastOfQueue++;
                // this increment include both situation where "lastOfQueue" is after or before the "beginningOfQueue".
            }

            arr[lastOfQueue] = value;
            System.out.println("The enQueue is successful of value: " + value);
        }

    }

    public int deQueue(){
        int result = -1; 
        if (isEmpty()){
            System.out.println("The Circular Queue is empty.");
        }
        else{
            result = arr[beginningOfQueue];
            arr[beginningOfQueue] = 0; // default or null value.

            if (beginningOfQueue == lastOfQueue){
                beginningOfQueue = lastOfQueue = -1;
            }
            else if (beginningOfQueue +1 == size){
                beginningOfQueue = 0;
            }
            else{
                beginningOfQueue++;
            }
        }

        return result;
    }

    public int peek(){
        
        if (isEmpty()){
            System.out.println("The Circular Queue is empty.");
            return -1;
        }
        else{
            return arr[lastOfQueue];
        }
    }

    public void delete(){
        arr = null;
        System.out.println("The queue has been successfully deleted.");
        // As it set "arr" = null, you can't enqueue as arr is null. Hence throw exception.
        
    }



}


public class L12_Circular_Queue_Array {

    public static void main(String[] args) {
    
        CircularQueue cq = new CircularQueue(4);

        cq.enQueue(4);
        cq.enQueue(5);
        // cq.enQueue(6);
        // cq.enQueue(7);
        
        // System.out.println(cq.deQueue());
        // System.out.println(cq.deQueue());
        
        // cq.enQueue(8);
        
        cq.delete();
        cq.enQueue(11);
        
        
    }

    
}
