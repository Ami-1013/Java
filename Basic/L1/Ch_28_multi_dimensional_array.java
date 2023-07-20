public class Ch_28_multi_dimensional_array {

    public static void main(String[] args) {
        
    // Multi-dimensional are arrays inside arrays.
    // To create n-Dimensional arrays you have to use n[] while creating. 


    // -------------- 2-D arrays

    int [][] flats = new int [2][3];
    // In this, the first array have "2" spaces and the array inside of first array will have space for 3 elements.

    flats[0][0] = 100;
    flats[0][1] = 101;
    flats[0][2] = 102;
    
    flats[1][0] = 200;
    flats[1][1] = 201;
    flats[1][2] = 202;

    // Printing 2-D arrays using for loop

    for (int i = 0; i < flats.length; ++i){

        for (int j = 0; j < flats[i].length; ++j){
            System.out.println(flats[i][j]);
        
        }

    }










    }
    
}
