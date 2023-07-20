
import java.util.HashMap;

public class HouseRobber {


    // using Top-Down Memoization
    // Array can also be used instead of HashMap
    private int maxHouseValue(int[] houses, int currentIndex, HashMap<Integer, Integer> memo){

        if (houses.length <= currentIndex){
            return 0;
        }

        if (!memo.containsKey(currentIndex)){

            int opt1 = houses[currentIndex] + maxHouseValue(houses, currentIndex+2, memo);
            int opt2 = 0 + maxHouseValue(houses, currentIndex +1, memo);

            memo.put(currentIndex, Math.max(opt1, opt2));
        }

        return memo.get(currentIndex);

    }

    public int maxHouseValue(int[] houses){
        HashMap<Integer, Integer> memo = new HashMap<>();

        return maxHouseValue(houses, 0, memo);

    }

    // Using Bottom-Up Tabulation approach
    public int maxHouseVauleBU(int[] houses){
        
        int[] maxArr = new int[houses.length + 2];
        // "maxArr" store the max values of cell by comparing previous cell max values. With continiuty
        // max value also increase and total max value is stored at last cell.
        // There maxHouseValue is at index 0.
    
        maxArr[houses.length] = maxArr[houses.length + 1] = 0;

        int currentCellMax = 0, previousCellMax = 0;

        for (int i=houses.length-1; i>=0; --i){
            
            currentCellMax = houses[i] + maxArr[i+2];
            previousCellMax = maxArr[i+1];
            
            maxArr[i] = Math.max(currentCellMax, previousCellMax);
            // System.out.println(maxArr[i]);

        }

        return maxArr[0];

    }





    public static void main(String[] args) {
        
        HouseRobber hr = new HouseRobber();
        int[] houses = {6,7,1,30,8,2,4};

        System.out.println("*****  Memoization *******");
        System.out.println(hr.maxHouseValue(houses)); // ans 41
        
        
        System.out.println("\n ****** Tabulation ***********");
        System.out.println(hr.maxHouseVauleBU(houses));
    }



}
