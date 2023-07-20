

public class L2_recursion2_ques {

    // P1 - Creating recursion for sum of digits of a number.
    public static int digit_sum(int n){

        if (n == 0 || n <0){     // Here base condition is n==0 and unintentional case is n<0.
            return 0;
        }

        return n % 10 + digit_sum(n/10);
    }

    // P2- Calculating power of number using recursion.
    public static double power(int base, int exponent){

        if (exponent < 0){
            return -1;
        }

        if (exponent == 0){
            return 1;
        }

        if (exponent == 1){
            return base;
        }
        return base * power(base, exponent-1);
    }

    // P3- Calculating Greatest positive common divisor of two number (GCD) or HCF
    public static int gcd(int a, int b){

        if (a<0 || b<0){
            return -1;
        }

        if (a == 0){   // This both base and flow.
            return b;
        }

        return gcd(b % a, a);
        
    }

    // P4- Converting Decimal to binary
    public static int binary(int a){

        int old = -1;
        if (a/2 != 0){
            old = binary(a/2);  // most depth recursion will also be stored here.
        }

        if (a/2 == 0){
            return 1;
        }

        return (a%2) + old*10 ; // Multiply by 10 logic is used.

        /*  // Efficient solution
        if (n==0){
            return 1;
        }
        return a%2 + 10*binary(a/2);

        */ 

        
    } 

    public static void main(String[] args) {
        

        // P1 ------------
        // System.out.println(digit_sum(22331));
   

        // P2 ------------
        // System.out.println(power(2,3));

        // P3 ------------
        // System.out.println(gcd(30,75));

        // P4 ------------
        System.out.println(binary(13));
        
    }
}
