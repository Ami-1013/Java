

public class ZeroOneKnapsackProb {
    
    private int knapSack(int[] profits, int[] weights, int capacity, int currentIndex){

        if (capacity <= 0 || currentIndex <0 || currentIndex >= profits.length){
            return 0;
        }

        int profit1 = 0;

        if (weights[currentIndex] <= capacity){
            profit1 = profits[currentIndex] + 
                    knapSack(profits, weights, capacity - weights[currentIndex], currentIndex +1);
            // current weight is included.
        }

        // current weight is not included.
        int profit2 = knapSack(profits, weights, capacity, currentIndex +1);
        // first a patter is formed then it is filled in reverse when end is reached.

        return Math.max(profit1, profit2);

    }

    public int knapSack(int[] profits, int[] weights, int capacity){
        return knapSack(profits, weights, capacity, 0);
    }


    // Main method
    public static void main(String[] args) {
       
        ZeroOneKnapsackProb ks = new ZeroOneKnapsackProb();

        int profits[] = {31,26,72,17};
        int weights[] = {3,1,5,2};

        int maxProfit = ks.knapSack(profits, weights, 7);
        System.out.println(maxProfit);
        
    }
}
