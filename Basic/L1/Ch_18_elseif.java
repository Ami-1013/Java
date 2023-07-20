import java.util.Scanner;

public class Ch_18_elseif {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter you age: ");
        int age = sc.nextInt();
        sc.close();

        // if (age> 50){
        //     System.out.println("You are experienced.");
        // }
        // else if (age> 35){
        //     System.out.println("You are okay");
        // }
        // // "else if" are the condition between if and else. Its like "elif" in py.
        // else if (age>24){
        //     System.out.println("You are a amateur");
        // }
        // else {
        //     System.out.println("You are bad");
        // }

        // Using switch
        // switch is used when we have make a choice between a number of alternative option.
        // colon(:) is used with keyword "case", not semi-colon(;)
        
        // if a case is true then all other case below it get triggered along with in respective sequence. Including default

        // To trigger only matched case "break" is used with semi-colon(;)

        // The variable in switch() can be a int, char, string.
        switch(age){
            case 18:
            // Here "18" is the possible value of age.Same for other below
            System.out.println("You are going to become a Adult.");

            case 23:
            System.out.println("You are going to get a job");
            break;

            case 60:
            System.out.println("You are going to retire.");

            default:
            System.out.println("Enjoy your life");
            // If "age" is does'nt matches to anyone that this statement is triggered.
            
            // As "23" contain "break" and if "18" is triggered then due to break it will end in case '23'
            
            // Try using break in all or move break to another place to get the idea how it work.
        
        }
        // You can also learn about "enhance switch".
        
    }
    
}
