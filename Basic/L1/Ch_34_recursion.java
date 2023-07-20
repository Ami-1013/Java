public class Ch_34_recursion {

    static int factorial(int n){

        if (n==0 || n == 1){
            // This is called "base condition", which terminate the recursion.
            return 1;
        }

        else {
            return n * factorial(n-1);
        }

    }

    public static void main(String[] args) {
       
        int val = 5;
        System.out.println("The factorial of value is: "+ factorial(val));

    }
    
}
