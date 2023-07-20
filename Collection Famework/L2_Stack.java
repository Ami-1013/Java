

import java.util.Stack;

public class L2_Stack {
    public static void main(String[] args) {
        
        Stack<String> st = new Stack<>();

        // "push" for insertion.
        st.push("Ami");
        st.push("Kokushibo");
        st.push("Virgil");

        System.out.println(st);


        // "peek" for to return last element
        System.out.println(st.peek());

        // "pop" for deletion of last element and return deleted element.
        st.pop();
        System.out.println(st);

    }
}
