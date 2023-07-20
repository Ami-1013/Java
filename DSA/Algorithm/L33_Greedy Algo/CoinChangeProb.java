package greedyProb;

import java.util.Arrays;

public class CoinChangeProb {
        
    public static void coinChangeProblem(int[] coins, int totalValue){
        Arrays.sort(coins); // t.c - NLog(N)
        int index = coins.length-1;

        while (true){
            int coinValue = coins[index];
            index --;

            int maxAmount = (totalValue/coinValue)*coinValue; // number of time coinValue that can be substracted
            // from totalValue.

            // if maxAmout is > 0, then there will be coin change, if it is = 0, then no coin change as the 
            // coinValue is too big.
            if (maxAmount > 0){
                System.out.println("Coin value: "+ coinValue + ", Taken:" + (totalValue/coinValue));
                totalValue = totalValue - maxAmount;
            }
            if (totalValue==0) break;
        }

    }

    // t.c - NLog(N) &  s.c - O(1)
}
