
import java.util.HashMap;

public class ConvertOneStringToAnother {
    
    private int findMinOperatin(String s1, String s2, int index1, int index2, HashMap<String,Integer> memo){

        if (s1.length() == index1){ // because of this index can't be greater than String length
            return s2.length() - index2; // all delete operation 
        }

        if (s2.length() == index2){
            return s1.length() - index1; // all insert operation.
        }

        if (s1.charAt(index1) == s2.charAt(index2)){
            return findMinOperatin(s1, s2, index1 +1, index2 +1, memo);
        }

        // String.valueOf() is used to change int to String.
        // another method is: Integer.toString(int)
        String hashKey = String.valueOf(index1) + String.valueOf(index2);

        if (!memo.containsKey(hashKey)){
        
            int deleteOP = 1 + findMinOperatin(s1,s2, index1, index2+1, memo);
            int insertOP = 1 + findMinOperatin(s1,s2, index1+1,index2, memo);
            int replaceOP = 1+ findMinOperatin(s1,s2, index1+1, index2+1, memo);

            int minOP = Math.min(deleteOP, Math.min(insertOP, replaceOP));

            memo.put(hashKey, minOP);
        }

        return memo.get(hashKey);

    }

    public int findMinOperation(String s1, String s2){
        HashMap<String, Integer> memo = new HashMap<>();

        return findMinOperation(s1, s2, 0, 0, memo);
    }


    // Bottom-Up Tabulation 
    public int findMinOperation(String s1, String s2){
        // simple approach with one direction
        
        int i = 0, j = 0;

        while(i<s1.length() || j<s2.length){
            
            if(s1.charAt(i) != s2.charAt(j)){

                if 
                


            }

            ++i; ++j;

        }


    }


    

    public static void main(String[] args) {
        
        ConvertOneStringToAnother cs = new ConvertOneStringToAnother();

        System.out.println(cs.findMinOperation("table", "tbres")); // 3 operations.
        System.out.println(cs.findMinOperation("catch", "carch")); // 1 operation.
    }


}
