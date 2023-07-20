
// p1 + p2
class Cylinder{

    private int radi;
    private int height;

    // Setter
    public void set_radi(int r){
        this.radi = r;
    }

    public void set_height(int h){
        this.height = h;
    }

    // Getter
    public int get_radi(){
        return radi;
    }
    
    public int get_height(){
        return height;
    }


    // methods for surface area and volume.

    public double total_area(){
        return 2 * Math.PI * this.radi * (this.radi + this.height);
    }

    public double volume(){
        return Math.PI * this.radi * this.radi * this.height ;
    }

    // p3

    public Cylinder(int radi, int height){
        this.radi = radi;
        this.height = height;
    }

}



class Rectangle{
    private int length;
    private int breath;

    public int get_lenght(){
        return this.length;
    }

    public int get_breath(){
        return this.breath;
    }

    // Overloading constructor

    public Rectangle(){
        this.length = 4;
        this.breath = 5;
    // Here default values are give to length and breath ie - 4 & 5
    }


    public Rectangle (int len, int brea){
        this.length = len;
        this.breath = brea;
        // Here custom value are given to length and breadth.
    }



}



public class Ch_44_prac {

    public static void main(String[] args){

        // P1- creating a cylinder class ----------------------------

        /* 
        Cylinder cy = new Cylinder();
        
        cy.set_radi(10);
        cy.set_height(12);

        System.out.println(cy.get_height());
        System.out.println(cy.get_radi());
        
        */
    
    
        // P2- Creating method for total surface area and volume of cylinder------------------------

        /* 
        Cylinder cyc = new Cylinder();
        cyc.set_radi(10);
        cyc.set_height(13);

        System.out.println(cyc.volume());
        System.out.println(cyc.total_area());
    
        */

        // P3- Setting radi and height with the help of constructor.

        /* 
        Cylinder cyc = new Cylinder(10, 13);

        System.out.println(cyc.volume());
        
        */

        // P4 - creating a rectangle class with overloading constructor 

        // Rectangle rec = new Rectangle();
        Rectangle rec = new Rectangle(3, 7);

        System.out.println(rec.get_lenght());
        System.out.println(rec.get_breath());


    
    
    
    
    }
    
}
 