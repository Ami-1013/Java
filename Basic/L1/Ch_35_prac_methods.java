public class Ch_35_prac_methods {
    

    // p1
    static void table(int n){

        for (int i =1; i <=10; ++i){
            System.out.println(n+ " X " + i + " = " +i*n);

        }
    }

    // p2
    static void patter1(int n){

        for (int i=0; i < n; ++i ){

            for (int j = 0; j < i+1; ++j){
                System.out.print("* ");
            }
            System.out.println();

        }
    }

    // p3

    static int natural_sum(int a){

        if (a==1){
            // This is base condition of recursion, that terminate the recursion.
            return 1;
        }
        return a + natural_sum(a-1);
    }

    // p4

    static void patter2(int a){

        for (int i=a; i >0; --i){
            for (int j = 0; j < i; ++j){
                System.out.print("* ");   
            }
            System.out.println();
        }
    }

    // p5

    static int fib(int n){
        /*  if (n==1){
            return 0;
        }
            else if (n==2){
                return 1;
            }
        Above expression can be wrote as.    
        */ 
        if (n==1 || n==2){
            return n-1;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
    }

    // p6

    static float average(float ...arry){
        
        float sum = 0;
        for (float element: arry){
            sum += element;
        }

        float avg = (float) sum/arry.length;

        return avg;
    }


    // p7

    static void patter1_rec(int x){
        
        // this is "if" is the base condition, if its not satisfied then recursion is not triggered.
        if (x > 0){
            patter1_rec(x-1);

            for (int i=0; i < x; ++i){
                System.out.print("* ");
            }
            System.out.println();
        }
    }




    public static void main(String[] args) {
        
        // P1 - creating a multiple table of n -----------------------------

        // table(5);


        // P2- creating a * patter -----------------------------

        // patter1(5);


        // P3- recursive f to sum first n natural numbers---------------------

        // System.out.println(natural_sum(6));


        // P4- creating a * patter-------------------------------------
        
        // patter2(5);


        // P5- giving fibonacci series nth number----------------------------------
        
        // System.out.println(fib(7));


        // P6- finding averages of given arguments.--------------------------

        // System.out.println("The average: " + average(1,2,3,4,5,6));


        // P7- using recursion for patter1 f-----------------------

        patter1_rec(5);








    }
}
