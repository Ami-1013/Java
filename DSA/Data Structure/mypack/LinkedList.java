package mypack;


public class LinkedList {
    
    public Node head; // Here we have declared head and tail node. Default value is null.
    public Node tail;
    public int size;

    public Node createSingularLinkedList(int nodeValue){
        // It return head and create a data structure with respect to it. Hence you can store it in a variable.
        head = new Node(); // Here we have initialized the head node.
        Node node = new Node();
        node.next  = null;
        node.value = nodeValue;
        
        head = node;
        tail = node;
        size = 1;

        return head;
    }

    // Inserting in Singular Linked List
    public void insertInLinkedlist(int nodeValue, int location){

        Node node = new Node();
        node.value = nodeValue;
        
        // if singular linked list does'nt exist.
        if (head == null){
            createSingularLinkedList(nodeValue);
            return;
        }

        // if location is head.
        else if (location == 0){
            node.next = head; // head is the reference to the first node.
            head = node;
        }

        // if location is greater than size then insert at last.
        else if (location >= size){
            node.next = null;
            tail.next = node; // tail is the reference to the last node.
            tail = node;
        }

        else{
            Node tempNode  = head;
            int index = 0;

            // Location and index start with zero. TempNode will be at (location -2)th position with (location -1)th node.
            while (index < location -1){
                tempNode = tempNode.next;
                index++;
            }

            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }

        size++;

    }

    // Traversal of Singular Linked List
    public void traversalLinkedList(){
        if (head == null){
            System.out.println("Singular linked list does'nt exist.");
        }

        else{
            Node tempNode = head;

            System.out.print("Head -> ");
            for (int i=0; i< size; ++i){
                System.out.print(tempNode.value + " -> ");
                tempNode = tempNode.next;
            }
            System.out.println("Tail");
        }
    }

    // Search a node 
    public boolean searchNode(int nodeValue){
        if (head != null){
            Node tempNode = head;
            for (int i=0; i<size; ++i){
                if (tempNode.value == nodeValue){
                    System.out.println("Found at the index: "+ i );
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found.");
        return false;
    }


    // Deleting a node
    public void deletionOfNode(int index){
        if (index > size){
            System.out.println("Index out of bound error.");
            return;
        }

        else if (head == null){
            System.out.println("Single linked list does'nt exist");
            return;
        }

        // if node at beginning
        else if (index == 0){
            head = head.next;
            --size;
            
            if (size == 0){
                tail = null;
            }
        }
        
        // if node at last
        else if (index == size -1){
            Node tempNode = head;
            for (int i=0; i < size -1 ; ++i){
                tempNode = tempNode.next;
            }

            if (tempNode == head){
                head = tail = null;
                --size;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        }

        else{
            Node tempNode = head;
            // logic of times of loop is imp.
            for (int i=0; i < index -1; ++i){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
        // As reference is broke, the garbage collector delete the node
    }

    // Deletion of Entire Single linked list
    public void deleteEntireSingleLinkedList(){
        head = tail = null;
        System.out.println("Single linked list is successfully deleted");
        // As the reference is broke, garbage collector delete the nodes.
    }

    // Reverse traversal
    public void reverseTraversalSLL(){
        
        if (head != null){
            Node tempNode = tail;
            
            System.out.print("Tail <- ");
            for (int i=0; i<size; ++i){
                System.out.print(tempNode.value + " <- ");
                tempNode = head;
                for (int j=i; j<size-2; ++j){
                    tempNode = tempNode.next;
                }
            }
            System.out.println("Head");

        }

        else{
            System.out.println("Singular Linked list does'nt exist.");
        }
    }



}
