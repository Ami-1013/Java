/*          Recursion
- A way of solving problems by having a function calling itself.
- It is dividing the big problem into smaller instances of same problem.
- Every time the function call itself the size of problem get smaller.
- Recursive calls work like stack, first in last out, last in first out. Its is stored in stack memory of computer.
  Use stack memory diagram and nested graph to see which function will be called.
- It is used in data structure like graph and trees and in algorithm - divide and conquer,greedy algo, dynamic programming.  

Properties
- Performing the same operation with different inputs.
- Base condition is needed to stop recursion, other wise infinite loop will occur.

Where to use
- When you can divide the problem into sub problem of same type.
- Problem related to nth terms.
- By practising recursion question.

Recursion problem can be solved by iteration and vice versa but it a matter of efficiency which one to choose.
Recursion is less time and space efficient to iteration as it have stack memory and the insert and pop in stack memory take time.
However it is easy to write and understand.

Use recursion when the original problem can be divided into sub problems having same solution logic/process.


- Recursion with 3 steps
    1- Recursive case - the flow
    2- Base case - stopping criterion (to stop the infinity loop)
    3- Unintentional case - the constrain (to stop the infinity loop for every possible value of n, where n is argument)

- When recursion is used for "traversal", it will have space complexity. As recursion uses stack memory
    to store element in the memory for later calling.

- Be sure to revise how to find time and space complexity of recursion.
*/ 




public class L2_recursion1 {

    public static void basic(int n){
        if (n<1){
            System.out.println(n);;
        }

        else{
            basic(n-1);
            // The below code will be execute at last. Due to stack memory LIFO.
            System.out.println(n);
        }

    }

    public static int factorial(int n){

        if (n<0){
            return -1;
        }

        if (n==0 || n==1){
            return 1;
        }

        return n * factorial(n-1);
    }

    public static int fibonacci(int n){
        
        if (n<0){
            return -1;
        }

        if (n==1 || n==2){
            return n-1;
        }

        return  fibonacci(n-1) + fibonacci(n-2);
    }

    // fibonacci by iteration methods
    public static int f(int a){

        if (a<0){
            return -1;
        }

        if (a ==1 || a==2){
            return a-1;
        }

        int num1 = 0, num2 = 1, prev1, prev2, hold = 0;

        prev1 = num2;
        prev2 = num1;

        for (int i=0; i < a-2; ++i){
            hold = prev1 + prev2;
            prev2 = prev1;
            prev1 = hold;
        }

        return hold;
        
        
        
        
    }

    public static void main(String[] args) {
        
        // basic(5);

        // System.out.println(factorial(-8)); 
        
        // System.out.println(fibonacci(8));

        System.out.println(f(9));

    }
    
}
