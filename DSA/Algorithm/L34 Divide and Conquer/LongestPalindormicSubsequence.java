


public class LongestPalindormicSubsequence {

    private int findLPS(String s, int startIndex, int endIndex){

        // base conditions
        if (startIndex > endIndex){
            return 0;
        }

        if (startIndex == endIndex){
            return 1;
        } 

        int count1 = 0;

        if (s.charAt(startIndex) == s.charAt(endIndex)){
            count1 = 2 + findLPS(s, startIndex+1, endIndex-1);
        }

        int count2 = 0 + findLPS(s, startIndex+1, endIndex);
        int count3 = 0 + findLPS(s, startIndex, endIndex-1);

        return Math.max(count1, Math.max(count2, count3));
    }

    public int findLPS(String s){
        return findLPS(s, 0, s.length()-1);
    }




    public static void main(String[] args) {
        
        LongestPalindormicSubsequence lps = new LongestPalindormicSubsequence();
        System.out.println(lps.findLPS("elrmenmet"));

    }
}
