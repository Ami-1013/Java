
// In java there can be only one public class.

// () are not used in class but is used in function and methods.
class Employee{
    int id;
    String name;

    public void Detail(){
        System.out.println("My id is: " + id);
        System.out.println("My name is: " + name);
    }

}


public class Ch_38_custom_class {
    public static void main(String[] args) {
        System.out.println("This is custom class.");

        // Creating the object "amish" from class "Employee"
        Employee amish = new Employee();

        // assigning the attributes.
        amish.id = 10;
        amish.name = "Amish";
        // System.out.println(amish.id);


        // using methods 

        amish.Detail();
        // if you don't assign attribute and run "Detail()" then it will give, id = 0 and name = null.

    }
    
}
