package greedyProb;

import java.util.*;
import greedyProb.KnapsackItem;

public class FractionalKnapsack {
    
    public static void knapsack(ArrayList<KnapsackItem> items, int capacity){

        Comparator<KnapsackItem> comparator = new Comparator<>(){

            @Override
            public int compare(KnapsackItem o1, KnapsackItem o2){
                if (o2.ratio > o1.ratio) return 1;
                else return -1;
            }
            // comparator for decending.
        };

        Collections.sort(items, comparator);

        int usedCapacity = 0;
        double totalValue = 0;

        for (KnapsackItem item: items){
            if (usedCapacity + item.weight <= capacity){
                usedCapacity += item.weight;
                System.out.println("Taken: " + item);
                totalValue += item.value;
            }
            else{
                int leftWeight = capacity - usedCapacity;
                double value = item.ratio * leftWeight;
                System.out.println("Taken item index: " + item.index+ ", obtain value: "+ value +
                        ", used weight: "+ leftWeight + ", ratio: " + item.ratio );
                usedCapacity += leftWeight;
                totalValue += value;
            }


            if (usedCapacity == capacity) break;
        }

        System.out.println("\nTotal value obtain: " + totalValue);

    }
}
