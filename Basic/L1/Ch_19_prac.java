import java.util.Scanner;

public class Ch_19_prac{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // // P1 ------------------- calculating percentage of 3 subject and total % > 40 and score > 30

        // byte s1, s2, s3;
        // // You can assign variables data type by this expression, kinda like py.


        // System.out.print("Marks in first subject: ");
        // s1 = sc.nextByte();

        // System.out.print("Marks in second subject; ");
        // s2 = sc.nextByte();

        // System.out.print("Marks in third subject: ");
        // s3 = sc.nextByte();

        
        // float avg = (s1 + s2 + s3)/ 3f;
        
        // System.out.println("Your percentage is: " + avg);
        
        // if (avg > 40 && s1 > 30 && s2 > 30 && s3 > 30){
            
        //     System.out.println("You passed");
        // }
        
        // else{
        //     System.out.println("You failed.");
        // }
        
        // P2 -------------------------------
        // Income tax 
        
        // System.out.print("Enter you annual income in lakhs: ");
        // float tax = 0;
        
        // // py "input"f  is combo of "print" and "scanner" of java.

        // float income = sc.nextFloat();
            
        // if (income <= 2.5f){
        //     System.out.println("No tax for you");
        // }

        // // You can use to "comparison" operator together like py. ex - 3  < val  < 23
        // // In java you have to use "logical" operator for comparing more than 1 values.

        // else if (2f < income && 5f >= income) {
        //     tax = tax + 0.05f*(income - 2.5f);

        // }
        // else if (5f < income && income <= 10f){
        //     tax = tax + 0.05f *(5f - 2.5f);
        //     tax = tax + 0.2f *(income - 2.5f);

        // }

        // else {
        //     tax = tax + 0.05f *(5f - 2.5f);
        //     tax = tax + 0.2f *(10f - 5f);
        //     tax = tax + 0.3f *(income - 10f);
        // }

        // System.out.println("Total tax payed: " + tax + " lakhs.");

        // /*
        //     1 Lk = 100 Th
        //     1 Th = 1,000 rs

        //     1 Lk = 1,00,000 rs

        //     Unit is crucial for calculation and understanding of concept.
        //  */

        
        // P3 ------------------- Week with num 
        
        System.out.print("Enter number: ");

        byte num = sc.nextByte();

        if (num == 1){
            System.out.println("This is Monday.");
        }

        else if (num == 2){
            System.out.println("This is Tuesday.");
        }

        else if (num == 3){
            System.out.println("This is Wednesday.");
        }

        else if (num == 4){
                System.out.println("This is Thursday.");
        }

        else if( num == 5){
            System.out.println("This is Friday.");
        }
        else if (num == 6){
            System.out.println("This is Saturday.");
        }

        else if (num == 7){
            System.out.println("This is Sunday.");
        }

        else{
            System.out.println("You have typed invalid number.");
        }


        sc.close();
    }
}