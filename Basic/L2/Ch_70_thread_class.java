/*      Creating Thread by extending Thread class.

                THREAD IS A TOPIC OF O.S 

- Here thread is created by extending(inheriting) the "Thread" class.

- The "run" method is of "Thread" class which is override in order to use thread.
- "start" method is used in objects to run thread. Its a method of "Thread" class.

- Even if two thread objects have same variable name the thread treat them differently, not as same.

- Thread process is "Concurrent".

*/ 

class My_thread1 extends Thread{
    
    @Override
    public void run(){
        int i = 0;
        while (i < 50){
            System.out.println("Thread 1.");
            ++i;
        }
    }
}


class My_thread2 extends Thread{


    @Override
    public void run(){
        int i = 0;
        while(i < 50){
            System.out.println("Thread 2.");
            ++i;
        }
    }
}


public class Ch_70_thread_class {
    public static void main(String[] args) {
        
        My_thread1 t1 = new My_thread1();
        My_thread2 t2 = new My_thread2();
        
 
        t1.start();
        
        int j = 0;
        while (j <20){
            System.out.println("Time pass");
            ++j;
        }

        t2.start();

        // "i" in My_thread1 and My_thread2 objects are treated differently, not as same

        // Concurrency is occurring from "t1.start()" to "t2.start()", including the while loop also.

    }
}
