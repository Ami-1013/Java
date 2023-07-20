/*      Binary Tree

- Binary tree are the data structures in which each node has at most two children, often referred to as left and right children.
- Binary tree is a family of data structure (Binary search tree, Heap tree, AVL, Red Black tree, Syntax tree, they all
  are binary tree). 

Why binary tree?
    - Binary tree are prerequisite for more advance trees like BSL, AVL, Red Black tree.
    - Huffman coding problem, heap priority problem and expression parsing problems can be solved efficiently using binary 
      tree. 

Types of Binary tree
    - Full binary tree.
    - Perfect binary tree.
    - Complete binary tree.
    - Balance binary tree.


Binary Tree traversal
  1- Depth first search
    - Pre order traversal.
    - In order traversal.
    - Post order traversal.
  
  2- Breadth first search
    - Level order traversal. 

  Binary Tree traversals are peculiar. So learn thoroughly its flow of choosing node and its algorithm.  

*/ 

// ---------------------------------------------------------------------------

// Binary tree using Linked List

import java.util.LinkedList;
import java.util.Queue;

class BinaryNode1{
  public String value;
  public BinaryNode1 left, right; // left and right child of a node.
  public int height;
}

class BinaryTreeLL1{
  BinaryNode1 root;

  public BinaryTreeLL1(){
    this.root = null;
  }

  /*  Tree Depth first traversal
    - The accessing of root node, left subtree, right subtree, printing or next value i.e the whole logic is done with 
      respect to current root node(not left node). 
  
  */ 

  // Pre order traversal
  /*  
              root node -> left subtree -> right subtree

    It start from root and then left child is visited until depth of left subtree(1st), then from depth right child is visited.
    up to left subtree(1st), then it move to right subtree(1st). There same process is done as left child is visit till last and
    then from depth right child is visited.

    In short first preference is left child and right is only visit if left is null or already visited. The flow should not 
    be broken it should be continuos.
    While visiting left movement is top to bottom and in right it is bottom to top.
  */ 

  public void preOrder(BinaryNode1 node){
    if (node == null) return;

    System.out.print(node.value + " ");
    preOrder(node.left); //  --> O(N/2)
    preOrder(node.right); //  --> O(N/2)

    // Time complexity - O(N) & Space complexity - O(N)

    /* As it uses recursion for traversal it will also have space complexity[not O(1)]. As it store element in stack memory
     for later calling.
    */
  }

  /* In order traversal

          Left subtree -> root node -> Right subtree
  
    (See video for better understanding)
  */ 
  public void inOrder(BinaryNode1 node){
    if (node == null) return;

    inOrder(node.left); //  --> O(N/2)
    System.out.print(node.value + " ");
    inOrder(node.right); //  --> O(N/2)

    // T.C - O(N)  &   S.C - O(N)

  }

  /*  Post order traversal
        
        Left subtree -> Right subtree -> root node.
  
  */ 
  public void postOrder(BinaryNode1 node){
    if (node == null) return;

    postOrder(node.left); //  --> O(N/2)
    postOrder(node.right); //  --> O(N/2)
    System.out.print(node.value + " ");

    // T.C - O(N)   &   S.C - O(N)
  }


  /*  Level order traversal
    Traversal node according to their level, starting from root to deepest node. Going from left to right.
  */
  public void levelOrder(){
    Queue<BinaryNode1> queue = new LinkedList<BinaryNode1>();
    queue.add(root);

    while (!queue.isEmpty()){
      BinaryNode1 node = queue.remove();
      System.out.print(node.value + " ");
      if (node.left != null){
        queue.add(node.left);
      }
      if (node.right != null){
        queue.add(node.right);
      }
    }
    System.out.println();
    //  T.C - O(N)    &   S.C - O(N)
  }

