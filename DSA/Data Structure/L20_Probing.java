import java.util.ArrayList;



class QuadraticProbing{
	String[] hashTable;
	int usedCellNumber;

	public QuadraticProbing(int size){
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
			this.insertKeyInHashTable(s);
		}
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

	public void insertKeyInHashTable(String word){
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) rehashKeys(word);

		else{
			int index = modASCIIHashFunction(word, this.hashTable.length);
			int counter = 0;
			for (int i=index; i < index + this.hashTable.length; ++i){
				//Main logic of Quadratic probing ******
				int newIndex = (index + (counter * counter)) % this.hashTable.length;

				if (this.hashTable[newIndex] == null){
					this.hashTable[newIndex] = word;
					System.out.println(word + " add successfully at index: " + newIndex);
					break;
				}
				else{
					System.out.println(newIndex + " th index is already occupied, try next cell..");
				}
				counter++;
			}
			this.usedCellNumber++;
		}
	}
	

	public boolean search(String word){
		if (this.hashTable == null){
			System.out.println("The hash table does'nt exist");
			return false;
		}
		
		int index = modASCIIHashFunction(word, this.hashTable.length);
		int counter = 0;
		for (int i=index; i < index + this.hashTable.length; ++i){
			int newIndex = (index + (counter * counter)) % this.hashTable.length;
			
			if (this.hashTable[newIndex] == word){
				System.out.println(word + " found at index " + newIndex);
				return true;
			}
			counter++;
		}	
		System.out.println(word + " is not found hash table");
		return false;
		
	}

// With same Quadratic probing logic delete method will be created.

}

//------------------------Double Hashing------------------------------------------


class DoubleHashing{
	String[] hashTable;
	int usedCellNumber;

	public DoubleHashing(int size){
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



	public double getLoadFactor(){
		double loadFactor = this.usedCellNumber * 1.0/hashTable.length;
		return loadFactor;
	}


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
			this.insertKeyInHashTable(s);
		}
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


	private int addAllDigitsTogether(int sum){
		int value = 0;
	
		while (sum > 0){
			value += sum % 10;
			sum = sum / 10;
		}
		return value;
	}

	public int secondHashFunction(String word, int array_size){
		
		char[] ch = word.toCharArray();
		int i,sum;

		for (i=0,sum=0; i < word.length(); ++i){
			sum += ch[i];
		}

		while (sum > this.hashTable.length){ // It make sure that sum is less than array size for indexing.
			sum = addAllDigitsTogether(sum);
		}
		
		return sum % array_size;
	}

	public void insertKeyInHashTable(String word){
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75){
			rehashKeys(word);
		}
		else{
			// Double hashing logic ***********
			int hashValue1 = modASCIIHashFunction(word, this.hashTable.length);
			int hashValue2 = secondHashFunction(word, this.hashTable.length);

			for (int i=0; i< this.hashTable.length; ++i){
				int newIndex = (hashValue1 + i*hashValue2) % this.hashTable.length;

				if (this.hashTable[newIndex] == null){
					this.hashTable[newIndex] = word;
					System.out.println(word + " is inserted at index: " + newIndex);
					break;
				}
				else{
					System.out.println(newIndex + "th index is pre-occupied, trying next index....");
				}
			}
		}	
		this.usedCellNumber++;
	}

	public boolean search(String word){
		if (this.hashTable == null){
			System.out.println("Hash table does'nt exist.");
			return false;
		}

		int hashValue1 = modASCIIHashFunction(word, this.hashTable.length);
		int hashValue2 = secondHashFunction(word, this.hashTable.length);

		for (int i=0; i<this.hashTable.length; ++i){
			int newIndex = (hashValue1 + i*hashValue2) % this.hashTable.length;

			if (this.hashTable[newIndex] == word){
				System.out.println(word + " is found at index: " + newIndex);
				return true;
			}
		}

		System.out.println(word + " is not found in hash table");
		return false;
	}

}





public class L20_Probing{
	
	public static void main(String[] args){

		/*
		QuadraticProbing qp = new QuadraticProbing(13);

		qp.insertKeyInHashTable("the");
		qp.insertKeyInHashTable("quick");
		qp.insertKeyInHashTable("brown");
		qp.insertKeyInHashTable("fox");
		qp.insertKeyInHashTable("over");
		qp.insertKeyInHashTable("lazy");
	
		qp.displayHashTable();
		
		qp.search("fox");
		qp.search("nothing");

		*/

		DoubleHashing dh = new DoubleHashing(13);

		dh.insertKeyInHashTable("The");
		dh.insertKeyInHashTable("quick");
		dh.insertKeyInHashTable("brown");
		dh.insertKeyInHashTable("fox");
		dh.insertKeyInHashTable("over");
		dh.insertKeyInHashTable("lazy");

		dh.displayHashTable();

		dh.search("fox");
		dh.search("ami");


	}


}












