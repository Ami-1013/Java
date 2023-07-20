import java.util.Scanner;

public class B3 {
    public static void main(String[] args){

        // 1 -- Creating program for adding 3 integer

        // int num1 = 23;
        // int num2 = 12;
        // int num3 = 53;

        // int tot = num1 + num2 + num3;

        // System.out.print("The sum is: ");
        // System.out.println(tot);


        // ------------------------

        // 2 -- Taking name and returning a string

        // Scanner sc = new Scanner(System.in);

        // System.out.print("Enter your name: ");
        // String name = sc.next();

        // System.out.println("Hello " + name + ", have a good day.");
        // // ****   Thats how you can use different data type same line


        //  -----------------------------------
        
        // 3 -- Converting km to miles

        // Scanner sc = new Scanner(System.in);

        // System.out.print("Enter in km: ");
        // double val_km = sc.nextFloat();

        // double in_miles = val_km * 0.621;

        // System.out.print(val_km);
        // System.out.print(" km in miles: ");
        // System.out.println(in_miles);

        //  -----------------------

        // 4 -- Detecting whether the input is int or not

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value: ");

        System.out.println(sc.hasNextInt());        

        sc.close();
        // you have to also close "Scanner" object.




    }
    
}
