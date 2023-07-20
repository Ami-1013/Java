/*      AVL Tree

- AVL stands for Adelson-Velskii and Landis, they are this tree inventors.

- An AVL tree is self-balancing Binary Search Tree where the difference between the height of left and right subtree can't be
  more than one for "all nodes".

- If at any time the height of left and right sub tree differ by more than one, then re-balancing is done to restore the AVL
  properties, this process is called rotation.

  As it perform rotation after insertion and deletion so there are several cases of tree that will never occur. Keep it in mind.

- Why AVL Tree
    - In tree data structure time complexity increases as the height of tree increases and at worst case its become O(N) [becomes
      like linked list].
    - As AVL tree is a balance tree(its nodes are balanced) its height is minimum hence always O(logN) time complexity ie 
      better performance.
    
    Therefore AVL tree enforces some rules while insertion or deletion so that is balance is not disturbed and every time when
    its balance is compromised it perform "rotation" to gain balance again.
*/ 

import java.util.LinkedList;
import java.util.Queue;


class AVLTreeNode1{
    int value, height;
    AVLTreeNode1 left, right;

    public AVLTreeNode1(){
        this.height = 0;
    }

}

class AVLTree1{
    AVLTreeNode1 root;

    public AVLTree1(){
        this.root = null;
    }

