/*      Handling the specific exception.

- You can catch specific exception. By defining them in "catch".

- You can give multiple "catch" statement. 
    In multiple "catch" statements the order of execution is from top to bottom.

- You can use nested "try" to "catch" specific exception for a specific line of code.

*/ 



import java.util.Scanner;

public class Ch_81_specific_exception {
    public static void main(String[] args) {
        

        int [] arr = new int [3];

        arr[0] = 34;
        arr[1] = 66;
        arr[2] = 54;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the index of the array: ");
        int index = sc.nextInt();

        System.out.println("Enter the number to divide:");
        int num = sc.nextInt();

        try{
            System.out.println("The value at array index is: "+ arr[index]);
            System.out.println("The value after array-value/number is: "+ arr[index]/num);
        }

        catch(ArithmeticException e){
            System.out.println("The Arithmetic Exception has occurred");
            System.out.println(e);
        }

        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bound Exception has occurred.");
            System.out.println(e);
        }


        catch(Exception e){
            System.out.println("Some other exception has occurred.");
            System.out.println(e);
        }


    }
    
}
