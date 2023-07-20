
// Q1- Implement 3 stack in a array
class ThreeInOne{
    private int numberOfStack = 3; // Predefine number of stacks, as in question.
    private int stackCapacity; // elements that each stack can hold i.e it size.
    private int[] values;
    private int[] sizes; // store the size of stacks

    public ThreeInOne(int stackSize){
        stackCapacity = stackSize;
        values  = new int[stackSize * numberOfStack];
        sizes = new int[numberOfStack];
    }

    public boolean isFull(int stackNum){
        if (sizes[stackNum] == stackCapacity){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(int stackNum){
        if (sizes[stackNum] == 0){
            return true;
        }
        else {
            return false;
        }
    }

    // return the index of last element of stack with respect to the main array (values[]).
    private int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity;  // stack Number start with 0.
        int size = sizes[stackNum];

        return offset + size -1;
    }

    public void push(int stackNum, int value){
        if (isFull(stackNum)){
            System.out.println("The stack is full of index "+ stackNum);
        }
        else {
            // values[stackNum * stackCapacity + sizes[stackNum] ] = value;
            // sizes[stackNum] ++;

            // Impressive logic
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }
    }

    public int pop(int stackNum){
        int result = -1;
        if (isEmpty(stackNum)){
            System.out.println("The selected stack is empty.");
        }
        else{
            result = values[indexOfTop(stackNum)];
            values[indexOfTop(stackNum)] = -1;
            sizes[stackNum]--;
        }
        return result;
    }

    public int peek(int stackNum){
        if (isEmpty(stackNum)){
            System.out.println("The selected stack is empty.");
            return -1;
        }
        else{
           return values[indexOfTop(stackNum)];
        }
       
    }

}

//Q2- Creating a stack with min() f and min(), push, pop should have O(1)
class NodeSt1{
    int value;
    NodeSt1 next;   // To point the next stack.

    public NodeSt1(int value, NodeSt1 next){
        this.value = value;
        this.next = next;
    }

}
class StackMin{
    NodeSt1 top, min;

    public StackMin(){
        this.top = this.min = null;
    }

    public int min(){
        return min.value;
    }

    public void push(int value){
        if (min == null){
            min = new NodeSt1(value, min);
        }
        else if (min.value < value){
            min = new NodeSt1(min.value, min);
        }
        else{
            min = new NodeSt1(value, min);
        }

        top = new NodeSt1(value, top);
        /*  Every time a new stack is pushed new node will be linked to both "min" and "top" attributes.
        */ 
    }
    

    public int pop(){
        min = min.next;
        int result = top.value;
        top = top.next;

        return result;
    }
    
}

// Q2 **** mine logic - better space complexity
/*
 class Nodest2 {
    int value;
    Nodest2 next;
    int min;

    public Nodest2(int value, Nodest2 next){
        this.value = value;
        this.next = next;
    }
}

class Stackm{
    
    Nodest2 top;

    Stackm (){
        top = null;
    }

    public void push(int value){

        if (top == null){
            top = new Nodest2(value, top);
            top.min = value;
        }
        else if (top.min < value){
            int temp = top.min;
            top = new Nodest2(value, top);
            top.min = temp;
        }
        else {
            top = new Nodest2(value, top);
            top.min = value;
        }

    }

    public int pop(){
        int result = top.value;
        top = top.next;
        return result;
    }

    public int min (){
        return top.min;
    }
}

*/




public class L14_1Stack_ques {
    public static void main(String[] args) {
        
        // Q1 ------------------

        /* 
        ThreeInOne st = new ThreeInOne(4);
        System.out.println(st.isEmpty(2));
        System.out.println(st.isFull(1));

        st.push(0,1);
        st.push(0,2);
        st.push(0,3);
        
        st.push(1,4);
        st.push(1,5);
        st.push(1,6);
        st.push(1,63);

        st.push(2,7);

        System.out.println(st.isEmpty(1));
        System.out.println(st.isFull(1));

        System.out.println(st.pop(1));
        
        */


    }
    
}
