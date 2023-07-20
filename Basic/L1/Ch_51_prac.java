class Library{

    int lib_size = 5;
    String [] lib = new String[lib_size];

    int book_slot = 0;
    boolean space = false;
    boolean found = false;

    public void set_default(){

        this.space = false;
        this.found = false;
    }

    private void enter(String book, String replace){
        // This is "private" because I don't want it to be accessed by user as individual its of no use
        // "private" methods cannot be used outside of class but can be used inside.
        
        /*
            This will do the "search" for books either it is giving or taking.
            Give and take can be manipulate by arguments.
            Attributes  - "space" and "found" play essential role in below methods.
        */ 

        for (int i = 0; i <lib_size; ++i){
            if (this.lib[i]== replace){
                this.lib[i] = book;

                this.book_slot = i;
                this.space = true;
                this.found = true;
                break;

            }
        }

    }

    public void show_book(){
        System.out.println("There are "+ lib_size + " book slots.");
        for (String book : this.lib){
            System.out.println(book);
        }
    }

    public void add_book(String x){ 


        this.enter(x, null);
        // This will replace "null" with user's book. Remember 'null' is a keyword.
        

        if (space){
            System.out.println("Success, book has been inserted to slot: "+ (book_slot + 1));
        }

        else{
            System.out.println("Library is out of space. All "+ lib_size + " slots of library are fulled.");
        }   

        this.set_default();
        // this will reset the "space" and "found" value.
        
    }


    public void issue_book(String book){

        this.enter(null, book);
      
        if (found){
            System.out.println("Your book has been issued.");
        }
        
        else {
            System.out.println("Sorry, library does'nt contain "+ book + "book.");
        }

        this.set_default();
    }
    

    public void return_book(String book){
        
        this.enter(book, null);


        if (space){
            System.out.println("Your books has been successfully submitted.");
        }
        else{
            System.out.println("Sorry, library is out of space.");
        }

        this.set_default();

    }
}



public class Ch_51_prac{
    public static void main(String[] args) {
        
        Library libr = new Library();

        libr.add_book("Life of pie");
        libr.add_book("Attack on titan");
        libr.show_book();

        libr.return_book("Fire and ice");
        libr.add_book("The princess of Mars.");
        libr.show_book();


    }
}