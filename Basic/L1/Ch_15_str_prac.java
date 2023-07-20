public class Ch_15_str_prac {
    public static void main(String[] args){

        // // Problem 1- Changing to upper case
        // String name = "Amish Kanyal";
        // name = name.toUpperCase();
        // System.out.println(name);

        // // Problem 2- Replacing spaces to underscore.

        // String text = "This is Amish";
        // System.out.println(text.replace("", "_"));
        // text = text.replace(" ","_");
        // // both give different result
        // System.out.println(text);


        // // Problem 3- Replacing a word from a string.

        // String letter = "Dear <|name|>, thanks a lot.";
        // // "name" contain symbol because we want to target a particular word at a particular space. So that if there are more than
        // // one "name", the other are undisturbed. Hence making the target unique.

        // letter = letter.replace("<|name|>", "Amish");
        // System.out.println(letter);


        // // Problem 4- Detecting double and triple spaces.
        
        // String sen = "This is a  demo of   java and   I am  learning.";

        // System.out.println(sen.indexOf("  "));
        // System.out.println(sen.indexOf("   "));


        String letter = "Dear Harry,\n\tThis java course is nice.\n\tThanks";
        System.out.println(letter);
    }
}
