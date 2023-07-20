/*          "throw" and "throws"

- "throws" is used to indicate that the function or program might throw exception. So it tell programmer to be ready in advance.
  As due to possibility of exception(by using "throws"), that program or function must be used in "try and catch" block.

- In "throws" you threw a "exception" class to function or methods. where as in "throw" you threw a object of "exception" class.

- If you are using custom exception in "main" method then you have pass "throws exception_name" in "main" method.

- "throws" works with function and methods, not with class.
  
- "throw" throw exception whereas "throws" tell that there might be a exception.  

*/ 

class Excep2 extends Exception{
    
    @Override
    public String toString(){
        return super.toString() + "This is a toString";
    }

    @Override
    public String getMessage(){
        return super.getMessage()+ "this is a message";
    }
}


public class Ch_84_throw_throws {

    // "throws", there might be a ArithmeticException, ie divided by 0. This in advance aware the programer. This will be used
    // in "try and catch"
    // You can also set custom exception in "throws" like replace ArithmeticException with "Excep2" exception.
    public static int divide (int a, int b) throws ArithmeticException{
        int result = a/b;
        return result;
    }

    public static void main(String[] args) {
        

        try{
        int c = divide(50,0);
        System.out.println(c);
        }

        // This will be ArithmeticException because we have already define it in "divide" function.
        catch (Exception e){
            System.out.println(e);
        }


    }
    
}
