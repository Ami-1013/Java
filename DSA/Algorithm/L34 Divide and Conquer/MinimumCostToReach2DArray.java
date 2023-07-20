



public class MinimumCostToReach2DArray {

    private int findMinCost(int[][] costArr, int row, int col){

        if (row == -1 || col == -1){
            return Integer.MAX_VALUE;
            /*  This eliminate the posibility if row or col goes beyond 0 (i.e negative).
                It return the Integer.MAX_VALUE which will be always greater than the other values.
                Hence it will get eleiminated at Math.min(opt1,opt2).

             */
        }

        if (row == 0 && col == 0){
            return costArr[row][col];
        }

        // 2 sub problems

        int opt1 = findMinCost(costArr, row-1, col);
        int opt2 = findMinCost(costArr, row, col-1);

        return costArr[row][col] + Math.min(opt1, opt2);
    }

    public int findMinCost(int[][] costArr){
        return findMinCost(costArr, costArr.length-1, costArr[0].length-1);
    }


    public static void main(String[] args) {
        
        MinimumCostToReach2DArray mc = new MinimumCostToReach2DArray();

        int[][] costArr = {
                    {4,7,8,6,4},
                    {6,7,3,9,2},
                    {3,8,1,2,4},
                    {7,1,7,3,7},
                    {2,9,8,9,3}
                                };

        System.out.println(mc.findMinCost(costArr));
        // ans: 36


    }
        
    

}
