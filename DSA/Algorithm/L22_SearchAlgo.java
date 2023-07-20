
/*		Linear search
- Create a function with two parameter which are an array and value.
- Loop through an array and check if the current array element is equal to the value.
- If found, then return the index of the element(it depend what the programmer want to return, it can also be
		a boolean or just print statement).
- If the value is never found return -1


 */

class LinearSearch{
	
	public static int linearSearch(int[] arr, int value){
		
		for (int i=0; i<arr.length; ++i){
			if (arr[i] == value){
				System.out.println(value + " found at index: " + i);
				return i;
			}
		}

		System.out.println(value + " not found in array");
		return -1;
	}

}

/*		Binary search

- Binary search is faster than the linear search.
- Half of the remaining elements can be eliminated at a time, instead of eliminating them one by one.
- Binary search works on only on "sorted array".
 
		Steps
- Create a function with two parameter which are sorted array and value.
- Create two pointer: a left pointer at the start of the array and right pointer at the end of the array.
- Based on left and right pointer calculate the middle value.
- While middle is not equal to value and start <= end loop:
		- if middle is greater than the value move right pointer down.
		- if middle is less than the value move the left pointer up.
- If value never found return -1  
 
- t.c - O(logN) &	s.c - O(1)
*/

class BinarySearch{
	
	public static int binarySearch(int[] arr, int value){
		int start = 0, end = arr.length -1;

		int middle = (start + end)/2;

		while (arr[middle] != value && start <= end){
			
			if (arr[middle] < value){
				start = middle +1;
			}
			else{
				end = middle - 1;
			}

			middle = (start + end)/2;
		}

		if (arr[middle] == value){
			System.out.println(value + " found at index: " + middle);
			return middle;
		}
		else{
			System.out.println(value + " is not found in array");
			return -1;
		}


	}
	
}

public class L22_SearchAlgo{
	public static void main (String[] args){

		/*
		int[] arr = {3,6,1,8,4,7,2,5,};

		LinearSearch.linearSearch(arr, 2);
		LinearSearch.linearSearch(arr, 44);
		*/

		int[] arr1 = {4,9,23,47,65,77,82,86,95};
		BinarySearch.binarySearch(arr1, 65);
		BinarySearch.binarySearch(arr1, 46);
	}
}
