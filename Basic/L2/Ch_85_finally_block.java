/*              Finally block

- It is used with "try and catch".

- "finally" keyword. Make a code to execute no matter what. Its a part of "try and catch" but execution is  independent of it. 
    Even if a function is has reached a "return" line but still finally will be execute. Same for loops etc.

- Even if exception occur, final block would be executed.

- Only "try and finally" can also be used. As there is no "catch" the exception handling would not be done but code will execute. 

*/ 

public class Ch_85_finally_block {
    
    public static int fun(){
        
        try{
        int a = 10;
        int b = 2;

        int c = a/b;
        return c;
        }

        catch(Exception e){
            System.out.println(e);
        }

        finally {
            System.out.println("This final block.");
        }

        return -1;
        // There are two "return" because 1st one is in "try" block we don't know that it will execute.
        // Even though the code is valid and return c but still final block will be executed.

    }
    
    
    public static void main(String[] args) {
        
        int val = fun();
        System.out.println(val);
        // final block is execute even though the return occurred before it.

        for (int i =0; i <5; ++i){

            System.out.println(i + " No");

            try{
                if ( i == 4){
                    break;
                }
            }

            catch(Exception e){
                System.out.println(e);
            }

            finally {
                System.out.println("The final statement after the break.");
            }
            // finally block will be execute every time and will be execute even after the exception.

        }

    }
    
}
