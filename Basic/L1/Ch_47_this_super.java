/*  "this" keyword is a reference to the class attributes and components.
    Its like "self" in python.

*/ 

class Ek_class{
    int a;

    public Ek_class(int x){
        this.a = x;
    }

    public void set_a(int a){
        this.a = a;
        // "this.a" refers to the class attribute "a", where as "a" after = is the argument of methods.
        // "a = a" (without this.) will give error.
    }
}



public class Ch_47_this_super {
    public static void main(String[] args) {
        Ek_class ek = new Ek_class(33);
        ek.set_a(45);
        System.out.println(ek.a);
    }
}
