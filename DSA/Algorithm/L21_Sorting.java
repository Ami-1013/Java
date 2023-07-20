/*				Sorting

- By defination sorting refers to arranging data in a particular format.
	Such as ascending or descending, or can type of format. 
 
- Types of sorting
		It is divide into two categories - space used and Stablity
		
	1- Space used - It is of 2 types 
					i- In place sorting - Sorting algo which does'nt require any extra space for sorting.
					ex Bubble sort

					ii- Out of place sorting - Sorting algo which require an extra space for sorting.
					ex Merge sort

	2- Stability - It is also of 2 types
					i- Stable - If a sorting algo after sorting the contents does not change the "sequence" of 
							similar content in which they appear, then this sorting is called stable jsorting.
							ex- Insertion sort

					ii- Unstable - If a sorting algo after sorting the contents changes the "sequence" of similar
							similar content in which they appear, then it is called unstable sort.
							ex Quick sort

- Sorting Terminology
	
	1- Increasing order - if successive element is greater than the previous one.
						ex - 1,4,6,9

	2- Decreasing order - if successive element is less than the previous one.
						ex - 11,9,6,3
	
	3- Non-increasing order - if a successive element is less than or equal to its previous element in the 
						sequence. ex - 11,9,6,3,3,2
	
	4- Non-decreasing order - if a successive element is greater than or equal to its previous element in the
						sequence. ex - 1,3,5,6,7,7,8,11	

*/


//--------------------------------------------------------------------------------------------
/*		Bubble sort			

- Bubble sort is also known as Sinking sort.

- We repeatedly compare each pair of adjacent items and swap them if they are in wrong order.

- When to used bubble sort
	i- When the input is almost sorted. Hence it will do less operation and take less time.
	ii- Space is concern
	iii- Easy to implement

- When to avoid bubble sort
	i- Average time complexity is very poor.
 */


import java.util.ArrayList;
import java.util.Collections;



class BubbleSort{
	
	public void bubbleSort(int[] arr){
		int n = arr.length;

		for(int i=0; i<n-1; ++i){
			for (int j=0; j<n-i-1; ++j){
		
				if (arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
			
				}
			}
		} 
		// t.c - O(N*2)  &	s.c - O(1)
	}

	public void printArray(int[] arr){
		
		for(int i: arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}


}


//------------------------------------------------------------------------
/*			Selection sort
- In case of selection sort we repeatedly find the minimun element and move it to the sorted path of array to
	make unsorted part sort.
 
- When to use Selection sort
	i- When we have insufficient memory.
	ii- Easy to implement

- When to Avoid
	i- When time is concern. t.c O(N*2)
*/

class SelectionSort{
	
	public void selectionSort(int[] arr){
		for (int i=0; i<arr.length; ++i){
			int minimumIndex = i;

			for (int j= i+1; j < arr.length; ++j){
				if (arr[j] < arr[minimumIndex]){
					minimumIndex = j;
				}
			}
			if (minimumIndex != i){
				int temp = arr[i];
				arr[i] = arr[minimumIndex];
				arr[minimumIndex] = temp;
			}
		}
	}
	
}
//---------------------------------------------------------

/*		Insertion Sort

- Divide the given array into two parts.
- Take first element from the unsorted array and find its correct position in sorted array.
- Repeat until unsorted array is empty.

- When to use:
	i- When we have insufficient memory.
	ii- Easy to implement.
	iii- When we have continous inflow of numbers and we want to keep them sorted.

- When not to use:
	i- When time is concern.

*/

class InsertionSort{
	
	public void insertionSort(int[] arr){
		for(int i=1; i<arr.length; ++i){
			int temp = arr[i], j=i;

			// "temp" is at "jth" position. In sorted array we start comparition from end that why there is 
			// condition of "arr[j-1] > temp" then we change value.
		
			while (j>0 && arr[j-1] > temp){
				// here we shift value until we find correct place for "temp". Where the while loop break is 
				// the position of temp.
				arr[j] = arr[j-1];
				j--;
			}
			// first we move values and find the correct place of "temp", then insert it at last.
			arr[j] = temp;
		}
	}
}

//------------------------------------------------------------------
//
/*		Bucket Sort

- Create bucket and distribute the element of array into bucket.
- Sort bucket individually.
- Merge bucket after sorting.

- Formula
	i- NumberOfBucket = round(SqRoot(number of elements))
	ii- AppropriateBucket = ceil(elementValue * numberOfBucket/ MaxValue), ceil is smallest integer function.

- When to use:
	i- When input uniformly distributed over range. i.e difference between number is not big.
		ex - 1,2,3,4,5,6 (small difference)
			1,4,6,33,56,74 (big difference)

- When not to use:
	i- When space is concern.
*/

class BucketSort{
	
	int arr[];
	
	public BucketSort(int[] arr){
		this.arr = arr;
	}
	
	// print buckets
	public void printBucket(ArrayList<Integer>[] buckets){
		// "buckets" is an array of "ArrayList".
		for (int i=0; i<buckets.length; ++i){
			System.out.println("\nBucket: " + i);

			for (int j=0; j<buckets[i].size(); ++j){
				System.out.print(buckets[i].get(j) + " ");
			}
		}
	}

	// bucket sort
	public void bucketSort(){

		// "ceil" is for samllest integer function and "sqrt" is for square root.
		int numberOfBuckets = (int) Math.ceil(Math.sqrt(this.arr.length)); 
		
		int maxValue = Integer.MIN_VALUE;
		for (int i: this.arr){
			if (i > maxValue){
				maxValue = i;
			}
		}

		ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
		// initializing "array list" in buckets(array).
		for (int i=0; i<buckets.length; ++i){
			buckets[i] = new ArrayList<Integer>();
		}

		for (int value: arr){
			int  bucketNumber = (int) Math.ceil(((float)value * numberOfBuckets)/(float)maxValue);
			buckets[bucketNumber -1].add(value);
		}

		System.out.println("\n\nPrinting buckets before sorting.....");
		this.printBucket(buckets);

		for (ArrayList<Integer> bucket: buckets){
			Collections.sort(bucket);
		}


		System.out.println("\n\nPrinting buckets after sorting.....");
		this.printBucket(buckets);

		int index=0;

		for (ArrayList<Integer> bucket: buckets){	// "buckets" is an array of ArrayList.`
			for (int value: bucket){		// "bucket" is ArrayList
				this.arr[index] = value;
				index++;
			}
		}

	}





}





public class L21_Sorting{

	
	public static void printArray(int[] arr){
		for (int i: arr){
			System.out.print(i + " ");
		}
		System.out.println();
	} 


	public static void main(String[] args){
	
		int[] arr = {10,2,30,50,15,5};

		/*
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(arr);
		bs.printArray(arr);
		*/

		/*
		SelectionSort ss = new SelectionSort();
		ss.selectionSort(arr);
		printArray(arr);
		*/

		/*
		InsertionSort is = new InsertionSort();
		is.insertionSort(arr);
		printArray(arr);
		*/


		
		int[] arr1 = {9,4,7,2,5,8,3,1,6};
		BucketSort bs = new BucketSort(arr1);

		printArray(arr1);
		bs.bucketSort();
		System.out.println();
		printArray(arr1);




	}

}
