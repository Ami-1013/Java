
public class Ch_25_prac {

    public static void main(String[] args) {
        
        // P1- Stars problem

        // for (int i = 5; i != 0; --i){
            
            
        //     for (int j=i; j!=0; --j){

        //         System.out.print("*");
        //     }

        //     System.out.print("\n");

        // }

//---------------------------------- 
        // P2 - sum of first n even number using while loop

        // int a = 5;
        // int sum = 0;

        // while(a > 0){

        //     sum = sum + a*2;
        //     --a;
        // }
        // System.out.println(sum);


        // P3- multiplication table
        
        // int num = 4;

        // for (int i=1; i <11; ++i){

        //     System.out.println(4*i);
        // }

// --------------------------------------------
        // P4 - multiplication of 10 in reverse order.


        // for (int a=10; a>0; --a){

        //     System.out.printf("%d X %d = %d \n",10, a, a*10 );
        // }


// --------------------------------
        // P4 - Factorial 
        
        // int num = 5;

        // int fact = 1;
        // for (int a = num; a > 0; --a){

        //     fact *=a;
        // }
        
        // System.out.println(fact);


//------------------------------
        // P5- sum of table of 8 

        int sum = 0;

        for (int a=1; a<11; ++a){

        sum += a*8;
        }
        System.out.println(sum);



    }
    
}
