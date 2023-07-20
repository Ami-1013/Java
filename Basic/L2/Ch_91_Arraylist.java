
/*          Array list

- Its a modified array where you can resize and modify it.

- ".size()" method is used to get the size of it.
- ".add(value, index)" is used to add.

- As its a modified array, you can't get element or iterate it like normal array. You have to use 
".get(index)" method to iterate.

- Abstract          
ArrayList<E> arr = new ArrayList<>();

- where "E" can be datatype like String, int , float etc.
- Initially, if not any specific size of array is not given then it make by default an array of 10
element.

- for (int ele: arr) --> works fine with ArrayList.

*/

import java.util.ArrayList;

public class Ch_91_Arraylist {
    public static void main(String[] args) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();

        l1.add(11);
        l1.add(12);
        l1.add(13);
        l1.add(14);

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(2);


        System.out.println(arr.addAll(1,l1)); // add another arraylist to a arraylist from a specific index, by default at end.

        System.out.println(arr.contains(5));  // return a boolean
        System.out.println(arr.indexOf(2));
        System.out.println(arr.lastIndexOf(2));
        System.out.println(arr.set(9, 222));

        System.out.println("\n-----------------------\n");
        
        for (int i=0; i< arr.size(); ++i){
            // arr[i], will give error.
            System.out.println(arr.get(i));
        }
        
        // for (int ele: arr){
        //     System.out.println(ele);
        // }

    }
    
}
