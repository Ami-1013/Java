public class Ch_33_varargs {

    /* "varargs" store all given input in array.
        Syntax - ...variable_name (3 dots and then variable name)
        
        Its like "*args" in python that store data in a list.
        Same logic and usage but different syntax.
        
        */

    static int sum(int ...arry){

        int result = 0;
        for (int element: arry){
            result += element;

        }
        /* If you want that the "sum" f at least is 1 argument.

            static int sum (int x , ...arr){
                int result = x
                for (int element: arr){
                    result += element
                }
                return result;
            }

            - here you have stated that parameter int x must be full filled even though array can be empty.
              hence making sure that "int x" argument is given 

        */

        return result;
    }


    public static void main(String[] args) {
        
        System.out.println("Sum of 1,2,3 and 4 is: "+ sum(1,2,3,4));
        System.out.println("Sum of 5,6 and 7 is: " + sum(5,6,7));
        // The code run fine even if array is empty.


    }
    
}
