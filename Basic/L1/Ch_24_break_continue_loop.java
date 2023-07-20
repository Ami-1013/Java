public class Ch_24_break_continue_loop{

    public static void main(String[] args) {
        
        // ***  Break is used to exit loop irrespective to its boolean condition.

        // for (int i=0; i<10; ++i){

        //     System.out.println(i);
        //     if (i==3){
        //         System.out.println("Loop is ending.");
        //         break;
        //     }

        // }

        // ------------------------- break for do-while loop

        // int a =0;

        // do{
        //     System.out.println(a);
        //     if (a==5){
        //         break;
        //     }
        //     ++a;
        // }   while(a<10);
            // In do-while loop, while loop is out side of "do" f



        /*  *** "continue" keyword

            - when "continue" is used, java ignore the code which comes after "continue" inside loop, without respect
              to its scope and move to next iterable
            
              So basically it skip a part of code.
              
              It can be applied to all loops. But remember you have to write "++i" before "continue" as if it comes after
              continue then the java will not read it and hence loop will stop.
          
        */


        for(int x=0; x<5; ++x){
            System.out.println(x);
            if (x==3){
                continue;

            }

            System.out.println("This has printed");
        }


    }
}