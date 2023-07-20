// Q3- Stack of plates


// ----------------- INCOMPLETE ---------------------------------
import java.util.EmptyStackException;
class StackNode{
    int value;
    StackNode above, below;

    StackNode(int value){
        this.value = value;
    }
}

class Stack4{
    private int capacity;
    StackNode top, bottom;
    int size = 0;

    Stack4(int capacity){
        this.capacity = capacity;
    }

    public boolean isFull(){
        // beautiful and logical code below.
        return capacity == size;
    }

    public void join(StackNode setTop, StackNode setBottom){ // here parameter setTop and setBottom are StackNode
        // shortcut code
        if (setBottom.above == null) setBottom.above = setTop;
        if (setTop.below == null) setTop.below = setBottom;
    }

    public boolean push (int value){
        if (size>= capacity) return false;
        size++;
        StackNode  node = new StackNode(value);
        if (size == 1) {
            bottom = node;
            top = node;
            return true; // bottom node "below" attr refer to itself if we use "join" method. Hence it can't be pop.
        } 
        join(node, top);
        top = node;
        return true;
    }

    public int pop(){
        if (top == null) throw new EmptyStackException();
        int result = top.value;
        top = top.below;
        size --;

        return result;
    }

    

}


public class L14_2Stack_ques {
    public static void main(String[] args) {
        
        Stack4 st = new Stack4(5);
        st.push(3);
        st.push(8);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

    }
    
}
