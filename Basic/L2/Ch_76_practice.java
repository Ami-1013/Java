
class Thr3 extends Thread{
    public void run(){
        for (int i=0; i <30; ++i){
            System.out.println("Good morning");
        }
    }
}

class Thr4 extends Thread{
    public void run(){
        for (int j =0; j <30; ++j){
            System.out.println("Welcome");
        }
    }
}


public class Ch_76_practice {
    public static void main(String[] args) {
        
        Thr3 t1 = new Thr3();
        Thr4 t2 = new Thr4();

        t1.start();
        t2.start();

    }    
}
