public class Ch_32_method_overloading {

    // we use "void" when we don't want to return anything.
    // Program in java began to execute from "main" method.


    static void joke(){
        System.out.println("This is not a joke, its a joke.");
    }

    static void change_int(int a){

        a = 34;
    }

    static void change_array(int [] arry){

        arry[0] = 99;
    }


    // for method(function) overloading.

    static void foo(){
        System.out.println("This is good.");
    }

    static void foo(int a){
        System.out.println("This is " + a);
    }

    static void foo(int a, int b){
        System.out.println("This is " + a +" and " + b);
    }



    public static void main(String[] args) {
        
        // ----------------------------------------------------
        // joke();


        // case1 - changing the integer. -----------------------------

        // int x = 22;
        // change_int(x);
        // System.out.println(x);
        // // The int value does'nt change from 22 to 34. Because the copy of "x" is is send to f "change_int".



        // case2 - changing the array -------------------------------------

        // int [] marks = {23,56,78,45,87,34};

        // change_array(marks);

        // System.out.println(marks[0]);

        /* Here the value at index "0" have change.
           Its because the object "marks" store a reference or address where {23,56,78,45,87,34} array is.
           Hence when we pass it as a argument it refers to that space or memory where this array object it stored.
           ie parameter "arry" and "marks" will refer to same address.
           
           Unlike case1 where int value is copied, here reference is copied.

           Therefore the change is made to the original value.

           "This true for all kind of objects."
        
        */




        // Method (function) overloading ---------------------
        // when two or more method have same name but different parameter.

        foo();
        foo(10);
        foo(134, 67);

        // Method overloading can't be performed by changing the return type of methods.
        
        /* ie the function have same name and parameter but just merely changing its return type (like int to void) will not
         support method overloading.
         */







    }

    
}
