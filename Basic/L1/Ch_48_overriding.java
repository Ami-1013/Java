/*  Overriding in class inheritance.

    - If parent and child have same method name with similar parameter then while using that method from child's object
      will override the parent method.
      ie child method replace the parent method in child's object

    - Overriding is replacement of methods where as in overloading there are more than 1 methods of same name but with different
      parameter.

    - "@Override" this annotation used just before the method which will override. It start will capital "O".
       
    Even though the code works fine without it. However it is used to tell the java and user that this method will override
        a parent method.
        
        "@Override" will give error if overriding is not taking place. Hence when "@Override" is there then override should happen
        if not then it will throw error even if the code if fine, because its is respect to overriding. 

        
        say, if you do some changes in parent code and change the overridden method of it, now which is no longer can be 
        overridden then it will give error in child body due to "@Override" annotation. 

        "@Override" in usage looks like python "Decorator".    

    Overriding can occur without writing "@Override"  
    
    
    - if parent and child have same attribute name then in child's object the child's attribute is 
        used. ie child's attrs override parent's attrs in inheritance.

*/ 

class Over1{

    public void say(){
        System.out.println("This is method of Over '1'");
    }
}

class Over2 extends Over1{
    
    // Using "@Override"
    @Override
    public void say(){
        System.out.println("This is method of Over '2'");
    }
}






public class Ch_48_overriding {
    public static void main(String[] args) {
        
        Over1 o1 = new Over1();

        Over2 o2 = new Over2();

        o1.say();
        o2.say();
        // in "Over2" the method is overriding the parent method


    }
    
}
