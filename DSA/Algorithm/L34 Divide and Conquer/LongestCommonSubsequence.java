

public class LongestCommonSubsequence {
    
    private int findLCS(String s1, String s2, int index1, int index2){

        int c1=0;
        int c2=0;
        int c3=0;

        if (index1 == s1.length() || index2 == s2.length()){
            return 0;
        }

        else if (s1.charAt(index1) == s2.charAt(index2)){
           c1 = 1 + findLCS(s1, s2, index1+1, index2+1);
        }

        else{
             c2 = findLCS(s1, s2, index1+1, index2);
             c3 = findLCS(s1, s2, index1, index2+1);
        }

        return Math.max(c1, Math.max(c2,c3));
    }

    public int findLCS(String s1, String s2){
        return findLCS(s1, s2, 0, 0);
    }

    public static void main(String[] args) {
        
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.findLCS("elephant", "erepat"));
        System.out.println(lcs.findLCS("abcdef", "abcf"));
    }

}



