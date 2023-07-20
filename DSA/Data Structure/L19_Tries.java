/*  Tries
- It is a tree based data structure that organizes information in a hierarchy.
- Properties
    - It is typically used to store or search strings in a space and time efficient way.
    - Any node in a trie can store non repetitive multiple character.
    - Every node store link of the next character of the string.
    - Every node keeps track of "end of string".

- Used in spelling checking and auto completion etc.    
- Insertion cases
    - A trie is blank.
    - New string's prefix is common to another string prefix.
    - New string's prefix is already present as a complete string.
    - String to be inserted is already presented in tries.


*/ 

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    Map<Character, TrieNode> children;  // children is dictionary ie (key, value)
    boolean endOfString;

    public TrieNode(){
        children = new HashMap<>();
        endOfString = false;
    }
}

class Trie{
    public TrieNode root;

    public Trie(){
        root = new TrieNode();
        System.out.println("The trie has been created.");
    }

    public void insert(String word){
        /*   Below code is complex 
            - Over all there will be "n" iteration, not n + 1
            - While insertion, when a char is inserted it created a trie node, in which the next char will be stored.
        
        */
        TrieNode currentNode = root;
        for (int i=0; i<word.length(); ++i){
            char ch = word.charAt(i);
             
            TrieNode node = currentNode.children.get(ch);
            // if "ch" is not in dictionary it will return null.

            if (node == null){
                node = new TrieNode();
                currentNode.children.put(ch, node);
            }
            currentNode = node;
        }

        currentNode.endOfString = true;
        System.out.println("Inserted successfully, Word: " + word);
        
        // tc - O(N)    &   sc - O(N) as at worst case the word does'nt exist and we have to create N nodes.
    }


    /*  Searching
     - There are 4 cases in tries but for string there are 3 cases.
     - Cases
        1- The word does'nt exist.
        2- The word exist.
        3- The word is a prefix of another word.
    
    - At last char of word the "endOfString" property is checked of its trie node.
    */ 

    public boolean search(String word){
        TrieNode currentNode = root;
        for (int i=0; i < word.length(); ++i){
            char ch = word.charAt(i);

            TrieNode node = currentNode.children.get(ch);
            // if "ch" is not in dictionary, it will return null

            if (node == null){
                System.out.println("Word: '"+ word + "' does'nt exist.");
                return false;  
            } 

            currentNode = node;      
        }

        if (currentNode.endOfString == true) System.out.println("Word: '" + word + "' exit.");

        // for prefix words.
        else System.out.println("Word: '" + word +"' does'nt exit but its a prefix of another word.");

        return currentNode.endOfString;

        // tc - O(N)    &   sc - O(1)
    }

    /*  Deletion
    - Deletion is reverse ie it start from leaf (bottom) node.
    - Cases
        - Some other prefix of string is same as the one that we wanted to deleted. Ex - api, apple. (first is to be deleted)
        - The string is a prefix of another string. ex - api, apis
        - Other string is prefix of this string. ex - apis, ap
        - Not any node depend on this node. ex - k, api

    */ 

    // trie deletion is very complex and uses peculiar recursion. The crucial part is when which boolean to return.
    private boolean delete(TrieNode parentNode, String word, int index){
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;

        /* if dictionary has more than 1 key than 1 key will be removed, not the entire trie node will be deleted. As the 
            there a more than 1 key and next key will depend on current node key.
        */
        if (currentNode.children.size() > 1){
            delete (currentNode, word, index +1);
            return false;
        }
        if (index == word.length() -1){
            // if a condition fall in it then, this word is a prefix of another word. Thats why we have returned "false".
            if (currentNode.children.size() >= 1){
                currentNode.endOfString = false;
                return false;
            }
            else {
                parentNode.children.remove(ch);
                return true;
            }
        }
        /* if a condition fall in it then, a another word is a prefix of this word. Thats why we have returned "false".
            but word after prefix may/may not be deleted depending on the situation.
        */
        if (currentNode.endOfString == true){
            delete(parentNode, word, index + 1);
            return false;
        }

        canThisNodeBeDeleted = delete(parentNode, word, index + 1);
        if (canThisNodeBeDeleted == true){
            parentNode.children.remove(ch);
            return true;
        }
        else{
            return false;
        }

    }

    public void delete(String word){
        if (this.search(word) == true){
            delete(this.root, word, 0);
        }
        else{
            System.out.println(word + " : does'nt exit.");
        }
    }








}



public class L19_Tries {
    public static void main(String[] args) {
        
        Trie trie = new Trie();
        trie.insert("ami");
        
        trie.search("am");
        trie.delete("ami");

        trie.search("ami");


    }
}
