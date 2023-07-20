
/* "extends" keyword is used for inheritance.
    One which is inheriting is called child or sub class and from which it is inheriting is called parent, super class or base.
    Java does'nt support multiple inheritance. 

    If child and parent have methods of same name and child call for that methods then child method is
    invoked, not parent.
    ie. child overwrite the parent method of same name. if no. argument and their datatype is same.
    - number of arguments, argument datatype play crucial role in selection of method.

 */

class Base{
    int b = 10;

    public void its_base(){
        System.out.println("You are in 'base' class.");
    }
}


class Derived extends Base{

    int d = 20;

    public void its_derived(){
        System.out.println("This is 'Derived' class which is inheriting from 'base' class.");
    }

}


public class Ch_45_inheritance {
    public static void main(String[] args){

        /* 
        // This is parent class "Base"
        Base base = new Base();

        System.out.println(base.b);
        base.its_base();
        
        */


        // This is child class "Derived" which has inherited from "Base" class

        Derived derived = new Derived();

        // first check inherited attributes and methods.

        System.out.println(derived.b);
        derived.its_base();

        // Now "Derived" class own attrs and methds.

        System.out.println(derived.d);
        derived.its_derived();
   
   
   
    }   
    
}
