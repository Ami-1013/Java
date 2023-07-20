/*
- Dynamic array.
- It at initialization allocate 10 cell and after when they are filled it increase it by (n + n/2 + 1) where n is size.
    Then it dump previous array and copy value automatically to new array.
- For deletion and insertion t.c is O(N).
- When we print object of it, it show whole list rather than object address, this is because it uses "toArray" method in it from
    java.util.Array

*/


import java.util.ArrayList;

public class L1_ArrayList{
    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>();

        // append element
        list.add("Ami");
        list.add("Eren");
        list.add("Crane");

        System.out.println(list);

        // insert element at given index
        list.add(0,"kokushibo");
       
        System.out.println(list);

        // "addAll" method is used to append another list to existing list.

        // get for subscripting 
        System.out.println(list.get(0));
        
        // remove

        list.remove(0); // by index
        list.remove(String.valueOf("Eren")); // by value

        System.out.println(list);


        // "clear" to remove all element
        // list.clear();

        // "set" to change value of a cell
        list.set(0, "Mikasa");

        System.out.println(list);


        // "contains" for searching, return boolean
        System.out.println(list.contains("Mikasa"));

        

    }
}