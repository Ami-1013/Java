
/*		Merge Sort

- Merge sort is a divide and conquer algo.
- Divide the input array into two halves and we keep halving recursively until they become too small that can't
	be broken further.
- Merge halves by sorting them.

- when to use
	i- When you need stable sort.
	ii- When average expected time is O(NlogN)

- When not to use
	i- When space is conceren.

- t.c - O(NlogN) &	s.c - O(N)	

*/

class MergeSort{

	void merge(int[] arr, int left, int middle, int right){
	
		int[] leftTempArr = new int[middle-left+2];	// Plus 2 and 1, so that we can avoid indexOutOfBound.
		int[] rightTempArr = new int [right - middle +1]; // a precation.

		for(int i=0; i<= middle-left; ++i){
			leftTempArr[i] = arr[left + i];
		}

		for(int i=0; i<right-middle; ++i){
			rightTempArr[i] = arr[middle + i+ 1];
		}

		leftTempArr[middle-left+1] = Integer.MAX_VALUE;	// setting last value to max.
		rightTempArr[right-middle] = Integer.MAX_VALUE;

		
		int i=0, j=0;

		// due to numbers of loops and left/rightTempArr last index MAX_VALUE, the for loop will run upto 
		// size of array and MAX_VALUE of left/rightTempArr(extra value) will not be inserted.
		for (int k=left; k <= right; k++){
			if (leftTempArr[i] < rightTempArr[j]){
				arr[k] = leftTempArr[i];
				i++;
			}
			else{
				arr[k] = rightTempArr[j];
				j++;
			}
		}
	}

	public void mergeSort(int[] arr, int left, int right){
		if (right>left){
			
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		
		}
	}
	
}


/*		Quick sort
 
- Quick is a divide and conquer algo.
- Find the pivot number and make sure samller numbers a located at the left of pivot and bigger numbers are
	located at the right of pivot.

- Unlike merge sort extra space is not required.
 
- When to use:
	i- When average expected time is O(NlogN).
	
- When not to use:
	i- When space is concern (if recursion is used).
	ii- When you need stable sort.
	
- t.c - O(NlogN) &	s.c - O(1);

 */


class QuickSort{
	
	public int partition(int[] arr, int start, int end){
		int pivot = end; 	// value of "pivot" depend on algo of programmer. For simplicity we have taken "end".
							// "pivot" is the index.
		int i = start -1;	// because at intital "start" will be zero;

		for (int j=start; j<=end; j++){
			if (arr[j] <= arr[pivot]){
				i++; // i at initial will be -1;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		L21_Sorting2.printArray(arr);
		System.out.println("pivot: " + pivot+ ", index: " + i);
		return i;	// i will be the pivot index after quick sort run.
	}

	public void quickSort(int[] arr, int start, int end){	// "end" will be arr.length-1
		if (start < end){
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot-1);	// because "pivot" is at center, already sorted.
			quickSort(arr, pivot +1, end);
		}
	}
}

/*		Heap Sort
- Insert data to binary heap tree.
- Extract data from binary heap 

- It is best suited with array, it does'nt work with linked list.
 
- t.c - O(NlogN) &	s.c - O(1). {Our heap sort take O(N) space because we have created new array. In general
			we assign value in Binary heap to original array which have to sort.}
 
 */

class HeapSort{

	int[] arr;

	public HeapSort(int[] arr){
		this.arr = arr;
	}

	// to use heap sort you have to import "binary heap" class that you have created in data structure.
	
	/*
	public void heapSort(){
		BinaryHeap bh = new BinaryHeap(arr.length);
		for(int i=0; i< arr.length; ++i){
			bh.insertInHeap(arr[i]);
		}

		for (int i=0; i<arr.length; ++i){
			arr[i] = bh.extractHeadOfHeap();
		}
	}
	*/

}


public class L21_Sorting2{
	
	public static void printArray(int[] arr){
		for (int i: arr){
			System.out.print(i + " ");
		}
	}


	public static void main (String[] args){
		
		int arr[] = {5,4,7,2,3,1,9,8,6};
		/*
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr, 0, arr.length-1);
		printArray(arr);
		*/


		QuickSort qs = new QuickSort();
		qs.quickSort(arr, 0, arr.length-1);

		printArray(arr);
	}
}
