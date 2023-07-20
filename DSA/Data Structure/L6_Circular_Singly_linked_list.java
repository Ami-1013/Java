// "Node1" because "Node" class already exist in another java file.
class Node1{
    public int value;
    public Node1 next;
}

class CircularSinglyLinkedList{
    public Node1 head;
    public Node1 tail;
    public int size;

    public Node1 createCircularSinglyLinkedList(int nodeValue){
        head = new Node1();
        Node1 node = new Node1();
        node.value = nodeValue;
        node.next = node;

        head = tail = node;
        size = 1;
        return head;
    }

    public void insertNode(int nodeValue, int index){
        Node1 node = new Node1();
        node.value = nodeValue;

        // if CSL is not created
        if (head == null){
            createCircularSinglyLinkedList(nodeValue);
            return;
        }
        
        else if (index > size || index < 0){
            System.out.println("Invalid index for insertion.");
            return;
        }

        // at beginning
        else if (index == 0){
            node.next = head;
            head = node;
            tail.next = head;
        }

        // at last
        else if(index == size){
            tail.next = node;
            tail = node;
            tail.next = head; 
        }

        else{
            Node1 tempNode = head;
            for(int i =0; i < index-1; ++i){
                tempNode = tempNode.next;
            }

            node.next = tempNode.next;
            tempNode.next = node;

        }
        size++;
    }

    // traversal
    public void traversalCSL(){
        if (head != null){
            
            Node1 tempNode = head;

            System.out.print("Head -> ");
            for (int i=0; i<size; ++i){
                System.out.print(tempNode.value + " -> ");
                tempNode = tempNode.next;
            }
            System.out.println("Tail");
        }

        else {
            System.out.println("Circular Singly List does'nt exist.");
        }
    }

    // search node
    public boolean searchNode(int nodeValue){
        if (head != null){
            Node1 tempNode = head;
            for (int i=0; i<size; ++i){
                if(tempNode.value == nodeValue){
                    System.out.println("Node found at index: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found.");
        return false;
    }

    // Deletion
    // to delete you have to set node reference to null.
    public void deleteNode(int index){

        if (head == null){
            System.out.println("The Circular singly list does'nt exist.");
            return;
        }
        else if(index < 0 || index > size-1){
            System.out.println("Index out of bound.");
            return;
        }

        else if (index == 0){
            head = head.next;
            tail = head;
            size--;

            if (size == 0){
                head.next = null;
                head = tail = null;
            }
        }

        else if (index == size -1){
            Node1 tempNode = head;

            for (int i=0; i < size-1; ++i){
                tempNode = tempNode.next;
            }

            tempNode.next = head;
            tail = tempNode;
            size--;

            // if size is 1 condition is not include as it will be caught in previous condition statement.
        }

        else {
            Node1 tempNode = head;
            for (int i=0; i< index-1; ++i){
                tempNode = tempNode.next;
            }

            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    // Delete entire CSL
    public void deleteEntireCSL(){
        if (head == null){
            System.out.println("Can't delete as CSLL does'nt exist.");
        }
        else{
            head = null;
            // tail.next = null;
            tail = null;
            size = 0;
            System.out.println("CSLL successfully deleted.");
        }
        /* The "size" attribute problem is solved by "insert" method's condition if the head == null
           but still until the "insert" is called the size will be not zero.
        */
    }


}



public class L6_Circular_Singly_linked_list {
    public static void main(String[] args) {
        
        CircularSinglyLinkedList csl = new CircularSinglyLinkedList();

        csl.createCircularSinglyLinkedList(3);
        // System.out.println(csl.head.value);
        csl.insertNode(4,1);
        csl.insertNode(5,2);
        csl.insertNode(6,3);
        csl.insertNode(7,4);
        csl.traversalCSL();
        // csl.searchNode(132);
        csl.deleteNode(3);
        System.out.println(csl.size);
        csl.deleteEntireCSL();
        System.out.println(csl.size);
        csl.traversalCSL();

        csl.insertNode(3, 0);
        csl.deleteEntireCSL();
        csl.traversalCSL();
        System.out.println(csl.size);
    }
}
