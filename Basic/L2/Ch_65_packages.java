//  Packages 

/* (.) is used in package to send the class in that directory.

    ex - package Amish.home;

    - The current java file will be send to "home" directory which is inside the "Amish" directory.
    - This helps in arrangement of the class.


*/

//-------------- 3 Ways to import packages ---------------------

// 1- Here a specific class from a package is imported.
// import java.util.Scanner;

// -----------------------------

// 2- All classes of a package is imported.
// import java.util.*;

// -------------------------------



public class Ch_65_packages {
    public static void main(String[] args) {
        
        // Scanner sc = new Scanner(System.in);

        // 3- To import class at that instance
        java.util.Scanner sc = new java.util.Scanner(System.in);

        int x = sc.nextInt();
        System.out.println("The input was: " + x);
    }
}

/*  Terminal commands for to compile 

- javac "file".java --> to convert java file to .class file

- javac  *.java --> to compile all java file in that directory

- Here all java file go compile but they will not be in "package" order. Rather all files will
  be created in current directory.
*/ 

// ---------------------------------


/*  Terminal command for compile regarding the "package" of file.

    Abstract -->  javac -d . "file".java

    - Through this .class file will be arrange with respect to their package directory
    - "."(dot) mean that created the compile package directory in current directory.


- javac -d . *.java --> will created package directory for all java files present in current directory
                      regarding the address of their in package.


- If you replace "."(dot) with some word then all the compile file package will be created in that
  word name directory which will be in current directory.

    ex- javac -d xyz *.java 
        - First "xyz" directory will be created in current directory then all that compile package 
          directory will be created inside "xyz" directory


- If you add a new java file or modify the existing java file and then compile 
  then java will automatically handle new java file location in package or code modification.

*/ 

// In java file, don't forget to address file location in "package"

// Before importing self-created library, create its compile package otherwise it will give "source not
// found error".