/*		Hashing

- Hashing is a method of sorting & indexing data. The idea behind hashing is to allow large amount of data to
	be index using keys commonly created by formulas.

- Hashing terminology

	Hash function - It is a function that can be used to map of arbitrary size of data to fixed size.
	Key - Input data by user.
	Hash value - A value that is returned by hash function. It is also known as hash code or digest.
	Hash table - It is data structure which implements an associative array abstract data type, a structure
					that can map keys to values. It is also known as dictionary or hashmap structure.
	Collision - A collision occurs when two different keys to a hash function produces the same output.

- Hash function.
	i- for int values
		int values % array_length(remainder) is used for the index of int values in array.
	
	ii- for string values
		first individual "ASCII" values of character is calculated then, their sum is taken.
		
		total_sum % array_length is used for the index of string values in array.

	** Hash function is the core of hashing. If a hash function is good then insertion, deletion, search will 
	take O(1) T.C otherwise it will take O(N).
		
- Properties of good hash function.
	- It distributes hash values uniformly across hash tables.
	- It has to use all the input data. (beginning to end).
	
- Collision resolution technique.

	i- Direct chaining: Implements the buckets as linked list. Colliding elements are stored in the list.
				Best used when size is uncertain and frequent deletion of elements is done.
	
	ii- Open addressing - Create 2x size of current hash table and recall hashing for current keys.
				Colliding elements are stored in other vacant buckets. During storage and lookup these are
				found through so called probing.
				Best used when size is known. 

		- Linear probing - It places new key into next closest following empty cell.
		- Quadratic probing - Adding arbitrary quadratic polynomial to the index util an empty cell is found.
						ex- index + 1*2, then index + 2*2, then index + 3*2, ......
		- Double hashing - Interval between probes is computed by another hash function.
					In total there will be 2 hash function. Initially first hash function is used however in 
					collision second hash function is used to get hash value and new index is given by
					sum of value returned by both hash function.

					ex - 1hashF_index + 0*2hashF_index, then 1hashF_index + 1*2hashF_index,
							then 1hashF_index + 2*2hashF_index , then 1hashF_index + 3*2hashF_index, .......


 */

import java.util.ArrayList;
import java.util.LinkedList;


// -------------------------------- Direct chaining-------------------------------
class DirectChaining{
	
	LinkedList<String>[] hashTable; 	// a array which will contain linked list of string as its element.
	int maxChainSize = 7;

	public DirectChaining(int size){

		hashTable = new LinkedList[size];
		// will show waring as its an array of linked list, array has fixed size where as linked list size is dynamic so the 
		// linked list may exceed array memory capacity.
	}
	
	public int modASCIIHashFunction(String word, int array_size){
	
		char[] ch;

		ch = word.toCharArray();
		// "toCharArray" give array of char made up of letters in string.
		int i,sum;
		
		// quite unique two declaration in for loop.
		for(sum=0,i=0; i<word.length(); ++i){
		
			sum += ch[i];
		}

		return sum % array_size;
	}	

	public void insertHashTable(String word){
		
		int newIndex = modASCIIHashFunction(word, hashTable.length);
		if (hashTable[newIndex] == null){
			hashTable[newIndex] = new LinkedList<String>();
		}

		hashTable[newIndex].add(word);
	}

	public void displayHashTable(){
		if (this.hashTable == null) System.out.println("Hash table does'nt exit.");

		else{
			System.out.println("----------------- Hash Table ----------------------");
			for (int i=0; i< this.hashTable.length; ++i){
				System.out.println("Index " + i + ", Key: " + this.hashTable[i]);
				}

		}	
	}	


	public boolean searchHashTable(String word){

		int newIndex = modASCIIHashFunction(word, hashTable.length);

		// 	hashTable != null, if there is no list(null), then .contains will throw error.
		if (this.hashTable[newIndex] != null && this.hashTable[newIndex].contains(word)){
			System.out.println("Word found: " + word + ", at index: " + newIndex);
			return true;
		}
		else{
			System.out.println("Word not found: "+ word);
			return false;
		}
	}
	

	public void deleteHashTable(String word){

		int newIndex = modASCIIHashFunction(word, this.hashTable.length);
		boolean search = searchHashTable(word);
		if (search == true){
			hashTable[newIndex].remove(word);
			System.out.println("Word: " + word + ", deleted");
		}
		else{
			System.out.println("Word: " + word + ", does'nt exit in hash table"); 
		}
	}
}


// ------------------------- Linear probing -----------------------------------

class LinearProbing{
	
	String[] hashTable;
	int usedCellNumber;

	public LinearProbing(int size){
		hashTable = new String[size];
		usedCellNumber = 0;

	}

