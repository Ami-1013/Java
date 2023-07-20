// p1---
class Circle{
    double radi;

    public Circle(double r){
        this.radi = r;
    }

    public double area(){
        return 2 * Math.PI * this.radi * this.radi;
    }
}


/* naming class "cylinder" give error was I already have created a class cylinder in another java file in this work space
    even though I am not using "package" function.
*/
class Cylinder1 extends Circle{
    double height;


    public Cylinder1(double r, double h){
        super(r);
        height = h;
    }

    public double total_area(){
        return 2 * Math.PI * this.radi *(this.radi + this.height);
    }
}


// p2-----------

class Rectangle1{
    int length;
    int breadth;

    public Rectangle1(int l, int b){
        length = l;
        breadth = b;
    }

    public int area(){
        return length * breadth;
    }

}

class Cuboid1 extends Rectangle1{
    int height;

    public Cuboid1(int l, int b, int h){
        super(l, b);
        height = h;
    }

    public int total_area(){
        return 2 * (length* breadth + breadth*height + height*length);
    }
}









public class Ch_52_prac_class {
    public static void main(String[] args) {
        
        /* 
        // P1- Creating "circle" class then using inheritance to create "cylinder" class.-----------------
        Cylinder1 cy = new Cylinder1(4, 5);
        System.out.println(cy.total_area());
        
        */



        // P2- Creating "Rectangle1" class then using inheritance to create "Cuboid1" class ---------------

        Cuboid1 cu = new Cuboid1(1,2,3);
        System.out.println(cu.total_area());




    }    
}
