

class Node{
    int value;
    Node ref;

    public Node(int value){
        this.value = value;
    }
}



public class NumberFactorAdvanceSol {
    
    private static int maxMoneyRecursive(Node[] houses, int currentIndex){
        if (currentIndex >= houses.length){
            return 0;
        }

        // main logical condition
        int stealCurrentHouse = houses[currentIndex].value + maxMoneyRecursive(houses, currentIndex + 2);
        int skipCurrentHouse = maxMoneyRecursive(houses, currentIndex + 1); 

        int max =  Math.max(stealCurrentHouse, skipCurrentHouse);

        
        if (currentIndex - 2 >-1){

            if (max == stealCurrentHouse){
                houses[currentIndex - 2].ref = houses[currentIndex];

            }

            else{
                // because we are leaving currentIndex and going to next index
                houses[currentIndex - 2].ref = houses[currentIndex + 1];
            }

            /*      Logic for House number printing

            - Due to above if condition this function will return max value and add to reference to node.
            - But as this function run every possibility for max value and smartly eliminate several 
              possibility that can't be answer.

            - So at end it will return two path(best for that position) starting from position 0th and 
              1st index.
                    ex - 6 -> 30 -> 4
                         7 -> 30 -> 4

              However reference won't effected even if these 2 path have some common node(ie 30)
              because node have reference of "child", not parent.
                ie 30 parent can be only 1 node but 30 can be child of more than 1 node.
              
              Even if these two path have common node then this 2 path will be same from that node.

            */

        }
        return max;
    }

    
    public static int maxMoney(Node[] houses){

        int getMaxMoney = maxMoneyRecursive(houses, 0);
        
        Node node = houses[0];
        int firstNodeSum = 0;

        while (node != null){
            firstNodeSum += node.value;
            node = node.ref;
        }

        if (getMaxMoney == firstNodeSum){
            node = houses[0];
        }

        else{
            node = houses[1];
        }

        System.out.print("Sequence of House Robbering:  " );
        while(node!=null){
            System.out.print(node.value + " ");
            node = node.ref;
        }
        
        System.out.println();

        return getMaxMoney;
    } 

        


    public static void main(String[] args) {
    
        int[] nums = {6,7,1,30,8,2,4};

        Node[] house = new Node[7];

        for (int i=0; i<house.length; ++i){
            house[i] = new Node(nums[i]); 
        }

       System.out.println(maxMoney(house));

    }
}
