
class Employee2{

    /* "private" access modifier, it mean the reference of that object can not be accessed direct using the parent object.
        However the private attrs and methds can we freely used in inside the class of it.

        hence "id" and "name" can't be change in a object. They even give error if we used them,.

        To change the values we use "getter" and "setter" public methods.
        However we can change them by using another methods with "public" modifier. Like which is done below.

        So the question why to  take another long alternative to change values?
        Its because when the developer does'nt want to some value to be changed by anyone. Therefore narrowing the access of it.

        or because we can use some code to "validate" the enter output. Like not string in "id"

    
    */
    private int id;
    private String name;


    // Below are "getter" and "setter" methods.
    public String get_name(){
        return name;

    }

    public int get_id(){
        return id;
    }

    public void set_name(String n){
        name = n;
    }

    public void set_id(int x){
        id = x;
    }

}



public class Ch_40_access_modifier {   
    public static void main(String[] args) {
        
        Employee2 amish = new Employee2();

        /* 
        amish.id = 1;
        amish.name = "Boss"
        
        this above lines will throw error because of "private" access modifier.

        */

        // Changing the value using "public" methods.

        amish.set_name("Kokushibo");
        amish.set_id(16);

        // System.out.println(amish.id);  ---> even using "private" things will give error, update toh bhot dur hogya fhir 🤣.
        System.out.println(amish.get_id());
        System.out.println(amish.get_name());

    }
    
}
