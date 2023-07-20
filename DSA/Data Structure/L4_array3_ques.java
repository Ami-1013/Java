import java.util.Arrays;

public class L4_array3_ques {

    // Q1- Find the missing number from 1 to 100, number are consecutive
    public static void missingNumber(int[] arr){
        
        // the nth term of natural number
        // A.P formula for sum to nth term for natural numbers.
        
        int n = arr.length +1 ; // plus 1 because one number is missing.
        int sum = n*(n+1)/2;

        int arr_sum = 0;
        for (int num : arr){
            arr_sum += num;
        }

        System.out.println("Missing number is: " + (sum - arr_sum));
    }
    
    // Q2 - Finding the maximum product in a give array (only positive integer)
    public static void maxProduct(int[] arr){

        // num1 is the greatest int and num2 is the second greatest int in the array.
        int num1 = 0, num2 = 0;     //as array is a positive int array.
        
        for (int i : arr ){
            if (num1 < i){
                num1 = i;
            }
        }

        for (int j : arr){
            if (j > num2 && j < num1){
                num2 = j;
            }
        }

        System.out.println("The pair are: [" + num1 + "," + num2 + "]");
        System.out.println("The maximum product is: " + num1*num2);
    }
    
    // Q3- Rotating a 2-D array of NxN size by 90 degree from left to right.
    public static void rotateMatrix (int[][] arr){

        int size = arr.length; // as 2-D array is of NxN size.
        int[][] newArray = new int[size][size];

        for (int i=0; i<size; ++i){
            for (int j=0; j<size; ++j){

                newArray [i][j] = arr[size-j-1][i];
            }
        }

        System.out.println(Arrays.deepToString(newArray));

    }
    
    public static void main(String[] args) {
        
        
        int[] arr = {1,2,3,4,5,6,8,9,10};

        // Q1- 
        // missingNumber(arr);

        // Q2- 
        // maxProduct(arr);

        // Q3-
        int [][] arr2 = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotateMatrix(arr2);

    }
    
}
