public class Ch_9_prece_asso{
    public static void main(String[] args){
        // Precedence & Associativity

        int a = 6*5 - 32/2;
        /*
        Thats how you comment multiple lines.

        = 30 - 32/2
        = 30 - 16
        = 14
        
        */ 

        int b = 6/2 - 2*3;

        /*
        = 3 - 2*3
        = 3 - 6
        = -3
        */ 


        System.out.println(a);
        System.out.println(b);

        /*  
        First it follow Precedence, if both have equal precedence the follow Associativity. Like what you have learn in SAT.
        But there are more than Arithmetic operators so use "image" in note to see all "operator" precedence value and
        associative direction. 
        */
        


    }

}