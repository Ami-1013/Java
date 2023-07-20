
// p1 ------
abstract class Pen{
    abstract void write();
    abstract void refill();
}

class Fountain_pain extends Pen{
    
    public void write(){
        System.out.println("Writing...");
    }

    public void refill(){
        System.out.println("Refilling...");
    }

    public void change_nib(){
        System.out.println("Nib has changed.");
    }
}

// p3 ---

class Monkey{
    public void jump(){
        System.out.println("Monkey is jumping.");
    }
    public void bite(){
        System.out.println("Monkey is biting.");
    }
}

interface Basic_animal{
    void sleep();
    void eat();
}

class Human extends Monkey implements Basic_animal{
    public void sleep(){
        System.out.println("Sleeping.");
    }
    public void eat(){
        System.out.println("Eating");
    }
}

// p4-----

abstract class Phone{
    
    abstract public void ring();
    abstract public void lift();
    abstract public void disconnect();

}

class Smart_phone extends Phone{
    public void ring(){
        System.out.println("Phone is ringing.");
    }
    public void lift(){
        System.out.println("The phone has been lifted.");
    }
    public void disconnect(){
        System.out.println("The phone has been disconnected.");
    }

    // Smart_phone, its own method

    public void name(){
        System.out.println("This is smart phone.");
    }
}

// p5------

interface Tv_remote{

    void change_channel();
    void change_volume();

}

interface Smart_tv_remote extends Tv_remote{
    
    void light();
}


public class Ch_60_prac {
    public static void main(String[] args) {
        
        /* 
        // P1 and 2-- pen abstract class and inheritance.
        
        Fountain_pain pen = new Fountain_pain();

        pen.write();
        pen.change_nib();
        
        */

        /* 
        // P3- class and interface inheritance to a class

        Human hum = new Human();

        hum.eat();
        hum.bite();
        */

        /* 
        // P4- Demonstrating polymorphism using monkey class

        Monkey mon = new Human();
        mon.bite();
        */

        /* 
        // P4 - Demonstrating polymorphism by interface and class

        Phone ph = new Smart_phone();

        ph.ring();
        ph.disconnect();
        // above is dynamic dispatching
        
        // ph.name();  -----------> not allowed because of reference in polymorphism.

        */


        // P5- Inheritance from interface to interface.


        
        









    }
    
}
