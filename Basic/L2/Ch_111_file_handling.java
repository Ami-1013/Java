/*      File handling

- Different packages are used in file handling. like
    java.io.File
    java.io.FileWriter
    
    java.io.IOException
    java.io.FileNotFoundException

- Creating, Reading and Deleting are done by "File" class. Where as Writing is done by "FileWriter" class.

- Exception handling and "throw and throws" are use in file handling.

*/ 



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ch_111_file_handling {
    public static void main(String[] args) {

        // Creating a file
        /* 

        File fil = new File("textfile.txt");

        try {
            fil.createNewFile();
        } catch (IOException e) {
            System.out.println("Error occur will creating a new file.");
            e.printStackTrace();
        }

        
        // Writing a file
        
        try{
            FileWriter fil_wr = new FileWriter("textfile.txt");
            fil_wr.write("This is a new file.\nIts is okay.");
            fil_wr.close();
        }

        catch (IOException e){
            System.out.println("Can't write");
            System.out.println(e);
        }
        
        */

        /* 
        // Reading a file

        File fil = new File("textfile.txt");
        try{
            Scanner sc = new Scanner(fil);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        }

        catch(FileNotFoundException e){
            System.out.println("File can't be read as it does'nt exist.");
            System.out.println(e);
        }
        
        */


        // Deleting a file

        File fil = new File("textfile.txt");
        if (fil.delete()){
            System.out.println("The has been deleted.");
        }
        else{
            System.out.println("The file can't be deleted. Error");
        }




    }
    
}
