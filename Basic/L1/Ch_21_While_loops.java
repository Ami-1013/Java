public class Ch_21_While_loops {

    public static void main(String[] args) {
        int i = 0;


        /*  Some general info of java
            
            In a function -
            Condition are give in () "bracket" and then statements are given in {} "curly brackets".
        
        */
        // "while loop" will execute until its condition is evaluated true. 
        while (i < 5) {
            System.out.println(i);
            
            ++i;
            // "++i" is adding one to value of i and modifying its original value.
        }

        // you can give a direct boolean condition to a while loop. like - while(true){}


        // a while loop to print 100 to 200

        int j = 100;
        while (j <= 200){

            System.out.println(j);
            ++j;    
        }

    }
    
}
