/*      Polymorphism in interface

- "Polymorphism" mean implementation of certain methods which is referred by an "interface".
    This also mean except those certain interface methods all other methods are restricted including the methods of that object.

- "Polymorphism" is dynamic dispatch. Where as "interface" or "parent class"  are reference and object is of another class.
*/ 




interface Camera2{

    void take_snap();
    void record_video();

    // private method
    private void share(){
        System.out.println("In this function code is shared.");
    }
    
    // "default" method
    default void zoom(){
        // using private method to share logic or code.
        share();
        System.out.println("Zooming in...");
    }
}


interface Wifi2 {   

    String[] get_networks();
    void connect_to_network(String network);

}

// -----------------
class My_cellphone2{

    public void call_number(int phone_number){

        System.out.println("Calling "+ phone_number);
    }

    public void pick_call(){
        System.out.println("Connecting...");
    }
}

class My_smartphone2 extends My_cellphone2 implements Camera2, Wifi2 {

    public void take_snap(){
        System.out.println("Taking snap.");
    }

    public void record_video(){
        System.out.println("Video is recording.");
    }

    public String[] get_networks(){
        System.out.println("Getting the list of networks.");
        String[] network_list = {"Amish", "Eren", "Kokushibo"};
        return network_list;
    }

    public void connect_to_network(String network){
        System.out.println("Connecting to network "+ network);
    }

    public void smartphone(){
        System.out.println("This is a smart phone.");
    }

}




public class Ch_59_polymorphism {
    public static void main(String[] args) {
        
        // This "polymorphism" is dynamic dispatch of interface and class that implement interfaces.

        // As "Camera2" interface is referred, only that interface methods are used. ie restriction on all other methods including
        // own methods of My_samrtphone class like method "smartphone".
        Camera2 cam = new My_smartphone2();

        cam.take_snap();
        
        // cam.smartphone();  ---> This method will not work.

        



    }
    
}
