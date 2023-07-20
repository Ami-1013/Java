/*          Stack using linked list

- The new element is inserted at 1st index as applying operation become easy compare to inserting it last as we have to loop
  to get it i.e stack last element equals linked list first element.

- In this isFull() method is not used as linked list don't have concrete size & can be expanded infinitely

*/ 


import mypack.LinkedList;

class Stack2{
  LinkedList ll;

  public Stack2(){

    ll = new LinkedList();
  }

  public void push(int value){
    ll.insertInLinkedlist(value, 0);
    System.out.println("Insertion successful of value: "+ value);

  }

  public boolean isEmpty(){
    if (ll.head == null){
      return true;
    }
    else{
      return false;
    }

  }

  public int pop(){
    int result = -1;
    if (isEmpty() == true){
      System.out.println("The stack is empty.");
    }
    else{
      result = ll.head.value;
      ll.deletionOfNode(0);

    }

    return result;
  }


  public int peek(){
    if (isEmpty() == true){
      System.out.println("The stack is empty.");
      return -1;
    }
    else{
      return ll.head.value;
    }
  }

  public void delete(){
    ll.head = null;
    System.out.println("The stack has been deleted.");
  }


}



public class L10_stack2 {


  public static void main(String[] args) {

  Stack2 st = new Stack2();
  st.push(4);
  st.push(5);
  st.push(6);
  st.push(7);
  // System.out.println(st.isEmpty());

  // System.out.println(st.pop());
  // System.out.println(st.pop());
    
  // System.out.println(st.peek());
  // System.out.println(st.peek());
     
  st.delete();
  System.out.println(st.peek());


  }
}
