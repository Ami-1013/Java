
// p1
class Employee1{
    int salary;
    String name;

    public int get_salary(){
        return salary;
    }

    public String get_name(){
        return name;
    }

    public void change_name(String a){

        name = a;
    }

}


class Square{
    int side;

    public void area(){
        int area = side *side;
        System.out.println("The area of square with side "+ side +" is "+ area + " unit sq."); 
    }

    public void parameter(){
        int parameter = 4*side;

        System.out.println("The parameter of square with side "+ side + " uint is "+ parameter+" unit.");
        
    }

}



public class Ch_39_prac {
    public static void main(String[] args) {
        
        // p1 ------------------------
        // Employee1 amish = new Employee1();

        // amish.salary = 70;
        // amish.name = "Amish";

        // System.out.println(amish.name);

        // String name = "Nero";

        // amish.change_name(name);
        // System.out.println(amish.name);
        
    
        
        // p2- square ------------------------

        Square sq = new Square();

        sq.side = 5;
        sq.area();
        sq.parameter();








    }
    
}
