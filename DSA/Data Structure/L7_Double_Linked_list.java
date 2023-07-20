
class DoubleNode1{
    public int value;
    public DoubleNode1 next;
    public DoubleNode1 prev;
}

class DoubleLinkedList{
    DoubleNode1 head, tail;
    int size;


    public DoubleNode1 createDoubleLinkedList(int nodeValue){
        DoubleNode1 node = new DoubleNode1();

        node.value = nodeValue;
        node.next = node.prev = null;

        head = tail = node;
        this.size = 1;

        return head;

    }

    public void insertNode(int nodeValue, int index){
        
        DoubleNode1 node = new DoubleNode1();
        node.value = nodeValue;

        if (head == null){
            createDoubleLinkedList(nodeValue);
            return;
        }

        else if (index == 0){
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }

        else if (index == size){
            node.next = null;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }

        else {

            DoubleNode1 tempNode = head;
            for (int i=0; i<index-1; ++i){
                tempNode = tempNode.next;
            }

            node.prev = tempNode;
            node.next = tempNode.next;

            tempNode.next.prev = node;
            tempNode.next = node;

        }
        this.size++;

    }

    // Traversal DLL
    public void traversalDLL(){
        
        if (head != null){
            DoubleNode1 tempNode = head;
            
            System.out.print("Head-> ");
            for (int i=0; i < this.size; ++i){
                System.out.print(tempNode.value + "-> ");
                tempNode = tempNode.next;
            }
    
            System.out.println("Tail");
        }

        else{
            System.out.println("Double linked list does'nt exist.");
        }
    }


    // Reverse traversal
    public void reverseTraversalDLC(){
        
        if (head != null){
            DoubleNode1 tempNode = tail;
            
            System.out.print("Tail <- ");
            for (int i=0; i<size; ++i){
                System.out.print(tempNode.value + " <- ");
                tempNode = tempNode.prev;
            }
    
            System.out.println("Head");
        }

        else{
            System.out.println("Double Linked list does'nt exist."
            );
        }
    }


    // Search node
    public boolean searchNode(int nodeValue){
        if (head != null){
            DoubleNode1 tempNode = head;

            for (int i=0; i<size; ++i){
                if (tempNode.value == nodeValue){
                    System.out.println("The node is at index: "+ i);
                    return true;
                }

                tempNode = tempNode.next;
            }
            System.out.println("The node is not in the DLL");
            return false;
        }
        else{
            System.out.println("Double Linked list does'nt exist.");
            return false;
        }
    }

    public void deleteNode(int index){
        if (head != null){

            if (index>size-1 || index<0){
                System.out.println("Index out of range.");
                return;
            }
            
            else if (index == 0){
                head = head.next;
                
                if (size == 1){
                    tail = null;
                }
                else{
                    head.prev = null;
                }  
            }

            
            else if (index == size-1){
                tail = tail.prev;
                tail.next = null;
                // size == 1, condition will be caught in above condition as head and tail index will be same i.e zero
            }

            else{
                DoubleNode1 tempNode = head;
                for (int i=0; i<index-1; ++i){
                    tempNode = tempNode.next;
                }
                
                tempNode.next = tempNode.next.next;
                tempNode.next.prev = tempNode;

            }
            
            size--;             
        }
        else{
            System.out.println("DLL don't exist");
        }
    }

    // Delete entire DLL
    // As in DLL two consecutive node are referenced by each other. Hence setting head and tail null will not be enough. we
    // have to set all prev(attr) to null to broke the reference.
    public void deleteEntireDLL(){
        DoubleNode1 tempNode = head;
        // Setting all prev(attr) to null
        for (int i=0; i<size-1; ++i){
            tempNode.prev = null;
            tempNode = tempNode.next;
        }

        head = tail = null;
        System.out.println("DLL has been deleted successfully.");
    }

}



public class L7_Double_Linked_list {
    public static void main(String[] args) {
        
        DoubleLinkedList dll = new DoubleLinkedList();

        // var c = dll.createDoubleLinkedList(5);
        // System.out.println(c.value);

        dll.createDoubleLinkedList(7);
        // System.out.println(dll.head.value);
        dll.insertNode(8, 1);
        dll.insertNode(9, 2);
        dll.insertNode(10, 3);
        dll.insertNode(11, 4);

        System.out.println(dll.head.value);
        System.out.println(dll.head.next.value);
        System.out.println(dll.head.next.next.value);
        System.out.println(dll.head.next.next.next.value);

        dll.traversalDLL();
        dll.reverseTraversalDLC();
        // dll.searchNode(16);

        // dll.deleteNode(4);
        // dll.traversalDLL();

        dll.deleteEntireDLL();
        dll.traversalDLL();

    }

    
}
