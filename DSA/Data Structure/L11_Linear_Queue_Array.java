/*              Queue

- Queue is a data structure that store data in "First In-First" (FIFO) Out manner.
- New elements are add only at last index.
- Used when first coming data is utilized while other wait for their turn.      
- FIFO method.

    Enqueue & Dequeue
    - Enqueue mean insertion 
    - Dequeue mean deletion

    As its a Queue data-structure enqueue insert element at last where as dequeue delete element at first.
    In peek method first element is returned.

*/ 


//              LINEAR QUEUE    
class QueueArray{
    int[] arr;
    private int beginningOfQueue, lastOfQueue;  // index of staring and ending of queue
    
    
    public QueueArray(int size){
        this.arr = new int[size];
        beginningOfQueue = lastOfQueue = -1;
        System.out.println("Queue is successfully created with size of: " + size);
    }

    // first create isEmpty() and isFull() methods because they will be useful in dequeue and enqueue methods.

    public boolean isFull(){
        if (lastOfQueue == arr.length-1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(){
        if (beginningOfQueue == -1 || beginningOfQueue == arr.length){ // check or understand this line
            return true;
        }
        else{
            return false;
        }
    }

    // insertion 
    public void enQueue(int value){
        if (isFull()){
            System.out.println("Can't insert, the queue is full.");
        }

        else{

            if (isEmpty()){
            beginningOfQueue =0;
            }

            lastOfQueue ++;
            this.arr[lastOfQueue] = value;
            System.out.println("Enqueue successful of value: "+ value);
            
        }
    }

    // deletion of 1st element.
    public int deQueue(){
        int result = -1;

        if (isEmpty()){
            System.out.println("The Queue is empty");
            return result;
        }
        else{
            result = arr[beginningOfQueue];
            beginningOfQueue++;

            // resetting queue
            if (beginningOfQueue > lastOfQueue){
                beginningOfQueue = lastOfQueue = -1;
            }
            /* we have not set all element of array to -1 (default) in case of resetting because of restriction on accessing 
               array's element set by attributes "beginningOfQueue" and "lastOfQueue".
            */
            return result;
        }

    }

    public int peek(){
        if (isEmpty()){
            System.out.println("The queue is empty.");
            return -1;
        }
        else{
            return this.arr[beginningOfQueue];
        }
    }

    public void delete(){
        this.arr = null;
        System.out.println("The queue has been successfully deleted.");
    }


    // Traversal (My own contribution)
    public void traversal(){
        if(isEmpty()){
            System.out.println("The queue is empty.");
        }

        else{
            System.out.print("\nSTART <- ");
            for (int i=beginningOfQueue; i<lastOfQueue+1; ++i){
                System.out.print(this.arr[i] + " <- ");
            }
            System.out.println("END\n");
        }
    }

    /*      Drawback of Linear Queue

    - Its won't utilize the empty cell made by dequeue method. Hence not memory efficient.
    
    */ 

}





public class L11_Linear_Queue_Array{
    public static void main(String[] args) {
        
        QueueArray qa = new QueueArray(4);

        qa.enQueue(3);
        qa.enQueue(4);
        qa.enQueue(5);
        qa.enQueue(6);
        qa.traversal();
        
        // create a traversal method for stack and queue to analyze them better.


    }


}