    public void preOrder(AVLTreeNode1 node){
        if (node == null) return;

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);

    }

    public void inOrder(AVLTreeNode1 node){
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public void postOrder(AVLTreeNode1 node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder(){
        if (this.root == null) {
            System.out.println("The AVL Tree is empty.");
            return;
        }

        Queue<AVLTreeNode1> queue = new LinkedList<AVLTreeNode1>();
        queue.add(this.root);

        AVLTreeNode1 tempNode;
        while (!queue.isEmpty()){
            tempNode = queue.remove();
            System.out.print(tempNode.value + " ");

            if (tempNode.left != null) queue.add(tempNode.left);
            if (tempNode.right != null) queue.add(tempNode.right);
        }
        System.out.println();
    }

    public AVLTreeNode1 search(AVLTreeNode1 givenRoot, int value){
        if (givenRoot == null){
            System.out.println("Failed, given value not found.");
            return null;
        }

        else if (givenRoot.value == value){
            System.out.println("Success, given value found.");
            return givenRoot;
        }
        else if (givenRoot.value <= value) return search(givenRoot.left, value);
        
        else return search(givenRoot.right, value);

    }

    /*  Insertion 
        - Two cases:
            1- Rotation is not required.
            
            2- Rotation is required.
                - To identify condition we have to find path from dis-balance node to it's grandchild.
                    Hence node is checking starts from "bottom node to up" then next bottom node.
                    A leaf node is always balanced as its does'nt have child.
                - If a node is dis-balance and it have grandchild, great-grand child .. so on, still we check the to 
                    to only grandchild. As it can have more than 1 grand child, that grand child will be choose whose 
                    have greatest height(length of path from that node to its deepest node).

                Types of condition(see in video Ch-21 L-4,5,6,7).
                    "Rather mugging them up try to use logic as it very easy." !

                    - LL (left left) -> Right rotation 
                    - LR (left right) -> left rotation of root left child and then right rotation for root node.
                                        i.e first it is changed to LL and then right rotation

                    - RR (right right) -> left rotation
                    - RL (right left) -> right rotation for root right child and then left rotation for root.
                                        i.e first it is changed to RR then left rotation.

                    Remember, the number of links broken = number of new links.                    
                    
    */ 


    // Helper function ---------------------------------------------------------

    // getHeight
    public int getHeight(AVLTreeNode1 node){
        if (node == null) return 0;

        return node.height;
    } 

    // rotateRight
    private AVLTreeNode1 rotateRight(AVLTreeNode1 disBalanceNode){
        AVLTreeNode1 newRoot = disBalanceNode.left;
        disBalanceNode.left = disBalanceNode.left.right;
        newRoot.right = disBalanceNode;
        
        disBalanceNode.height = 1 + Math.max(getHeight(disBalanceNode.left), getHeight(disBalanceNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        
        return newRoot;
    }

    // rotateLeft
    private AVLTreeNode1 rotateLeft(AVLTreeNode1 disBalanceNode){
        AVLTreeNode1 newRoot = disBalanceNode.right;
        disBalanceNode.right = disBalanceNode.right.left;
        newRoot.left = disBalanceNode;

        disBalanceNode.height = 1 + Math.max(getHeight(disBalanceNode.left), getHeight(disBalanceNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(disBalanceNode.right));

        return newRoot;
    }

    // checking balance
    public int getBalance(AVLTreeNode1 node){
        if (node == null) return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    // insertion
    private AVLTreeNode1 insertNode(AVLTreeNode1 node, int nodeValue){
        if (node == null){
            AVLTreeNode1 newNode = new AVLTreeNode1();
            newNode.value = nodeValue;
            newNode.height = 1;

            return newNode;
        }
        else if (nodeValue < node.value){
            node.left = insertNode(node.left, nodeValue);  // tc - O(logN)
        }
        else node.right = insertNode(node.right, nodeValue);    // tc - O(logN)

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);


        // Condition if tree after insertion become dis-balance
        
        if (balance > 1 && nodeValue < node.left.value) return rotateRight(node);

        if (balance > 1 && nodeValue > node.left.value){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && nodeValue > node.right.value) return rotateLeft(node);       

        if (balance < -1 && nodeValue> node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;

        // tc - O(logN) &   sc - O(logN)
    }

    public void insert(int value){
        this.root  = insertNode(root, value);    
    }


    /*  Deletion

    1- Rotation is not required
        - Node(deepest) is a leaf node.
        - Node has one child.
        - Node has two child.
    
    2- Rotation is required
        - LL
        - LR
        - RR
        - RL 
    
    */ 

    // minimum node
    public AVLTreeNode1 minNode(AVLTreeNode1 givenRoot){
        if (givenRoot.left == null) return givenRoot;

        return minNode(givenRoot.left);
    }

    // delete node
    private AVLTreeNode1 deleteNode(AVLTreeNode1 node, int value){
        if (node == null){
            System.out.println("Node not found in AVL tree.");
            return node;
        }

        else if (value < node.value){
            node.left = deleteNode(node.left, value);
        }

        else if (value > node.value){
            node.right = deleteNode(node.right, value);
        }

        else{
            // node has two child
            if (node.left != null && node.right != null){
                AVLTreeNode1 tempNode = node;   // tempNode unnecessary 
                AVLTreeNode1 minNodeForRight = minNode(tempNode.right);
                node.value = minNodeForRight.value;
                // System.out.println("Temp: "+ tempNode.value + " Node: "+ node.value);
                node.right = deleteNode(node.right, minNodeForRight.value);
            }
            // it has one child
            else if (node.left != null) node = node.left;
            else if (node.right != null) node = node.right;

            // it is a leaf node
            else node = null;
        }


        int balance = getBalance(node);
        
        if (balance > 1 && getBalance(node.left) >= 0) return rotateRight(node); // LL
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);   // LR
        }

        if (balance < -1 && getBalance(node.right) <= 0) return rotateLeft(node);   // RR
        if (balance < -1 && getBalance(node.right) > 0){
            node.right = rotateRight(node.right);
            return rotateLeft(node);    // RL
        }
        
        return node;

        // tc - O(logN) & sc - O(logN)
    }
    
    public void delete(int value){
        this.root = deleteNode(this.root, value);
    }

    public void deleteAVLTree(){
        this.root = null;
        System.out.println("The AVL tree has been successfully deleted.");
        
        // tc - O(1)    &   sc - O(1)
    }

}




public class L17_AVL_tree {
    public static void main(String[] args) {
    
        AVLTree1 avl = new AVLTree1();

        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(25);

        avl.levelOrder();

        avl.delete(10);
        avl.levelOrder();

        avl.deleteAVLTree();
        System.out.println(avl.root);


    }    
}
