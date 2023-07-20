public class Ch_13_String {

    public static void main(String[] args) {
        String name = new String("Amish is dude.");
        // String is a class in java, but due to special support it can be used as a "primitive data" type.
        // So String object are created in runtime or compile time?

        System.out.println(name);

        String nam = "Keep going";
        // This is also works fine because of special support provided by java.

        System.out.println(nam);

        // String are immutable and cannot be changed. Hence they are not removed from the memory.

        int a = 12;
        float b = 1.3f;

        System.out.printf("The value is %9d and %.3f", a, b);
        // "%d" is for int , "%f" for float, "%c" for char, "%S" for String.
        // System.out.format() works same as printf.
        
        // The 9 before d mean how many spaces to give including the variable value and .3 before f mean that how much value to
        // to show after decimal, by default it show 6 value after decimal.

        // However "printf" or "format" does'nt move the cursor to the below in console like "println()".

        int y = 34;
        System.out.printf("            this work %d and %d", y, a);


    }
    
}
