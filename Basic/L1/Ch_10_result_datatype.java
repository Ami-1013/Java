public class Ch_10_result_datatype {
    public static void main(String[] args) {
        
        // Increment and Decrement
        // ++v , v++, --v, v--, where value is variable or a value.
        // this operators also works with "char".


        int a = 5;
        System.out.println(a++);
        // If value or variable comes first then, first value is used then it is incremented.
        System.out.println(a);

        System.out.println(++a);
        // if operator come first then, first value is incremented then it is used.


        // Variable example

        // You can't assign a number with "increment" or "decrement" to a variable, ex
        // int y == ++ 3;
        int x = 8;
        int b = ++x ;

        System.out.println(b);



        // Example

        int y = 4;
        System.out.println(++y*4);
        System.out.println(y++*4);

        char j = 'a';
        System.out.println(++j);
        
        char i = 'a';
        System.out.println(i++);
        System.out.println(i);


    }
    
}
