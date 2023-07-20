/*          Linked List Queue

- New element is added at last. 
    Reasons - 
           Enqueue is equally efficient if we add new element at first or last (using "head" & "tail" reference).
           However Dequeue is most efficient [O(Ω)] at first element compare to last where we have to loop.
           Same way Peek method is efficient at first.

- As its a linked list, size has no limit.

*/ 

import mypack.LinkedList;

class QueueLinkedList{
    LinkedList ll;

    public QueueLinkedList(){
        ll = new LinkedList();
        System.out.println("Queue linked list successfully created.");
    }

    public boolean isEmpty(){
        if (ll.head == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void enQueue(int value){
        // enQueue of node will be at last position.

        /* 
        
        mypack.Node node = new mypack.Node(); // inline declaration because I have another class of name "Node" in same directory.
        node.value = value;

        if (isEmpty()){
            ll.head = ll.tail = node;
            
        }
        else{
            ll.tail.next = node;
            ll.tail = node;
        }

        */

        ll.insertInLinkedlist(value, ll.size);
        // when inserting 1st element the attr ll.size will be null. So why code is not throwing error.
        System.out.println("The enQueue is successful of value: "+ value);

    }

    public int deQueue(){
        int result = -1;
        if (isEmpty()){
            System.out.println("The Linked list Queue is empty.");
        }
        else {
            result = ll.head.value;
            ll.deletionOfNode(0);
        }

        return result;
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("The Linked list Queue is empty.");
            return -1;
        }

        else {
            return ll.head.value;
        }
    }

    public void delete(){
        ll.head = ll.tail = null;
        System.out.println("The Linked list queue has been successfully deleted.");
        // After deletion of LinkedList Queue, you can still enQueue the node.
    }


}


public class L13_Linked_list_Queue {
    public static void main(String[] args) {
        
        QueueLinkedList qll = new QueueLinkedList();
        qll.enQueue(4);
        qll.enQueue(5);
        qll.enQueue(6);

        System.out.println(qll.deQueue());
        System.out.println(qll.deQueue());
        System.out.println(qll.peek());
        System.out.println(qll.peek());

        qll.delete();

        qll.enQueue(11);
        System.out.println(qll.peek());








        // Why no error in enQueue method?



    }
    
}
