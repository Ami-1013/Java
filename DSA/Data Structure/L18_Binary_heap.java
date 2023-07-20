/*      Binary Heap

- It is a binary tree which some additional properties.
- A binary heap is either minimum or maximum heap.
    - In min heap, the key at root must be minimum among all keys present in binary heap. The same property must be true for
      all nodes in binary heap.
    - In max heap, the key at root must be maximum among all keys present in binary heap. The same property must be true for
      all nodes in binary heap  

- It is a complete tree (all levels are completely filled except possibly the last level and the last level has all keys as 
  "left" as possible). This property of binary tree make them suitable to be stored in array.       

*/ 

/*  Binary heap can be created by 2 methods.
  - By array
  - By reference/pointer.
*/

// ------------------------------------------------------------------


// Binary heap using array

class BinaryHeap{
  int arr[];
  int sizeOfTree;

  public BinaryHeap(int size){
    arr = new int[size + 1];  // as first index is not used in array for mathematic convenience
    sizeOfTree = 0;
    System.out.println("Binary heap tree has been created.");
    
    // tc - O(1)  & sc - O(N)
  }

  public boolean isEmpty(){
    return this.sizeOfTree == 0;  // This code is a beauty!.

    // tc - O(1)  & sc - O(1)
  }
  public boolean isFull(){
    return this.arr.length == sizeOfTree;
  }

  /*  Peek
    - Return the root of binary heap.
  */ 
  public Integer peek(){
    if (isEmpty()){
      System.out.println("The Binary heap tree is empty");
      return null;
    }
    return arr[1];

    // tc - O(1)  & sc - O(1)
  }

  public int sizeOfBH(){
    return sizeOfTree;
  }

  public void levelOrder(){
    for (int i=1; i<=this.sizeOfTree; ++i){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }


  /*   Heapify for insertion
    - As node is inserted at last level from left. Heapify start from bottom to top
  */
  public void heapifyBottomToTop(int index, String heapType){

    int parent = index/2;  // if index is odd, only value before decimal is read.

    if (index <= 1){
      return;
    }

    if (heapType == "min"){
      if (arr[index] < arr[parent]){
        int temp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = temp;
      }

      else if (heapType == "max"){
        if (arr[index] > arr[parent]){
          int temp = arr[index];
          arr[index] = arr[parent];
          arr[parent] = arr[temp];
        }
      }

    }

    heapifyBottomToTop(parent, heapType);   // tc - O(logN), as it is called every time for parent.

    // tc - O(logN) & sc - O(logN)

  }

  public void insert(int value, String heapType){

    if (!isFull()){
      sizeOfTree++;
      arr[this.sizeOfTree] = value;

      heapifyBottomToTop(this.sizeOfTree, heapType);  // tc - O(logN)
      System.out.println("Insertion successful.");
    }

    else {
      System.out.println("Failed, binary heap is full.");
    }

    //  tc - O(logN)  & sc - O(logN)

  }

  /*  Extract node (deleting)
  - In binary heap only root node is deleted.
  - Procedure
    - First root node is deleted.
    - Last node is placed at root node place.
    - Then "Top to Bottom" approached is used to heapify depending upon the type of heap (max or min).

  */ 

  // heapify top to bottom
  public void heapifyTopToBottom(int index, String heapType){
    
    // below are index of child
    int leftChild = 2 * index ;
    int rightChild = 2 * index + 1;
    int swapChild = leftChild; // if index has two child its value will be changed in below code. 
                              // Assigning because of initialization error.
                                

    if (leftChild > this.sizeOfTree){
      return;
    } 

    if (heapType == "max"){
      // if node has only one child ie leftChid and it is parent of last node
      if (sizeOfTree == leftChild){
        if (arr[index] < arr[leftChild]){
          int temp = arr[index];
          arr[index] = arr[leftChild];
          arr[leftChild] = temp;
        }
        return;
      }
      // if node has 2 child, greatest one will be heaped in "max" heap.
      else {
        if (arr[leftChild] > arr[rightChild]){
          swapChild = leftChild;
        }
        else {
          swapChild = rightChild;
        }

        if (arr[index] < arr[swapChild]){
          int temp = arr[index];
          arr[index] = arr[swapChild];
          arr[swapChild] = temp;
        }
      }
    }

    if (heapType == "max"){
      // if node has only one child ie leftChid
      if (sizeOfTree == leftChild){
        if (arr[index] < arr[leftChild]){
          int temp = arr[index];
          arr[index] = arr[leftChild];
          arr[leftChild] = temp;
        }
        return;
      }
      // if node has 2 child, greatest one will be heaped in "max" heap.
      else {
        if (arr[leftChild] > arr[rightChild]){
          swapChild = leftChild;
        }
        else {
          swapChild = rightChild;
        }

        if (arr[index] < arr[swapChild]){
          int temp = arr[index];
          arr[index] = arr[swapChild];
          arr[swapChild] = temp;
        }
      }
    }
    
    else if (heapType == "min"){
      // if node has only one child ie leftChid
      if (sizeOfTree == leftChild){
        if (arr[index] > arr[leftChild]){
          int temp = arr[index];
          arr[index] = arr[leftChild];
          arr[leftChild] = temp;
        }
        return;
      }
      // if node has 2 child, greatest one will be heaped in "max" heap.
      else {
        if (arr[leftChild] < arr[rightChild]){
          swapChild = leftChild;
        }
        else {
          swapChild = rightChild;
        }

        if (arr[index] > arr[swapChild]){
          int temp = arr[index];
          arr[index] = arr[swapChild];
          arr[swapChild] = temp;
        }
      }
    }
  
  heapifyTopToBottom(swapChild, heapType);
  //  swapChild will have value until it reaches the last node or parent of last node
  
  // tc - O(logN) & sc - O(logN)
  }

  public int extractHeadOfBP(String heapType){
    if (isEmpty()){
      System.out.println("Failed, binary heap is empty.");
      return -1;
    }
    else{
      int extractValue = arr[1];  // location of root.
      arr[1] = arr[this.sizeOfTree];
      this.sizeOfTree--;
      heapifyTopToBottom(1, heapType);
      return extractValue;
    }

    // tc - O(logN) & sc - O(logN)
  }

  public void deleteBH(){
    this.arr = null;
    this.sizeOfTree = 0;
    System.out.println("Binary heap has been successfully deleted.");
  }

}







public class L18_Binary_heap {
    public static void main(String[] args) {
      
      BinaryHeap bh = new BinaryHeap(5);
      bh.peek();
      bh.insert(10, "min");
      bh.insert(15, "min");
      bh.insert(20, "min");
      bh.insert(1, "min");      
      bh.levelOrder();

      bh.extractHeadOfBP("min");
      bh.levelOrder();

      


    }
}