  // Search by level order traversal
  public void search(String val){
    Queue<BinaryNode1> queue = new LinkedList<BinaryNode1>();
    queue.add(root);

    while (!queue.isEmpty()){
      BinaryNode1 node = queue.remove();

      if (node.value == val){
        System.out.println("The value is found.");
        return;
      }
      else{
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
    }
    System.out.println("The value does'nt exist.");
  }

  /* Insertion by Level order
     It follow Level order flow and insert the node at the first vacant place i.e you can't specify the insert location of node.
  */  
  public void insert(String value){
    BinaryNode1 newNode = new BinaryNode1();
    newNode.value = value;

    if (this.root == null){
      this.root = newNode;
      System.out.println("The node is inserted at Root.");
    }
    else{
      Queue<BinaryNode1> queue = new LinkedList<BinaryNode1>();
      queue.add(root);
      while (!queue.isEmpty()){
        BinaryNode1 presentNode = queue.remove();
        if (presentNode.left == null){
          presentNode.left = newNode;
          System.out.println("Node inserted successfully.");
          break;
        }
        else if (presentNode.right == null){
          presentNode.right = newNode;
          System.out.println("Node inserted successfully.");
          break;
        }
        else{
          queue.add(presentNode.left);
          queue.add(presentNode.right);
        }
      }
    }
    // T.C - O(N)   &   S.C - O(N)
  }

  public BinaryNode1 getDeepestNode(){
    Queue<BinaryNode1> queue = new LinkedList<BinaryNode1>();
    queue.add(root);
    BinaryNode1 presentNode = null;

    while (!queue.isEmpty()){
      presentNode = queue.remove();
      if (presentNode.left != null){
        queue.add(presentNode.left);
      }
      if (presentNode.right != null){
        queue.add(presentNode.right);
      }
    }
    return presentNode;
  }

  public void deleteDeepestNode(){
    // By using Level order traversal.
    Queue<BinaryNode1> queue = new LinkedList<BinaryNode1>();
    queue.add(root);
    BinaryNode1 previousNode , currentNode = null;
    while (!queue.isEmpty()){
      previousNode = currentNode;
      currentNode = queue.remove();
      
      if (currentNode.left == null){
        previousNode.right = null; // if left child is null then previous node right child is deepest node.
        return;
      }
      else if (currentNode.right == null){
        currentNode.left = null; // if right child is null then current node left child is deepest node.
        return;
      }
      queue.add(currentNode.left);
      queue.add(currentNode.right);
    }
  }

  // replaces the given node value to the deepest node and delete the deepest node.
  public void deleteNode(String value){
    Queue<BinaryNode1> queue = new LinkedList<BinaryNode1>();
    queue.add(root);
    BinaryNode1 presentNode;

    while(!queue.isEmpty()){
      presentNode = queue.remove();
      if (presentNode.value == value){
        presentNode.value = getDeepestNode().value;  //   T.C -> O(N)
        deleteDeepestNode();  //   T.C -> O(N)
        System.out.println("Node successfully deleted from the tree.");
        return;
      }  
      else{
        if (presentNode.left != null) queue.add(presentNode.left);
        if (presentNode.right != null) queue.add(presentNode.right);
      }
    }

    System.out.println("Node does'nt exist in the tree.");

    /*  T.C - O(N)  &   S.C - O(N)
      "getDeepestNode" & "deleteDeepestNode" take O(N) T.C but total time complexity is not O(N^2) because this methods occur
      one time, "not every each time". 
    */
  }

  public void deleteBinaryTree(){
    this.root = null;
    System.out.println("Binary Tree has been deleted successfully.");
    // T.C - O(1)  & S.C - O(1)
  }


}


public class L15_binary_tree1_LinkedList {
  public static void main(String[] args) {

    BinaryTreeLL1 bt = new BinaryTreeLL1();
    bt.insert("N1");
    bt.insert("N2");
    bt.insert("N3");
    bt.insert("N4");
    bt.insert("N5");
    bt.insert("N6");
    bt.insert("N7");
    bt.insert("N8");
    bt.insert("N9");

    bt.levelOrder();
    

    bt.deleteNode("N5");

    bt.levelOrder();
    bt.deleteBinaryTree();
    System.out.println(bt.root);





  }
}
