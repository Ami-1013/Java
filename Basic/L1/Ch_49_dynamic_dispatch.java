/*          Dynamic method dispatch
    
- The object of it is created at run time. Where ever there is "new" keyword then the object will be created at run time."
- For this inheritance is essential.
- Extract 
                "Super_class" obj = new "sub_class()":

                but, "sub_class" obj = new "super_class()";  is not allowed
                ie- reference should be parent and object must be class.


- As you can see the object is created from "subclass" but reference is of "super class".
- Here methods of "super class" works, ie "sub class" methods are not allowed.

- In case of "overriding" the "sub class" methods are used.
    ie - sub class only overriding methods are used and all other are super class methods.

- Same concept is for attributes- only super are used
    Even for overriding attribute the "super class" attribute are used.    


*/ 


class Phone{
    int x = 10;

    public void name(){
        System.out.println("This is Phone class");
    }

    public void old(){
        System.out.println("This is old model");
    }

}


class Smart_phone extends Phone{
    int y = 20;
    int x = 30;

    public void name(){
        System.out.println("This is Smart Phone class");
    }

    public void neww(){
        System.out.println("This is latest model.");
    }


}







public class Ch_49_dynamic_dispatch {
    public static void main(String[] args) {
     
        Phone mob = new Smart_phone();

        mob.name();
        mob.old();
        System.out.println(mob.x);
        // overriding not happen in attributes.

        /* 
            mob.neww();
            - This method is not allowed.
        
        
        */


    }    
}