	public int modASCIIHashFunction(String word, int array_size){
	
		char ch[];

		ch = word.toCharArray();
		int i,sum;
		
		for(sum=0,i=0; i<word.length(); ++i){
		
			sum += ch[i];
		}

		return sum % array_size;
	}	

	/* Load factor is used to when to create new hash table. If load factor is greater than 0.75 than new
		hash table is created. It helps to maintain T.C of O(1).
		It is basically is how much space in used in hashtable(percentage).
	*/ 

	public double getLoadFactor(){
		double loadFactor = this.usedCellNumber * 1.0/hashTable.length;
		return loadFactor;

	}

	/* rehash - to rehash when new hash table is created.
				it create a new 2x size hash table and fill existing elements in it.
	*/
	public void rehashKeys(String word){
		this.usedCellNumber = 0; // insertInHashTable f will update it will inserting values.
		ArrayList<String> data = new ArrayList<String>();

		for (String s : this.hashTable){
			if (s != null){
				data.add(s);
			}
		}
		data.add(word);
		// argument "word" is not included in hash table. See "insertHashTable" for understanding.
		this.hashTable = new String[hashTable.length * 2];
		
		for (String s: data){
			this.insertInHashTable(s);
		}

	}

	// Insertion
	public void insertInHashTable(String word){
		double loadFactor = getLoadFactor();
		
		if (loadFactor >= 0.75){
			rehashKeys(word);
		}
		else {
			int index = modASCIIHashFunction(word, hashTable.length);
			for (int i=index; i<index + hashTable.length; ++i){
				/* "index + hashTable", due to it ater "i" reaches the end of hash table it goes at the 
				 	beginning of hash table and continue till the position of "index".
					Hence this code make your hash table use space more effectivly.
				 */
				int newIndex = i % this.hashTable.length;
				if (this.hashTable[newIndex] == null){
				this.hashTable[newIndex] = word;
				System.out.println("Word: "+ word + ", inserted at index: "+ newIndex);
				break;
				}
				else{
					System.out.println(i + "th place already occupied, try next empty cell.");
				}
			}
			// "rehashKeys" and "load factor" ensure that the hashtable has free space.
		}
		this.usedCellNumber++;
	}

	public void displayHashTable(){
		if (this.hashTable == null) System.out.println("Hash table does'nt exit.");

		else{
			System.out.println("----------------- Hash Table ----------------------");
			for (int i=0; i< this.hashTable.length; ++i){
				System.out.println("Index " + i + ", Key: " + this.hashTable[i]);
				}

		}	
	}	

	public boolean searchHashTable(String word){
		if (this.hashTable == null){
			System.out.println("Hash table does'nt exist");
			return false;
		}
		int index = modASCIIHashFunction(word, hashTable.length);
		for (int i=index; i<index + this.hashTable.length; ++i){
			int newIndex = i % this.hashTable.length;
			if (this.hashTable[newIndex] == word){
				System.out.println(word + " found at index: " + newIndex);
				return true;
			}
		}
		System.out.println(word + " is not found in hash table");
		return false;
	}

	public void deleteKeyHashTable(String word){
		if (this.hashTable == null){
			System.out.println("Hash table does'nt exist.");
			return;
		}
		
		int index = modASCIIHashFunction(word, this.hashTable.length);

		for (int i=index; i<index + this.hashTable.length; ++i){
			int newIndex = i % this.hashTable.length;
			if (this.hashTable[newIndex] == word){
				this.hashTable[newIndex] = null;
				System.out.println(word + " deleted from index: " + i);
				this.usedCellNumber--;
				return;
			}
		}
		System.out.println(word + " not found in hash table");

	}


}



public class L20_Hashing{

	public static void main(String[] args){
	
		/*
		DirectChaining dc = new DirectChaining(13);
		dc.insertHashTable("ami");
		
		dc.insertHashTable("adf");
		dc.insertHashTable("dsaf");
		dc.insertHashTable("sdge");
		
		dc.displayHashTable();

		dc.searchHashTable("ami");
		dc.searchHashTable("eren");
		
		dc.deleteHashTable("ami");
		dc.displayHashTable();

		*/

		LinearProbing lp = new LinearProbing(13);
		lp.insertInHashTable("the");
		lp.insertInHashTable("quick");
		lp.insertInHashTable("brown");
		lp.insertInHashTable("fox");
		lp.insertInHashTable("over");

		lp.displayHashTable();

		lp.searchHashTable("fox");
		lp.searchHashTable("good");


		lp.deleteKeyHashTable("fox");
		lp.deleteKeyHashTable("good");
		
		lp.displayHashTable();


	}
	
}
