/*
- When a thread object is started by "object.start()" then other thread objects also get started with it.

- To make other thread not to start until first thread is finished we use "join()" method of "Thread" class.
  The "join" method should be in "try and catch", we do this because if 1st thread got terminated or finished and 
  other threads will be still waiting. So we catch the 1st thread terminated or finished "exception" and then
  start other threads.

  "join" method make other thread to wait until its thread(object) is dead and throw "InterruptedException" exception
   if any thread has interrupted the current thread. That why it is inside "try and catch" if it is unexpectedly is interrupted.
*/ 


class Thre1 extends Thread{


    public void run(){
        for(int i=0; i<100; ++i){
            System.out.println("Amish");
        }
    }
}

class Thre2 extends Thread{

    public void run(){
        for (int j = 0; j < 10 ; ++j){
            
            System.out.println("Eren");
            
        }
    }
}


public class Ch_75_thread_methods {
    public static void main(String[] args) {
        
        Thre1 t1 = new Thre1();
        Thre2 t2 = new Thre2();

        t1.start();

        try{
            t1.join();
        }

        catch(Exception e){
            System.out.println("Thread has died.");
        }

        t2.start();

        

    }
    
}
