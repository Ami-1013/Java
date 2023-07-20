import java.util.Stack;

// Q1- Implement Queue class which implement a Queue using two stacks.

class QueueViaStack{
    Stack<Integer> stackNewest, stackOldest;
    
    public QueueViaStack(){
        stackNewest = new Stack<Integer>();
        stackOldest = new Stack<Integer>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void enQueue(int value){
        stackNewest.push(value);
    }

    private void shiftStack(){
        int temp_size = stackNewest.size();
        /* temp_size is used instead of "stackNewest.size()" in loop because in every iteration compiler check
            "loop condition". Hence it will call "stackNewest.size()" every time after iteration to check loop
            if used in loop condition.
            But "stackNewest.pop()" will decrease the the size. Hence after every iteration new value of 
            "stackNewest.size()" will occur, Which in total run loop for around (n/2 + 1) time;
        */
        for (int i=0; i<temp_size; ++i){
            stackOldest.push(stackNewest.pop());
        }    
        
    }

    public int deQueue(){
        int result = -1;
        if (stackOldest.isEmpty()){
            if (stackNewest.isEmpty()) {
                System.out.println("Queue is empty.");
                return result;
            }

            else{ 
                shiftStack();
            }
        }

        return stackOldest.pop();
    }


    public int peek(){
        if (size() ==0){
            System.out.println("Queue is empty.");
            return -1;
        }
        else{
            shiftStack();
            return stackOldest.peek();
        }
    }

}


public class L14_3Queue_ques {
    public static void main(String[] args) {

        QueueViaStack q = new QueueViaStack();
        
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        
        System.out.println(q.deQueue());
        q.enQueue(7);
        q.enQueue(8);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());



    }

}
