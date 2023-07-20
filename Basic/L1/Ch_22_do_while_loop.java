public class Ch_22_do_while_loop {

    public static void main(String[] args){

        /*
            - "do while" loop is same as while loop expect that it is guaranteed to execute at least once.
           
            - "do" f start with {}, not()

            - Where in while loop first condition is checked and then code is executed where as in do-while loop first
              code is execute then condition is checked.
            - Here "while" keyword is accompanied be a semicolon(;)

            - In "do-while" the code is first executed and then condition is checked. See ex-1
         */


        // int a = 0;

        // do{
        //     System.out.println(a);
        //     a++;
        // } while(a < 5);


        // int b = 10;
        
        // do{
        //     System.out.println(b);
        //     b++;
        // } while(b < 5);


        // System.out.println(b);
        // // Value "b" is increased by 1 as do while loop first execute the code.



        // --------------------------------------
        // Ex - 1

        int j = 0;


        do{
            ++j;
            System.out.println(j);

        } while(j<5);
        // in output it give 1,2,3,4,5 . Yes it include give as code is executed first then condition is checked.
        // so in a way its reverse of while loop with respect to condition and statement.



    }
    
}   
