public class Ch_23_for_loop {
    public static void main(String[] args) {
        
        // For loops - (initialize, check boolean expression, update)
        // "check boolean expression" in this parameter any expression can be given if its return a boolean. You can use
        // logical operator etc.
        
        // "check boolean expression" if it return false then the loop will stop. like while loop. 

        // check note and vid for to see in detail.


        // semi-colon is used between condition, not comma(,)
        // for (int i= 0; i <=10; i++){ 
        //     System.out.println(i);

        //     // This is like python for loop for range f.
        // }

        // problem - giving first odd number

        // int num = 5;
        // for (int j=0; j <=num; ++j){

        //     System.out.println(2*j + 1);
        // }

        //  -------------------------- 
        //  Decrementing for loop.

        // for (int i = 5; i > 0; --i) {
        //     System.out.println(i);
        // }


        // -----------------------------
        // giving first n natural number
            
        // for (int n = 10; n != 0 ; --n){
        //     System.out.println(n);
        // }


        // -------------------
        // leaving a gap between numbers of 3.
        // for (int a = 0; a < 10; ++a){

        //     System.out.println(a+a*2);
        // }

        /*  for leaving a gap of "g" from staring the with integer "n".
            

            Gap formula = n + n*(g-1), Where n is increased by 1 in iteration, if "a" is the range of loop then it will give
            "a" values.

            example given below
            */
        //  -----------------------
        
        // starting with 1 with gap of 4, giving 20 values

        int gap = 4;
        for (int i = 1; i <=20; ++i){
            System.out.println(i+ i*(gap-1) );
            // This will give 20 values starting with 1 with gap of 4

        }

    }
    
}
