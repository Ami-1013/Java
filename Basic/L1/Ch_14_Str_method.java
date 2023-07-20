
public class Ch_14_Str_method {
    public static void main(String[] args) {
        
        // String Methods
        
        // String are immutable. Therefore method will give a new string rather then changing the original one.
        // Hence to use returned value you have to assign that value to a variable.

        String name = "Amish";

        int length = name.length();
        // give length of string.
        System.out.println(length);

        System.out.println(name.toUpperCase());
        // return a string in upper case.

        System.out.println(name.toLowerCase());
        // return a string in lower case.


        String sen = "    Amish      is doing coding in        java     ";
        System.out.println(sen.trim());
        // Remove all the spaces in the beginning and at the end but not in between them.

        System.out.println(name.substring(1,3));
        // take two argument beginIndex and endIndex, return a string from beginIndex to endIndex. Where beginIndex is included
        // and endIndex is excluded.  If endIndex is not given then by default it give till end of string.
        
        

        // There are two "replace" method of class String, one take char and another string 

        System.out.println(name.replace('m','r'));
        // It take char as an argument ,it replaces the char, but if targeted char is more than 1 in string then all that char
        // will be replaced.

        System.out.println(name.replace("mis", "tb"));
        // Take string, replace it. It changes that string every where where it is found.
 

        System.out.println(name.startsWith("Ami"));
        // return a boolean, if string starts with given argument then return true, else false. Obviously its case sensitive.

        System.out.println(name.endsWith("sh"));
        // works same as "startsWith" method but it check end instead of start.


        System.out.println(name.charAt(3));
        // return the char at given index.


        System.out.println(name.indexOf("is"));
        // return the index of given string which match first, if a String is given then it will return the index from 
        // where that string began.

        String name1 = "Amishis ";

        System.out.println(name1.indexOf("is", 3));
        // Its a different method, it start looking  for string from the given index. Hence it ignore the value before the
        // given index.


        // Most of the methods return "-1" if it did'nt find the targeted value. Ex -
        System.out.println(name.indexOf('x'));


        System.out.println(name1.lastIndexOf("is", 7));
        // same as "indexOf" method but it return last index of that string instead of first.
        // "fromIndex" method create a substring and return the value if founded between 0 to that index
        // you will see that above code return "5" instead of "6" because you have gave a string "is" so it return the index from
        // where it began.


        System.out.println(name.equals("Amish"));
        // return true if the string matches otherwise false. Its case sensitive.
        // Harry said not to use "=" for comparing string value. I guess i'll found out in next videos.

        System.out.println(name.equalsIgnoreCase("AmIsh"));
        // works same as "equals" methods but its not case sensitive.
        

        // Escaping sequence
        // It start with the "\" and then a char
        // It is used for string so they are alway used inside of double quotes "".

        // Quote escaping
        System.out.println("You\" will do it.");
        // "\'" for single quote and "\"" for double quote.

        System.out.println("This is \\ a backslash");
        // To use backslash as string you have to use backslash with a backslash to escape it. "\" is keyword (maybe.)
        
        
        // "\n" for a new line.
        // "\t" for tab. It give space same as tab.
        // 


    }
    
}
