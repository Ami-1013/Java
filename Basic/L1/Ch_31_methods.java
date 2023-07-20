public class Ch_31_methods {
    
    /* 
      ---------------------------------------------------------------
    // Using made "fun" method in main class.
    // You can call only "static" methods in main class. As it is dis associated to objects.
    // If you did'nt use "static" in a method then it can only  be called by object of that class as it is associated to objects.
    // "static" method can only call "static" method.

    // "static" for creating a function and "non static" for creating a method of class.
    // Hence "static" f can can be used in both class's object and class's fun. Like function is used in object and other function 
    // in python.

    // Don't get confused over a function and method in java. As it sound almost same but they are not.


    static int fun(int x, int y){

        int z;

        if (x > y){
            z = x + y;
        }
        else{
            z= (x + y)*5;
        }

        return z;
    }


    public static void main(String[] args){

        int a = 1;
        int b = 2;
        int c = fun(a, b);


        int a1 = 3;
        int b1 =2;

        int c1 = fun(a1, b1);



        System.out.println(c);
        System.out.println(c1);


    }

    */




    // Making method without "static" and then creating a object to use in "main" class


    
    int fun(int x, int y){

        int z;

        if (x > y){
            z = x + y;
        }
        else{
            z= (x + y)*5;
        }

        return z;
    }


    public static void main(String[] args) {
        
        int a = 1;
        int b = 2;

        // Creating a object so that we can use "fun" method.
        Ch_31_methods obj1 = new Ch_31_methods();
        // the process of creating object is same.

        int c = obj1.fun(a, b);

        int a1 = 5;
        int b1 = 3;

        int c1 = obj1.fun(a1, b1);

        System.out.println(c);
        System.out.println(c1);

    }







}
