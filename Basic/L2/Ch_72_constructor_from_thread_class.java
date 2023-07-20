/*  We will do

- How to get thread id
- How to set thread name and how to get it.

*/ 

class My_thr extends Thread{

    public My_thr(String name){
        super(name);
        // "super" pass argument to constructor of parent class. In this case "Thread" class.

    }

    public void run(){
        System.out.println("this is thread.");
    }
}


public class Ch_72_constructor_from_thread_class {
    public static void main(String[] args) {
        
        My_thr t1 = new My_thr("Amish");

        t1.start();

        System.out.println("Thread id is: " + t1.getId());
        System.out.println("Thread name is: " + t1.getName());

    }    
}
