public class Ch_29_practice {

    public static void main(String[] args) {
        
        /* 
        // P1- creating a array of 5 floats and getting their sum. -----------------------------------

        float [] nums = {1.2f, 14.1f, 5.4f, 34.5f, 5.3f};

        float sum = 0f;

        for (float element: nums){
            sum += element;
        }

        System.out.println("The sum is " + sum);

        */



        /* 
        // P2 - finding if a given int exist in a array. -----------------

        int [] nums = {4,2,6,23,8,3};

        int find = 8;
        boolean it_exist = false;
        // boolean default value is false.

        for (int j : nums){

            if (j == find){
                it_exist = true;
                break;
            }
        }

        if (it_exist){
            System.out.println("Yes it exist");
        }
        else{
            System.out.println("IT does'nt exist.");
        }

        */



    /* ------------------------------------------- 
    //  P3 -    get average

    float [] marks = {24,32,54,23,89,97};
    
    float sum = 0;

    for (float element : marks){
        sum += element;
    }

    float average = sum/marks.length;

    System.out.format("Average is %.2f", average);

    */


    /* 
    // P4- Adding the matrix -------------------------------


    int [][] mat1 =  {{1, 2, 3}, 
                      {4, 5, 6}};

    int [][] mat2 = {{7, 8, 9},
                     {10, 11, 13}};
                     
    
    int [][] result = {{0, 0, 0},
                        {0, 0, 0}};
                        
                        
    for (int i=0; i < mat1.length; ++i){

        for (int j=0; j< mat1[i].length; ++j){

            result[i][j] = mat1[i][j] + mat2[i][j];

        }

    // For this the matrix have to be equal in dimension. like  there both was 2 X 3.
    }                    

    // printing the result

    for (int i = 0; i < result.length; ++i){
        for (int j=0; j < result[i].length; ++j){
            System.out.print(result[i][j]+ " ");
        }
        System.out.println();
    }

    */



    // P5 - Reversing the array ----------------------------


    // int [] arry = {1,2,3,4,5};
    // int arry_len = arry.length;

    // int [] r_array = new int [arry_len];

    // for (int i=0; i < arry_len; ++i){
    //     r_array[i] = arry[arry_len -1 - i];
    // }

    // // Printing the r_arry
    
    // for (int j : r_array){
    //     System.out.print(j + " ");
    // }



    /* 
    // Reversing array using swap method ------------------------------

    // In "swap method" we swap the corresponding initial and final numbers.
    // ie {1,2,3,4} - swapping 1 to 4 and 2 to 3. The result will be a reversed array.

    int [] nums = {1,2,3,4,5,6};

    int temp;
    int array_len = nums.length;

    int loop_to = Math.floorDiv(array_len, 2);
    // works live py floor division.
    // "loop_to" is the time the loop should occur. which is the greatest integer of (array's length/2). 

    for (int i = 0; i < loop_to; ++i ){


        temp = nums[i];
        int corresponding_num = array_len - 1 -i;

        nums[i] = nums[corresponding_num];

        nums[corresponding_num] = temp;

    }

    // printing the reverse array.
    for (int i = 0; i < nums.length; ++i){
        System.out.println(nums[i]);
    }

    // Here we modified the original array rather then creating a new one.

    */



    /* 
    // P6- finding the max element in array. -------------------------
    
    int [] values = {16,54,32,89,34,76,45};

    int max = values[0];

    for (int num : values){

        if (num > max){
            max = num;
        }
    }

    System.out.println("This is max: " + max);

    */





    // P7- Checking if array is sorted.


    int [] values = {23,31,42,13,34,54,78,56,31};
    // int [] values = {1,2,3,4,5,6,7};

    int array_len = values.length;
    boolean is_sorted = true;

    for (int i=0; i < array_len -1; ++i){

        if (values[i] > values[i +1]){
            is_sorted = false;
            break;
        }
    }

    if (is_sorted){
        System.out.println("The array is sorted");
    }

    else {
        System.out.println("The array is not sorted");
    }


    }
    
}
