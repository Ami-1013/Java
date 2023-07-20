/*          Stack
- Data structure that are stored in Last in-first out(LIFO) manner. They are store vertically in memory. Ex pile of books.
- Used in when functionality is used in the last coming data or last value. Ex- chrome back button or in undo or redo
  functionality in OS.
- New element is added only at last or top.

- "isFull" & "isEmpty" is called helper f. As this function help the another function.
*/ 

// Creating stack with an array.
class Stack{
    int[] arr;
    int topOfStack; // it is the index of the stack.

    // creating a stack
    public void createStack(int size){
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("The stack has been created of size: " + size);
    }

    public boolean isEmpty(){
        if (topOfStack == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFull(){
        if (topOfStack == this.arr.length -1){
            // System.out.println("Stack is full.");
            return true;
        }
        else{
            return false;
        }
    }

    // push method
    public void push(int value){
        if (isFull()){
            System.out.println("The stack is full.");
        }
        else{
            arr[topOfStack+1] = value;
            topOfStack++;
            System.out.println("The value has been inserted in stack.");
        }
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("The stack is empty.");
            return -1;
        }
        else{
            int topStack = arr[topOfStack];
            this.topOfStack--;
            return topStack;
        }
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("The stack is empty.");
            return -1;
        }
        else{
            return arr[topOfStack];
        }
    }

    // Delete method delete the stack where as pop delete the last element of stack.
    public void delete(){
        arr = null;
        System.out.println("Stack successfully deleted.");
    }

    // Traversal (My own contribution)
    public void traversal(){
        if (isEmpty()){
            System.out.println("The stack is empty");
        }
        else{
            System.out.println("\n    ----TOP---- \n");
            for(int i=topOfStack; i>=0; --i){
                System.out.println("\t " + arr[i]);
            }
            System.out.println("\n    ----END---- \n");
           
        }
    }

}

public class L9_stack {
    public static void main(String[] args) {
        
        Stack st = new Stack();
        st.createStack(5);
        // System.out.println(st.isEmpty());

        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.traversal();

        // System.out.println(st.pop());
        // System.out.println(st.pop());

        

    }
    
}
