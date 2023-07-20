// "package" is used to group related classes.

// The class name should be same as name of .java file?

// Java is a Purely OOP language. 
// As you can see you write code in class and each class you make get saved in your working directory by extension ".class"

// the file will show error, if you use "ctrl + alt + N" of "code runner" 
// so you have to manually click "Run Java" under a "Run & debug" button beside "Run" button.
// Its is the fault of "code runner" extension, not yours.

// You can also run java code through "Java Extension pack", by "ctrl + F5", it will run selected class, not whole app

// To run java program you need to give file name with extension. But to run a certain class you need to give only "class" name
// in terminal.



class Subscribe {
    // "public static void main" is a f 
   
    // "static" it helps to run class without creating any objects , it also helps f to dis associated with object 
    // and works as independent f and at the same including in it in a class. 
   
    // "void" mean that f expect what type of value in return. as its void it mean it expect nothing.
    
    // "main" is the default f and always a starting point in java.
   
    // "public" is a access modifier   
    public static void main (String[] args){
        System.out.println("Hellow world");
    }
}

// In java we complete a f with ; (semi colon).

// Naming convention
// 1- For classes we use PascalConvention. ex - Amish, MyNameAmish
// 2- For functions we use camelCaseConvention.ex- amish, myNameAmish




class Name {
    public static void main (String[] args){
        System.out.println("My name is Amish.");
    }
}
// To run above class "java Name" in powershell


// ----------creating a sum program

class Sum{
    public static void main (String[] args){
        System.out.print("The Sum is: ");
        // The "print" f take only the space in console which it require. Hence making next output start from the same line.
        // whereas "println" take whole horizontal space and without respect to it's output size. Hence making next output
        // start from the next line. 
        
        
        int num1 = 5;
        // thats how you create a variable.
        int num2 = 6;
        int num3 = 7;
        int sum = num1 + num2 + num3;
        System.out.println(sum);

    }
}


// ----------------Literals

class Lit{
    public static void main (String[] args){
        
        byte age = 5;
        short age1 = 436;
        int age2 = 23;

        // but for "long" we have you use "L" at the end. Default "integer" value is int.
        long age3 = 25443354356465L;

        char name = 'a';        
        // "char" are used in ''(single quote)
        String name1 = "Amish";
        // for "String" it start with capital "S" and with ""(double quote)
        // In java "char" and "string" are different and use of '' and "" are also different and they represent different value. 
        
        float point1 = 3.6f;
        double point2 = 5.756D; 
        // for "float" and "double" we have to use "f" and "D" at the end.
        // "Float" data type by default are "double" type.

        boolean value = true;
        // "boolean" values are wrote in lower case in java.


        // ** The constant value that is assign to a variable is called literal. i.e the value above. **


        System.out.println(age + age1 + age2 + age3 + name+ name1 + point1 + point2 + value);
    }
}


// Can't we create two static void f in same class?
// We can't print different data type in same println()?
// the main class have to be name same as the java file name?