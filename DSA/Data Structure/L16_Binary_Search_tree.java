/*      Binary Search Tree

- Binary Search tree and Binary tree are two different data structure.

- Binary Search tree is a binary tree with some additional properties.

- Structure
    - In the left subtree the value of node is less than or equal to its parent's node value.
    - In the right subtree the value of node is greater than to its parent's node value.

- The binary search tree does'nt store the index of its data element rather it relies on implicit data structure to keep the
    record where each element is.
    Hence, it perform faster insertion and deletion than "Binary tree".



*/ 

import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTreeNode1{
    public int value, height;  // height attr is not used !!!!!!!!!!!!!!!!!!!!!.
    public BinarySearchTreeNode1 left, right;

}

class BinarySearchTree1{
    BinarySearchTreeNode1 root;

    public BinarySearchTree1(){
        root = null;
    }

    private BinarySearchTreeNode1 pureInsert(BinarySearchTreeNode1 currentNode, int value){
        if (currentNode == null){
            BinarySearchTreeNode1 newNode = new BinarySearchTreeNode1();
            newNode.value = value;
            System.out.println("The value inserted successfully.");
            return newNode;
        }
        // Below insertion logic is hard! and maybe unnecessary.

        /*  Break down
            - If code reaches here that mean root node is not null for a sub tree
            - "pureInsert" recursive call return same node if it exit(occur unit no node is found) or return a new node
               if not(occur only 1 time, that where insertion happen).
        */ 
        else if (value <= currentNode.value){
            currentNode.left = pureInsert(currentNode.left, value);  // T.C - O(N/2)
            return currentNode;
        }
        else {
            currentNode.right = pureInsert(currentNode.right, value);   // T.C - O(N/2)
            return currentNode;
        }

        // try to replace a value with another value.
        
        //  T.C - O(logN) & S.C - O(logN) [as recursion usage stack memory] 
    }

    public void insert(int value){
        this.root = pureInsert(this.root, value);
    }

    public void preOrder(BinarySearchTreeNode1 node){
        if (node == null) return;

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);

        // T.C - O(N) & S.C - O(N)
    }

    public void inOrder(BinarySearchTreeNode1 node){
        if (node == null) return ;

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);

        // T.C - O(N) & S.C - O(N)
    }

    public void postOrder(BinarySearchTreeNode1 node){
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");

        // T.C - O(N) & S.C - O(N)
    }

    public void levelOrder(){

        if (this.root == null){
            System.out.println("BST is empty.");
            return;
        }
        
        Queue<BinarySearchTreeNode1> queue = new LinkedList<BinarySearchTreeNode1>();
        queue.add(this.root);

        BinarySearchTreeNode1 presentNode;
        while(!queue.isEmpty()){
            presentNode = queue.remove();
            System.out.print(presentNode.value + " ");

            if (presentNode.left != null){
                queue.add(presentNode.left);
            }

            if (presentNode.right != null){
                queue.add(presentNode.right);
            }

        }
        System.out.println();
    }

    public BinarySearchTreeNode1 search(BinarySearchTreeNode1 node, int value){
        if (node == null){
            System.out.println("Failed, Node not found in BT");
            return null;
        }
        else if (node.value == value){
            System.out.println("Success, Node found in BT");
            return node;
        }
        else if (value < node.value){
            return search(node.left, value);    // T.C - O(N/2)
        }
        else {
            return search(node.right, value);   // T.C - O(N/2)
        }
        /* first it narrow down the target and return it at every recursive call that has been made i.e target node is return
            at every return statement
        */

        /* T.C - O(logN) & T.C - O(logN)
           The recursive call T.C is O(N/2) as it eliminate almost half(not exactly half) of possibilities at each call but
            over all T.C is O(logN) as if we thoroughly analyze its operation time & operation it take. 
           */
    }

    // Minimum node
    public  BinarySearchTreeNode1 minNode(BinarySearchTreeNode1 givenRoot){
        if (givenRoot.left == null){
            return givenRoot; 
        }
        else{
            return minNode(givenRoot.left);
        }
    }

    /* Delete node

        - Three main cases
        1- If given node is a leaf node (no children).
            -> simply delete the node

        2- If given node has one child.
            -> Link the node's parent to its child.

        3- If given node has two child.
            - Replace the given node value with its successor value and then delete the successor. The successor is a node 
              which value is just greater than the given node. Its is the leftest node in given node's right subtree. 
            
            - This method will call delete again to delete successor node. 
              ie it will continue until the condition is changed into first 2 cases.
        
    */
    public BinarySearchTreeNode1 deleteNode(BinarySearchTreeNode1 givenRoot, int value){
        if (givenRoot == null){
            System.out.println("Node not found");
            return null;
        }
        
        if (value < givenRoot.value){
            givenRoot.left = deleteNode(givenRoot.left, value);
        }
        else if (value > givenRoot.value){
            givenRoot.right = deleteNode(givenRoot.right, value);
        }

        // if given node value matches.
        else{
            // If given node has two child.
            if (givenRoot.left != null && givenRoot.right != null){
                BinarySearchTreeNode1 tempNode = givenRoot;
                BinarySearchTreeNode1 minNodeForRight = minNode(tempNode.right);
                givenRoot.value = minNodeForRight.value;
                givenRoot.right = deleteNode(givenRoot.right, minNodeForRight.value);
            }

            // for given node having only one child.
            else if (givenRoot.left != null) givenRoot = givenRoot.left;
            
            else if (givenRoot.right != null) givenRoot = givenRoot.right;

            // for given node being a leaf node.
            else{
                givenRoot = null;
            }
            /* The fact that at beginning first we have check for two child is crucial & "VERY" logical. 
                You can also use reverse direction approach but that will be lengthy.

               Like array, variables of same object store reference of object, not create another object while assigning.
            */

        }

        return givenRoot;

        // TC - O(logN) & SC - O(logN)
    }

    public void deleteBST(){
        this.root = null;
        System.out.println("BST deleted successfully.");
        
        // TC - O(1) & SC - O(1) 
    }





}



public class L16_Binary_Search_tree {
    public static void main(String[] args) {
        
        BinarySearchTree1 bst = new BinarySearchTree1();

        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);

        bst.preOrder(bst.root);
        System.out.println();

        bst.inOrder(bst.root);
        System.out.println();

        bst.levelOrder();

        bst.search(bst.root, 40);
        
        bst.deleteBST();
        bst.levelOrder();

        

    }    
}
