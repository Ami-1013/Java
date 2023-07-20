package dacProb;

/*      Logic

- Robber can move in two ways 
    1- rob the current house
    2- leave the current house and rob the next house

    Then, After selecting house of robbing, it can chose next target in 2 ways
        1- Second house from current house
        2- Third house from current house.

    Now, in algo right path of houses can't be choosed until last house is reached as every possibility of 
    choosing right path is uncertain as every path value get manupilated by the next house(to be robbed).

    Hence a correct path can't be choosed until last house has been reached in algo(end of manupilation of
    value). 

    Thatswhy last house is significant which finalize the final paths value. 

    LOGICALL SENSE approach is from end -> start(reverse checking)
*/

public class HouseRobber {

    private int maxMoneyRecursive(int[] houses, int currentIndex){
        if (currentIndex >= houses.length){
            return 0;
        }

        int stealCurrentHouse = houses[currentIndex] + maxMoneyRecursive(houses, currentIndex + 2);
        int skipCurrentHouse = maxMoneyRecursive(houses, currentIndex + 1); 

        return Math.max(stealCurrentHouse, skipCurrentHouse);
    }
    
   public int maxMoney(int[] houses){
        return maxMoneyRecursive(houses, 0);
    } 
    
    
}
