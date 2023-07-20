/*      Binary Tree using Array

- Main component
 1- Fixed size.
 2- Last index (to insertion easier).

Formula for insertion of child.
 First cell of array is not used and root node is inserted at index 1 to make maths calculation simple.
 - Left_child_index = 2 * parent_index
 - Right_child_index = 2 * parent_index + 1

 Left child is even and right child is odd in index. As tree starts with root at 1st index. This is vital in insertion used
 lastUsedIndex attr.


*/ 

class BinaryTreeA1{
    String[] arr;
    int lastUsedIndex;

    public BinaryTreeA1(int size){
        arr = new String[size +1];
        lastUsedIndex = 0;
        // T.C - O(1)  & S.C - O(N + 1)
    }

    public boolean isFull(){
        return arr.length-1 == lastUsedIndex;
        // T.C - O(1)
    }

    public void insert(String value){
        if (!isFull()){
            lastUsedIndex++;
            arr[lastUsedIndex] = value;
            System.out.println("Insertion successful of value: "+ value);
        }
        else{
            System.out.println("The Tree is full, can't insert value: " + value);
        }
        // T.C - O(1)  &  S.C - O(1)
    }

    // We used recursion for traversal, Here base condition is peculiar.
    public void preOrder(int index){
        if (index > this.lastUsedIndex){
            return;
        } 

        System.out.print(arr[index] + " ");
        preOrder(index * 2); // left child index.                  --> O(N/2)
        preOrder(index*2 + 1); // right child index.               --> O(N/2)

        // T.C - O(N)  &  S.C - O(N)
    }

    public void inOrder(int index){
        if (index> this.lastUsedIndex) return;

        inOrder(index * 2); // left child index.                  --> O(N/2)
        System.out.print(this.arr[index] + " ");
        inOrder(index * 2 + 1); // right child index.               --> O(N/2)

        // T.C - O(N) & S.C - O(N)
    }

    public void postOrder(int index){
        if (index > this.lastUsedIndex) return;

        postOrder(index * 2); // left child index.                  --> O(N/2)
        postOrder(index * 2 + 1); // right child index.               --> O(N/2)
        System.out.print(this.arr[index] + " ");

        // T.C - O(N) & S.C - O(N)
    }

    public void levelOrder(){
        for (int i=1; i<=this.lastUsedIndex; ++i){
            System.out.print(this.arr[i] + " ");
        }
        // T.C - O(N) & S.C - O(1)
        // Level order traversal is better in array than linked list.
    }

    // level order search 
    public int search(String value){
        for (int i=1; i<=this.lastUsedIndex; ++i){
            if (arr[i] == value){
                return i;
            }
        }

        System.out.println("Value not found.");
        return -1;

        // T.C - O(N) & S.C - O(1)
    }

    /* Delete
        Here given node is actually replace by deepest node and deepest node is deleted. By Level order traversal 
    */ 
    public void deleteNode(String value){
        int location = this.search(value);   // T.C - O(N)

        if (location != -1){
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex --;
            /* Here we have not set element of lastUsedIndex in arr not null because in traversal it will not see it and in
               insertion LastUsedIndex will automatically will replace the value of it.
               The logic is in how LastUsedIndex influence the code.
            */
            System.out.println("Node successfully deleted.");
        }

        // T.C - O(N) & S.C - O(1)
    }

    public void deleteEntireBT(){
        this.arr = null;
        System.out.println("BT has been successfully deleted.");

        // T.C - O(1) & S.C - O(1)
    }

}


public class L15_Binary_tree2_Array {
    public static void main(String[] args) {
        
        BinaryTreeA1 bt = new BinaryTreeA1(9);
        bt.insert("N1");
        bt.insert("N2");
        bt.insert("N3");
        bt.insert("N4");
        bt.insert("N5");
        bt.insert("N6");
        bt.insert("N7");
        bt.insert("N8");
        bt.insert("N9");

        bt.preOrder(1);
        System.out.println();
        bt.inOrder(1);
        System.out.println();
        bt.postOrder(1);
        System.out.println();
        bt.levelOrder();
        System.out.println();

        System.out.println(bt.search("N8"));

        bt.deleteNode("N3");
        // bt.deleteNode("N9");
        bt.levelOrder();
        System.out.println();
        


    }
    
}
