/*  Interface in english is a point where two system met and interact. like button is a interface between a person and T.V 

- In java "interface" is a group of related methods with a empty bodies.
    They are called "INTERFACE". They are like similar to class, but they are not called class or "interface class".

- "Interface" class objects can't be created but reference can be done. (same as abstract class or dynamic dispatch)

- In "interface" all methods are "abstract" and concrete attributes can be created.

- Inheritance for "interface", "implements" keyword is used instead of "extends".

- Unlike "abstract class" or "class", "interface" support multiple inheritance. ie a class can inherit multiple
    "interface" at once and also it "extends" one "class".

- To create a interface, "interface" keyword is used instead of "class".
        like -           
                interface _name_{
                    -void methods();
                }
        same as class bracket are not used.

- Obviously child of "interface" has implement all parent interface methods.

- "Interface" properties(methods & attributes) are by default "public". So you don't have to write it explicitly.

- When you are implementing "interface" method then you have to give them "public" access modifier(presently I don't know the
    logic and it something related to "default" access modifier). 
            
- You can't modify the the attributes of interface through the object of child as they are "final".
    However the "attributes"  of "interface" can be modified(Override) in child's class only, not through the object of child.

*/ 

// creating interface
interface Bicycle{

    // creating concrete attribute
    int val = 34;
    int x = 10;

    // Interface properties are by default "public".
    void apply_break(int decrement);

    void speed_up();
}

// creating another "interface" for multiple inheritance.

interface Part{

    void wheel(int tires);
    void chain();
}



// implementing  the multiple "interface"

class Avon_cycle implements Bicycle, Part{

    int x = 11;
    // You can modify(Override) "interface" attribute in child class only, not through the child's object.

    void blow_horn(){
        System.out.println("pee Pee.");
    }


    // implementing abstract methods from interfaces
    // without "public" the abstract methods will give error in case of interface.
    public void apply_break(int decrement){
        System.out.println("Break has been applied by: " + decrement);
    }

    public void speed_up(){
        System.out.println("Speed has increased.");
    }


    public void wheel(int tires){
        System.out.println("It got " +  tires + " wheels");
    }

    public void chain(){
        System.out.println("It has a shining steel chain.");
    }


}


public class Ch_54_interface {
    public static void main(String[] args) {
        

        Avon_cycle cy = new Avon_cycle();
        cy.apply_break(4);

        System.out.println(cy.val);

        // cy.val = 44; -- You can't modify the properties of interface as this is "final".

        // using "Part" class methods(checking multiple inheritance)
        cy.wheel(4);

        System.out.println(cy.x);
        // Over ridded interface attr.



    }
    
}
