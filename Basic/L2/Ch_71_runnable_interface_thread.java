/*      Runnable interface for thread creation.

- Here we use "Runnable" interface to create thread.
- We have to override the method "run", which is an abstract method in "Runnable" interface.

- "Runnable" interface does'nt contain "start" method.

- To to launch thread we have to pass "Runnable" interface child as an argument in "Thread" class.
    Then use "start" method of "Thread" class's object. ie we get "start" method from "Thread" class. 
    You can't run thread just by calling "run" method, it can run by "start" method.

- Abstract 
                class run_child implements Runnable{
                    public void run(){

                    }
                }

                Thread t1 = new Thread(run_child);
                t1.start();

*/ 



class My_thread_runnable1 implements Runnable{
    
    public void run(){
        int x = 0;
        while (x <30){
            System.out.println("3 Thread 3");
            ++x;
        }
    }
}

class My_thread_runnable2 implements Runnable{

    public void run(){
        int z = 0;
        while (z < 30){
            System.out.println("4 thread 4");
            ++z;
        }
    }
}



public class Ch_71_runnable_interface_thread {
    public static void main(String[] args) {
        

        // Using gun and bullet analogy to get concept

        My_thread_runnable1 bullet1 = new My_thread_runnable1();
        My_thread_runnable2 bullet2 = new My_thread_runnable2();

        Thread gun1 = new Thread(bullet1);
        Thread gun2 = new Thread(bullet2);

        gun1.start();
        gun2.start();

        // "Runnable" interface does'nt contain "start" method, it of "Thread" class.


    }
    
}
