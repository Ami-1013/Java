import java.util.Scanner;

public class B2 {
    public static void main(String[] args){
        // Use "sout" for "System.out.println()"
        System.out.println("Take input from the user: ");
        
        // // "sc" is the object of 'Scanner' class
        // // "Scanner" class take a parameter which is 'resource', i.e from where to take input. 
        // // "System.in" mean the data provide through keyboard. So it work with "Scanner" class to take user input through keyboard.
        
        // // "new", this I currently don't know 
        Scanner sc = new Scanner(System.in);

        // System.out.println("Enter number 1:");
        
        // // Here we are creating a variable "num1" of "int" data type.
        // // "nextInt()" method of 'sc' helps to take only "int" data type.
        // int num1 = sc.nextInt();

        // System.out.println("Enter number 2: ");

        // int num2 = sc.nextInt();

        // int sum = num1 + num2 ;
        
        // System.out.println("Sum of this numbers is");
        // System.out.println(sum);



        // "sc.hasNextInt()" is a f which take input and return a boolean, it is used for validation.
        // boolean val = sc.hasNextInt();
        // System.out.println(val);

        // String str = sc.next();
        // System.out.println(str);
        // "sc.next()" take a "String" input. Just for reading only a character.
        // "sc.next" return the string but only first word. It won't read if it encounter a space.
        // Therefore if you provide it a sentence it will return first word.

        String strs = sc.nextLine();
        System.out.println(strs);
        // "sc.nextLine()" take a "String" input and return whole sentence.





        sc.close();
        // you have to also close the "Scanner" object after you are done with them, before the end of main f.
    }
    
}
