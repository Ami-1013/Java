/*      Array Class
- It is not the part of collection frame work.

- It is help to manipulate array with pre define function.

*/ 

import java.util.Arrays;

public class L8_Array_Class {
    public static void main(String[] args) {
        
        int [] nums = {1,3,5,34,56,64,75};

        // binary search (return index), if  array is sorted.
        
        System.out.println(Arrays.binarySearch(nums, 5));


        int[] ele = {2,33,23,3,7,4,46,23,54,1};

        // quick sort
        Arrays.sort(ele);

        System.out.println(Arrays.toString(ele));

    }
}
