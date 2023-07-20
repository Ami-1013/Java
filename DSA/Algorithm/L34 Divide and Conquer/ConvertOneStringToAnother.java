

public class ConvertOneStringToAnother {
    
    private int findMinOperatinos(String s1, String s2, int index1, int index2){
        
        if (index1 == s1.length()){
            return s2.length() - index2;
            // rest all delete operation
        }

        if (index2 == s2.length()){
            return s1.length() - index1;
            // rest all insert operation.
        }

        if (s1.charAt(index1) == s2.charAt(index2)){
            return findMinOperatinos(s1, s2, index1 +1, index2 +1);
        }
    
        // Operation on "s2" regarding "s1"

        // one of them will be most efficient. This all 3 will run irrespect of their result.
        int deleteOp = 1 + findMinOperatinos(s1, s2, index1, index2+1);
        int insertOp = 1 + findMinOperatinos(s1, s2,  index1 +1, index2);
        int replaceOp = 1 + findMinOperatinos(s1, s2, index1+1, index2+1);

        return Math.min(deleteOp, Math.min(insertOp, replaceOp));
    }
    
    public int findMinOperatinos(String s1, String s2){
        return findMinOperatinos(s1, s2, 0, 0);
    }


    public static void main(String[] args) {
        
        ConvertOneStringToAnother cs = new ConvertOneStringToAnother();
        System.out.println(cs.findMinOperatinos("table", "tbres"));
    }


}
