
class DoubleNode2{
    public int value;
    public DoubleNode2 next, prev;
}

class CircularDoubleLinkedList{
    int size;
    public DoubleNode2 head, tail;  // Default value of head and tail is null.

    public void createCDLL(int nodeValue){
        DoubleNode2 node = new DoubleNode2();
        node.value = nodeValue;
        
        node.next = node.prev = node;
        head = tail = node;

        this.size = 1;
    }

    // Insertion
    // The trick is to give first reference to new node next and prev (attr).
    public void insertNode(int nodeValue, int index){
        if (head != null){

            DoubleNode2 newNode = new DoubleNode2();
            newNode.value = nodeValue;

            if (index<0 || index>size){
                System.out.println("Index out of range.");
                return;
            }

            // at index first and last
            else if (index == 0 || index == size){
                newNode.next = head;
                newNode.prev = tail;

                head.prev = newNode;
                tail.next = newNode;

                if (index == 0){
                    head = newNode;
                }

                else{
                    tail = newNode;
                }
            }

            // else if (index == size){
            //     newNode.next = head;
            //     newNode.prev = tail;

            //     tail.next = newNode;
            //     head.prev = newNode;

            //     tail = newNode;
            // }

            else{
                DoubleNode2 tempNode = head;

                for (int i=0; i<size-1; ++i){
                    tempNode = tempNode.next;
                }

                newNode.prev = tempNode;
                newNode.next = tempNode.next;

                tempNode.next = newNode;
                newNode.next.prev = newNode;
            }

            this.size ++;
        }
        else{
            System.out.println("DCLL does'nt exist.");
        }
    }

    // Traversal
    public void traversalCDLL(){
        if (head != null){
            DoubleNode2 tempNode = head;

            System.out.print("Head -> ");
            for (int i=0; i<size; ++i){
                System.out.print(tempNode.value + " -> ");
                tempNode = tempNode.next;
            }
            System.out.println("Tail");
        }
        else{
            System.out.println("CDLL does'nt exist.");
        }
    }

    // Reverse traversal
    public void reverseTraversal(){
        if (head != null){
            DoubleNode2 tempNode = tail;

            System.out.print("Tail <- ");
            for(int i=0; i<size; ++i){
                System.out.print(tempNode.value + " <- ");
                tempNode  = tempNode.prev;
            }
            System.out.println("Head");
        }

        else{
            System.out.println("Double circular linked list does'nt exist.");
        }
    }

    // Search
    public boolean searchNode(int nodeValue){
        if (head != null){
            
            DoubleNode2 tempNode = head;
            for (int i=0; i<size; ++i){
                if (tempNode.value == nodeValue){
                    System.out.println("Node value at index: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
            System.out.println("Node value is not present in CDLL.");
            return false;

        }

        else{
            System.out.println("Circular double linked list does'nt exist.");
            return false;
        }
    }

    // Delete node
    public void deleteNode(int index){
        if (head != null){

            if (index >size-1 || index < 0){
                System.out.println("Index out of range");
                return;
            }

            else if (index == 0){
                head = head.next; 
                head.prev = tail;
                tail.next = head;

                if (size ==1){
                    head.next =head.prev = null; // as node have reference to itself.
                    head = tail = null;
                }
            }

            else if (index == size -1){
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;

                // size == 1, condition will be caught in above else if statement.
            }

            else{
                DoubleNode2 tempNode = head;

                for (int i=0; i<index-1 ; ++i){
                    tempNode = tempNode.next;
                }

                tempNode.next = tempNode.next.next;
                tempNode.next.prev = tempNode;
            }
            this.size --;

        }
        else{
            System.out.println("Circular double linked list does'nt exist.");
        }
    }

    // delete entire CDLL
    public void deleteCDLL(){

        /* 
        // head.prev = tail.next = null; // now its a double linked list
        
        DoubleNode2 tempNode = head;
        // for (int i=0; i<size-1; ++i){
        //     tempNode.prev = null;
        //     tempNode = tempNode.next;
        // }
        // // now its a linked list
        */


        DoubleNode2 tempNode = head;
        for (int i=0; i<size; ++i){
            tempNode.prev = null;
            tempNode = tempNode.next;
        } // the result will be circular single linked list i.e tail will reference to head, but still it got deleted. how?
        
        head  = tail = null;
        // You can't set head & tail null in start. As list will still exist and you will don't have any way to access it.
    }

}



public class L8_Circular_double_linked_list {
    public static void main(String[] args) {
        
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.createCDLL(3);
        cdll.insertNode(4,1);
        cdll.insertNode(5,2);
        cdll.insertNode(6, 3);
        System.out.println(cdll.tail.value);
        
        cdll.traversalCDLL();
        // cdll.reverseTraversal();  
        
        // cdll.searchNode(55);

        // cdll.deleteNode(3);

        cdll.deleteCDLL();
        cdll.traversalCDLL();

    }
    
}
