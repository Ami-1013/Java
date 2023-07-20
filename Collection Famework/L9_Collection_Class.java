/*      Collection class

- It contain pre define helpful methods.
- It is "Collections", not "Collection" (interface)

*/ 

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;


public class L9_Collection_Class {
    public static void main(String[] args) {
        
        List<Integer> list = new ArrayList<>();

        list.add(34);
        list.add(4);
        list.add(53);
        list.add(27);
        list.add(76);
        list.add(54);

        System.out.println("Min element: " + Collections.min(list));
        System.out.println("Max element: " + Collections.max(list));


    }
    
}
