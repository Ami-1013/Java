/*          Greedy Aglo

- It is an algo paradigm that builds the solution piece by piece.
- In each steps it chooses the piece that offers most obvious and immediate benefit.
- It fits perfectly for those solutions in which local optimal solutions lead to global solution.
 

 */

/* ******************************Documents and Settings
Q1- Activity section problem
sol- 1- Sort activity based on finished time.
     2- Select first activity from the sorted array and print it.
     3- for all remaining activity:
        if the start time of this activity is greater or equal to the finish time of previously selected activity
        then select this activity and print it.

Q2- Coin change problem
sol- 1- Find the biggest coin that is less than given total number
     2- Add coin to the result and subtract coin from total number
     3- If V is equal to zero:
            then print result
        esle 
            repeat step 1 & 2

Q3- Fractional Knapsack Problem
sol- 1- Calculate the value per kilogram for each item
     2- Sort item based on this ratio.
     3- Take item with the hightest ratio sequentially until weight allows
     4- Add next item as much(fraction) as we can.

*/


import java.util.ArrayList;
import java.util.Arrays;

import greedyProb.Activity;
import greedyProb.ActivitySelection;

import greedyProb.CoinChangeProb;

import greedyProb.KnapsackItem;
import greedyProb.FractionalKnapsack;


public class L33_Greedy_Algo {
    public static void main(String[] args) {
        
        //  Q1- Activity prob sol
    /*  
     
        ArrayList<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity("A1", 0, 6));
        activityList.add(new Activity("A2", 3, 4));
        activityList.add(new Activity("A3", 1, 2));
        activityList.add(new Activity("A4", 5, 8));
        activityList.add(new Activity("A5", 5, 7));
        activityList.add(new Activity("A6", 8, 9));

        ActivitySelection.activitySelection(activityList);
    */
    
    // Q2- Coin Change Prob   
    
        /*      

        int[] coins = {1,2,5,10,20,50,100,1000};
        int amount = 2035;

        System.out.println("Coins available: " + Arrays.toString(coins));
        System.out.println("Target amount: " + amount);

        CoinChangeProb.coinChangeProblem(coins,amount);    

        */

    // Q3- Factional Knapsack Prob
        
        ArrayList<KnapsackItem> items = new ArrayList<>();

        int[] value = {100, 120, 60};
        int[] weight = {20, 30, 10};

        int capacity = 50;

        for (int i=0; i<value.length; i++){
            items.add(new KnapsackItem(i+1, value[i], weight[i]));
        }

        FractionalKnapsack.knapsack(items, capacity);
        

    }
}



