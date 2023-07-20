
/*      Setting priority in threads

- Its mean how priority should be given to a thread.

- Its is given by passing "Thread._priority_" argument in thread objects method "setPriority()" .

            Extract - let say t1 is a Thread object.

                    t1.setPriority(Thread.Max_Priority)       10/10
                    t1.setPrioriy(Thread.Min_Priority)        1/10
                    t1.setPriority(Thread.Nor_Priority)       5/10  (default)


- Priority also highly depend on OS.


*/ 


class My_thre extends Thread{

    public My_thre(String name){
        super(name);
    }

    public void run(){
        
        for (int i =0; i <50; ++i){
            System.out.println("This is "+ this.getName());
        }
    }
}



public class Ch_74_thread_priorities {
    public static void main(String[] args) {
        
        My_thre t1 = new My_thre("Amish 1 (High Priority)");
        My_thre t2 = new My_thre("Amish 2");
        My_thre t3 = new My_thre("Amish 3");
        My_thre t4 = new My_thre("Amish 4");


        // This is how you set priority in thread. Max_Priority = 10, Min_Priority = 1, Nor_Priority = 5   all out of 10.
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);

        /*  You can also set priority through number ranging 1 to 10

        t1.setPriority(8);
        t1.setPriority(3);
        t1.setPriority(5);
        */ 


        t1.start();
        t2.start();
        t3.start();
        t4.start();

        /* You see thread priority by "getPriority" method

        t1.getPriority();
         
        */

    }
    
}
