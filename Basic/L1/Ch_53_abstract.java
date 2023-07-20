/*  "abstract" methods is a method that is declared without implementation. Its kinda they set standard for their childs.
    In "abstract" methods you have if function have and set it parameters but you can use {}.

            abstract public return_type fun_name(); 
        

    - If a class include a "abstract" method that the class itself must be declared "abstract". But it can also contain
        "concrete" methods.
        Of course their children will inherit "concrete" methods and complete the "abstract" method ie they override the "abstract"
        method.
    
    - Aak gandi machali puri taalaab ko ganda kr de ti h. In a same way aak "abstract" method puri class ko abstract bna deta h.

    - You can't create objects from "abstract" classes because they are abstract. However you can create reference of it.

    - "abstract" classes set standards or abstract for their childrens. Their childrens can be "concrete" class or another 
        abstract class. As it set standards the methods for childrens is same but what and how it do is totally depend on childs
        ie same methods but different ways of implementations for childrens.
        
        "concrete" class mean no "abstract" methods. They have "concrete" methods.
        If a "concrete" class is a child of "abstract" class then they have to complete the "abstract" methods, otherwise it
        throw error. 

    - Child of the "abstract" class have implement its "abstract" methods, if not then the child itself has to become a 
        "abstract" class.
    
    - Every child of "abstract" class have to implement parent's abstract methods. ie every child can do implementation differently.
    
    
    
        

*/ 

// "abstract" class because it contain "abstract" method even though it also have "concrete" method (say()).
abstract class Parent2{
    public void say(){
        System.out.println("Hellow there.");
    }

    abstract public void greet();
    // a "abstract" method ie we have to declare whole class "abstract"

}

class Child2 extends Parent2{
    
    /* a concrete class implement it abstract parent's abstract method. It can also contain its parent methods and obviously can
        create method of it own.
    */
    public void greet(){
        System.out.println("Good morning.");
    }
    

}

abstract class Child3 extends Parent2{
/* We have use abstract in class because we have not implement parent's abstract methods. Obviously we can can more concrete 
    methods to it
*/
    public void yo(){
        System.out.println("Yo YO.");
    }


    abstract public void dsfk(int x);
}


public class Ch_53_abstract {
    public static void main(String[] args) {

        Child2 ch = new Child2();
        ch.say();
        ch.greet();
        

    }
    
}
