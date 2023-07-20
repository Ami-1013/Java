/*
Constructor - The variable declared in constructor will be destroyed when
   the constructor is over.
   
   That why you can't access those variable which was only created in 
   constructor.
   But you can use constructor to give values to "pre define" variable in 
   class when initializing the object of class.

- return type is not included in constructor.


*/ 


class My_employee3{

    private int id;
    private  String name;

    public void set_name(int x){
        id = x;
    }
    public void set_name(String n){
        name = n;
    }

    public String get_name(){
        return name;
    }

    public int get_id(){
        return id;
    }

    /* creating a constructor.
       Constructor name should be same as the class. It contain both parenthesis and curly brackets.
       
       while creating its look like a function or methods but its not. As no "static" or return data type is expected.
    */

    My_employee3(){
        id = 12;
        name = "Default_name";
        // The object will construct this values automatically. Or you can say this is its default values.
    }


    // Creating a constructor but setting parameters, not default values.

    My_employee3(int x, String n){

        id = x;
        name = n;
        // Here argument must be given while creating object to set values.
        }

    }   

    // You can use constructor for default values or "must give" values for an object  simultaneously.




public class Ch_42_constructor {

    public static void main(String[] args) {

        // My_employee3 em1 = new My_employee3(11, "Amish");
        // // if you have set default value then no problem, for "must give" argument the object expect the argument.

        // System.out.println(em1.get_name());




        /* Constructor overload -------------------
           You can overload constructor same as function or methods. 
        
            like -
           */

           My_employee3 em2 = new My_employee3();

           System.out.println(em2.get_name());
           System.out.println(em2.get_id());


           My_employee3 em3 = new My_employee3(33, "Dennis");

           System.out.println(em3.get_name());
           System.out.println(em3.get_id());

        

        

        
    }
    
}
