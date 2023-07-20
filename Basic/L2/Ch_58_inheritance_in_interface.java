/*      Inheritance in interface
- A "interface" can inherit another interface by "extends" keyword. 
  If "implements" keyword is used it mean implementing the function where as "extends" mean inheritance.
  "implement" can be done by class, not interface.  

*/ 

interface sample_interface{
    void meth1();
    void meth2();
}


/* interface child_interface implements sample_interface{}

- This is wrong form for a interface to inherit another interface, as implements imply that it methods must be used, not inherit.

*/
interface child_interface extends sample_interface{
    // "child_interface" has inherit "sample_interface"
    void meth2();
    void meth4();
}


class My_interface implements child_interface{
    // You have defined "sample_interface" methods also because "child_interface" has inherit them.

    public void meth1(){
        System.out.println("Meth1");
    }

    public void meth2(){
        System.out.println("Meth2");
    }

    public void meth3(){
        System.out.println("Meth3");
    }

    public void meth4(){
        System.out.println("Meth4");
    }
}


public class Ch_58_inheritance_in_interface {
    public static void main(String[] args) {
        
        My_interface in = new My_interface();

        in.meth2();
        in.meth4();


    }
    
}
