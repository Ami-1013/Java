/*      Set

- "Set" is a interface. Can be created from "HashSet", "LinkedHashSet" and "TreeSet" class.
    - "HashSet" show properties of hash and set.
    - "LinkedHashSet" show properties of linked list, hash and set.
    - "TreeSet" shows the properties of Binary search tree and set. Hence elements are sorted in Binary search tree order.

    -> Methods are same in LinkedHashSet and HashSet for operation in set.
    -> But in LinkedHashSet order in maintain in which elements are inserted whereas in HashSet order is random.

    -> t.c 
        HashSet - O(1)
        TreeSet - O(LogN)


- In set duplicate element can't be inserted. Hence it store unique elements.

- It work on hashing. It changes its element to hash.
- It have random order of elements.

- Some command
    - "isEmpty"
    - "size"
    - "clear", to delete all elements of set.


*/ 

import java.util.HashSet;
import java.util.Set;


public class L6_Set {
    public static void main(String[] args) {
        

        Set<Integer> set = new HashSet<>();

        // "add" for insertion
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(3);

        System.out.println(set); // random order

        // can't insert duplicate element.
        set.add(3);
        set.add(3);

        // "remove" for deletion
        set.remove(2);

        System.out.println(set);


        // "contain" return boolean, if given element exist in set
        System.out.println(set.contains(3));

        System.out.println(set.contains(33));









    }
    
}
