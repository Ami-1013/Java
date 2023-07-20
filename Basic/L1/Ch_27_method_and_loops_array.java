public class Ch_27_method_and_loops_array {

    public static void main(String[] args) {
        
        String [] names = {"Amish", "Walt", "Jesse", "Eren"};

        // System.out.println(names.length);
        // ".length" give length of a array.


        // --------------------------
        // Displaying array with the help of for loop and the process is called "array traversal"


        // for (int i=0; i < names.length; ++i){ 

        //     System.out.println(names[i]);
        // }


        // ---------------------------  Printing array in reverse order

        // for (int i = names.length - 1; i >= 0 ; --i){

        //     System.out.println(names[i]);
        // }


        // ------------------------- for-each loop in array

        for (String i : names){
            System.out.println(i);
        }
        // works same as for loop but give only elements of array where as in for loop element and index are both given.
        // Its is convenient if you need only elements of array.

        // Here is colon is used.




    }
    
}
