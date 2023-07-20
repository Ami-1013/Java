/*
- Array is a contiguous data structure.

- There are 3 steps to create an array in java.
    Declaration - Create a reference to an array.
    Instansilization of array - Create an array
    Initialization - Assign values to the cell of an array.


- Default value of a int array is 0 in every cell.    

- See time and space complexities regarding array in Ch-7, lesson- 10

- There is difference between traversing and accessing an array and they both have different time complexities.

- In array deleting a cell or element is not possible. So we just update its value to lowest value possible [O(1)]. where as in 
  dynamic array deleting mean actually deleting ie resetting indexes and resizing array.

- Java also support cpp array declaration
                        for ex- int nums[];


*/ 

import java.util.Arrays;

public class L4_array1 {
    public static void main(String[] args) {

      int [][] arr = {{3,5,6}, {1,2}};
      
      System.out.println(Arrays.deepToString(arr));
      System.out.println(arr[0].length);
      System.out.println(arr[1].length);

    }
}
