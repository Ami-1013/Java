

class Node3 {
    int value;
    Node3 next, prev;
}

// Single Linked list
class LinkedList{
    int size;
    Node3 head, tail;

    public void createLL(int nodeValue){
        Node3 node = new Node3();
        node.value = nodeValue;

        node.next = null;
        head = tail = node;
        size = 1;
    }

    public void append(int nodeValue){
        
        if (head != null){

            Node3 node = new Node3();
    
            node.value = nodeValue;
            node.next = null;
            tail.next = node;
            tail = node;
            size ++;
        }

        else {
            createLL(nodeValue);
        }
    }

    public void traversal(){
        
        if (head != null){

            Node3 tempNode = head;
            System.out.print("Head -> ");
            for (int i=0; i<size; ++i){
                System.out.print(tempNode.value + " -> ");
                tempNode = tempNode.next;
            }
            System.out.println("Tail");
        }

        else{
            System.out.println("Linked list does'nt exist.");
        }
    }

    // ------------------------------
    // Q1- Algorithm to find nth to the last element of singly linked list.
    
    public Node3 nToLast1(int lastIndex){

        int i = 0;
        Node3 target = head, tempNode = head;

        Node3 fail = new Node3();
        fail.value = -1;

        boolean run = true;
        while (run){
            // if lastIndex is -ve
            if (lastIndex < 0){
                System.out.println("Invalid, can't give -ve index");
                return fail;
            }
            if (i >=lastIndex){
                target = target.next;
            }

            if (tempNode.next == null){
                run = false;
            }
            // System.out.println(target.value);
            tempNode = tempNode.next;
            ++i;
        }

        // if lastIndex is out of range.
        if (lastIndex >i){
            System.out.println("Index out of bound. LIMIT EXCEED");
            return fail;
        }
        return target;
    }

    // Q1- Different method
    public Node3 nToLast2(int lastIndex){
        Node3 p1 = head, p2 = head;  // p1 & p2 are pointers.

        for (int i=0; i< lastIndex; ++i){
            if (p2 == null) return null;
            p2 = p2.next;
        }

        while (p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p1;
    }

    // -----------------------------
    // Q3- Partition a linked list around a value x, such that all nodes less than x come before all the nodes greater than or
    // equal to x

    public LinkedList partition(int x){
        
        LinkedList newLL = new LinkedList();
        newLL.createLL(head.value);
        
        Node3 tempNode = head.next;
        
        while (tempNode != null){
            
            Node3 currentNode = new Node3();
            currentNode.value = tempNode.value;

            if (currentNode.value < x){
                currentNode.next = newLL.head;
                newLL.head = currentNode;
                newLL.size ++;
            }

            else{
                // System.out.println(currentNode.value);
                newLL.append(currentNode.value);
            }

            tempNode = tempNode.next;
            // System.out.println(currentNode.value);
        }

        return newLL;
    }



}



public class L8_linked_list_ques {

    // Q4-  lists in reverse and sum in reverse. 
    public static LinkedList sumListReverse(LinkedList list1, LinkedList list2){

        Node3 node1 = list1.head, node2 = list2.head;
   
        LinkedList newList = new LinkedList();
        int carry = 0;
        
        while (node1 != null){  // both list is of same size
            
            // System.out.println(node1.value);
            int sum = node1.value + node2.value;
            
            if (sum >= 10){
                newList.append(sum%10 + carry);
                carry = 1;
            }

            else{
                newList.append(sum + carry);
                carry = 0;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        if (carry >0){
            newList.append(carry);
        }

        return newList;

    } 

    public Node3 intersection(LinkedList list1, LinkedList list2){
        Node3 tempNode1 = list1.head;
        Node3 tempNode2 = list2.head;

        int sum1 = 0, sum2 = 0;

       while (tempNode1 != null){
        sum1 += tempNode1.value;
       }
       while (tempNode2 != null){
        sum2 += tempNode2.value;
       }

       tempNode1 = list1.head; 
       tempNode2 = list2.head;

       Node3 found = new Node3();
       found.value = -1;

       while (sum1 !=0 && sum2 != 0){
        
        if (sum1 == sum2 && tempNode1.next == tempNode2.next){
            found  = tempNode1.next;
            break;
        }
        
        
        if (sum1 > sum2){
            sum1 -= tempNode1.value;
            tempNode1 = tempNode1.next; 
        }

        else{
            sum2 -= tempNode2.value;
            tempNode2 = tempNode2.next;
        }

       }
       
       return found;
    }



    public static void main(String[] args) {
        
        /* 
        LinkedList ll = new LinkedList();
        ll.createLL(3);
        ll.append(9);
        ll.append(4);
        ll.append(6);
        ll.append(7);
        ll.append(8);
        ll.append(5);

        ll.traversal();

        // Node3 val = ll.nToLast1(-1);
        // System.out.println(val.value);
        // System.out.println(ll.head.value);

        LinkedList newLL = ll.partition(5);
        System.out.println(newLL.tail.value);
        newLL.traversal();
        */

        LinkedList l1 = new LinkedList();
        l1.append(7);
        l1.append(1);
        l1.append(6);

        LinkedList l2 = new LinkedList();
        l2.append(5);
        l2.append(9);
        l2.append(2);

        LinkedList l3 = sumListReverse(l1,l2);

        l3.traversal();


    }
}
