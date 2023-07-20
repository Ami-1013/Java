public class Ch_26_Array {
    
    public static void main(String[] args){

        // Array - collection of similar type of data.

        // Extract - datatype [] array_name


        int [] marks = new int [5];
        // We have done memory allocation, ie array will contain 5 int element. 0 to 4 (index).
        // "5" in [], is about the memory allocation of array, not element.

        
        /*
            int [] marks, is declaration.
            marks = new int [5], is memory allocation.

            here we have declared and allocated at the same time
        
        */ 
        
        
        // Array store one data type through out it.
        // As a int contain 4 byte, hence "marks" array which will contain 5 int will have 5*4 bytes ie 20 byte.

        // Array is the object in java.


        // -----------------------------
        // Inserting value in array

        // marks[0] = 100;
        // marks[1] = 70;
        // marks[2] = 30;
        // marks[3] = 78;
        // marks[4] = 81;

        // marks[5] = 23; will give error, as you have created array of 5
        
        // System.out.println(marks[3]);

        // -------------------------------
        // Re-assigning in array

        // marks[3] = 120;
        // System.out.println(marks[3]);


        // ---------------------------------
        // Creating array - Declaration and memory allocation but separately.


        // int [] values;
        // values = new int [3];

        // values[0] = 34;
        // values[1] = 54;
        // values[2] = 27;

        // System.out.println(values);

        // ---------------------------------------
        // Creating array - Declare + initialize

        // Elements are given while creating array and curly brackets{} are user.
        // The memory allocation is auto done by java.

        int [] nums = {12,23,67,34,65};
        System.out.println(nums[3]);

        


    }
}
