
public class Ch_8_Operators4 {
    public static void main(String[] args){

        // Modulo operator, give the remainder.
        // It also works with floats and double and give remainder in decimal.
        int a = 9 % 5;
        System.out.println(a);

        System.out.println(4.6 % 2.1);

        // +=, -+, *= , /=   Assignment Operators and = is also come in it.

        int b = 5;
        b += 3;
        // While modifying its value you don't write its data type.
        System.out.println(b);

        int c = 4;
        c *= 3;
        System.out.println(c);



        // <, > ,<=, >=  Comparison Operator, as like python it return a boolean depending on the statement.
        // while using greater than or small than the "=" comes after ">" or "<", if putted at first then it give error. This same
        // logic is also applied in python.

        // System.out.println(6 < 4);
        // System.out.println(45 >= 4);
        


        // &&, ||   Logical Operator

        // System.out.println(45>34 && 34< 12);
        // "&&" works same as the "and" f in python


        // System.out.println(2>12 || 12 < 18);
        // "||" works same as "or" f in python.



        // &, |    Bitwise operator
        // Bitwise operator operate in bits, i.e it break the numbers into bit and follow the given condition and solve in
        // bits and then return a number of the resulted bits.

        System.out.println(2 & 3);
        // first it break 2 and 3 in bits, 2 is "10" and 3 is "11" in bits.
        // Then it solve by the given condition, i.e "&"
        
        //   2 ->  1  0                       in binary 1 is true and 0 is false
        //   3 ->  1  1
        //      + ------

        //       true false
        //         1   0
        
        // as 1 + 1 = true + true so, its true and 1 + 0 = true + false, so false 
        // its like + - = -, - + = - , ++ = + , -- = +

        // so it give at the end "10" in binary and then convert it back to Number which is 2.




    }
    
}
