


public class NumberOfPathToReachLastCell {

    private int numberOfPath(int[][] arr, int row, int col, int cost){
        
        if (cost<0) return 0;
        // we return number of ways. Adding 0 to number of ways won't effect the answer.
        
        if (row == 0 && col == 0){
            return (arr[0][0] == cost)? 1:0;
            // arr[0][0] - cost == 0, return 1 if true, else 0
        }

        if (row == 0){
            return numberOfPath(arr, 0, col-1, cost - arr[0][col]);
        }

        if (col == 0 ){
            return numberOfPath(arr, row-1, 0, cost - arr[row][0]);
        }


        int numberOfPathsFromCol = numberOfPath(arr, row, col-1, cost - arr[row][col]);
        int numberOfPathsFromRow = numberOfPath(arr, row-1, col, cost - arr[row][col]);
        

        return numberOfPathsFromCol + numberOfPathsFromRow;

    }

    public int numberOfPath(int[][] arr, int cost){
        return numberOfPath(arr,arr.length-1, arr[0].length-1, cost);
    }

    public static void main(String[] args) {
        
        int[][] arr = {
                    {4,7,1,6},
                    {5,7,3,9},
                    {3,2,1,2},
                    {7,1,6,3}
                };

        int cost = 25;

        NumberOfPathToReachLastCell np = new NumberOfPathToReachLastCell();
        
        System.out.println(np.numberOfPath(arr,cost));
        // ans: 2 ways

    }
    
}
