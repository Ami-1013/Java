
/*     Constructor in Inheritance.

    - If parent class has constructor then the constructor is also inherited by child class.
    - If parent and child class both have constructor then first the parent class constructor is initialized then child's.

    - In total in "child" class first parent class component are initialized.
*/


class Base1{
    
    public Base1(){
        System.out.println("This is constructor of 'Base' class.");
    }
    
    public Base1(int x){
        System.out.println("This is a overloaded constructor of 'base' class of 'x' value: " + x);
    }

    int b = 10;

}

class Derived1 extends Base1{

    public Derived1(){
        // super(23);

        System.out.println("This is the constructor of 'Derived' class.");
    }

    public Derived1(int x, int y ){
        super(x);
        System.out.println("This is overload constructor of 'Derived1' with 'y' value: " + y);
        // This is how you can use child's constructor to give argument to parent's constructor also.
    }


    int d = 20;
}

class Child_of_derived extends Derived1{
    Child_of_derived(){
        System.out.println("I am Child of derived.");
    }

    Child_of_derived(int x, int y, int z){
        super(x, y);
        System.out.println("This is overload constructor of 'Child of derived' with value of z :" + z);
        // Here (x, y) goes to derived1. From there x goes to base1.
        // Therefore we have gave argument to child(Child_of_derived), parent(derived1) and grandparent(base1).

    }


}


public class Ch_46_constructor_in_inheritance {
    public static void main(String[] args){

        // checking constructor of "base1"
        // Base1 base = new Base1();



        // ----------------
        
        // checking constructor(inherited and own) of "derived1"
        /* 
        Derived1 derived = new Derived1();
        // Its shows both constructor (of derived1 and base1) but first it shows the inherited constructor ie base1.
        */



        // Overloaded constructor in base/parent class------------------------------
        
        /* by default "child" will used that constructor of parent that take no argument. 
           "super" keyword is used in such cases when you want to use a parent constructor with argument.
           
           "super" is used inside child's constructor and the argument that is given to it goes to appropriate constructor of parent with
            reference to the datatype and number of argument.  
        */

        // Derived1 derived = new Derived1(10, 55);
        // here "10" goes to parent's constructor.



        // Child_of_derived - child of derived1 class

        // Child_of_derived cd = new Child_of_derived();

        Child_of_derived cd = new Child_of_derived(10, 20, 30);
        
       
        



    }

}
