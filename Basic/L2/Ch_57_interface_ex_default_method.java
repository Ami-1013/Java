/*  ---     Default method     ---
- An interface can have static and default methods.

- A "default" method is used to add a functionality to a existing interface without distributing the existing code. ie not give
    implement this error.
    Hence you add a concrete method in interface and the existing childs will not be disturbed and inherit it.

- Default methods can be override in child's class.

- "private" concrete methods (not abstract method) can be used in interface. As they are private it can't be accessed directly
   or by child.
   It is used to share logic or code if default code is long.

*/ 
interface Camera{

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


interface Wifi {

    String[] get_networks();
    void connect_to_network(String network);

}

// -----------------
class My_cellphone{

    public void call_number(int phone_number){

        System.out.println("Calling "+ phone_number);
    }

    public void pick_call(){
        System.out.println("Connecting...");
    }
}

// class "My_smartphone" will inherit class "My_cellphone" and interfaces - "Camera" and "Wifi"
// This is how you "extend" one class and inherit multiple "interfaces"
class My_smartphone extends My_cellphone implements Camera, Wifi {

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

}



public class Ch_57_interface_ex_default_method {
    public static void main(String[] args) {

        My_smartphone ph = new My_smartphone();

        String[] net = ph.get_networks();

        for (String i: net){
            System.out.println(i);
        }

        // using default method of interface and t
        ph.zoom();
        // "zoom" default method also contain the share code or logic of "private function" "share".

    }
}   