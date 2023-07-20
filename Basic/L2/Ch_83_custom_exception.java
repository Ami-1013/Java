/*     Custom Exception class

- Java already java exception class but still provide a way to make custom exception classes.
    It is because this exception are used when code is right but logically is wrong.
    
    ex - Say a variable int "age" hold the age of user. We can assign "-15" to it.
         Even though the code is right but logically is wrong as age of a person can't be in negative.
         That why we need custom exception to tackle logical errors.

- Abstract  
            class "class_name" extends Exception{}

- Custom exception will be used inside "try and catch" as they are exception.

- "throw" keyword is used to throw exception.

- we overwrite "Exception" class methods in custom exception class.
    You can learn "Exception" call methods from internet.


- "super.method()" this mean that trigger  that parent class method.    

*/ 

import java.util.Scanner;

class Excep1 extends Exception{

    @Override
    public String toString(){
        // Here I have override "toString" method of parent class, but super.toSting() will call parent class method. ie I have
        // included parent method in child overridden method.
        
        return  super.toString() + " I am toString().";
    }

    @Override
    public  String getMessage(){
        return super.getMessage() + " I am getMessage()";
    }


}


public class Ch_83_custom_exception {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");

        int num = sc.nextInt();

        if (num < 10){

            try{
                // This mean we have threw an object of "Except1" class.
                throw new Excep1();
            }

            // As we have throw "Except1" the "Exception" in catch method will have Except1 methods.
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println(e.toString());
                 
                // System.out.println(e);  --> will print e.toString() 
                
                e.getStackTrace();

            }
        }

        System.out.println("This code has finished.");
        sc.close();

    }
    
}
