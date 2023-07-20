/*          Exception catching

- "try" and "catch" are used to catch exception.

- The "Exception" keyword in the "catch" method is a class and the variable next to it (usually "e") is a object of it.

*/ 




public class Ch_80_try_catch {
    public static void main(String[] args) {
        
        int a = 30;
        int b = 0;

        try{

            int c = a/b;
            System.out.println("The value of c: "+ c);
        }

        // "Exception" is a class and variable "e" is the object of it.
        catch(Exception e){
            System.out.println("The reason of error is:");
            System.out.println(e);
        }
        



    }
    
}
