import java.util.Scanner;

public class Percentage_Calculator {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
    
        // Asking marks

        System.out.print("Enter marks of first Subject: ");
        float sub1 = sc.nextFloat();
        // maybe because of "nextByte()" the cursor is moved to new line below in console. 

        System.out.print("Enter marks of second Subject: ");
        float sub2 = sc.nextFloat();
        
        System.out.print("Enter marks of third Subject: ");
        float sub3 = sc.nextFloat();
        
        System.out.print("Enter marks of Fourth Subject: ");
        float sub4 = sc.nextFloat();

        System.out.print("Enter marks of fifth Subject: ");
        float sub5 = sc.nextFloat();
 
        float percentage = (sub1 + sub2 + sub3 + sub4 + sub5) / 5;

        System.out.print("Your percentage: ");
        System.out.println(percentage);
        
        // Harry is saying that operation btw integers will always give integer and changing the result data type won't solve
        // the problem.

        sc.close();
    }
}
