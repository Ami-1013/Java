/*      Divide and Conquer

- It is an algo design paradigm which work by recursively breaking down a problem into subprobles of similar
  type, until this become simple enough to be solved directly. The solution to the sub problems are then 
  combined to give a solution to the original problem.

- Property
  1- Optimal substurcture: If any problem's overall optimal solution can be constructed from the optimal 
            solutions of its subproblems then this problem have optimal substructure.


- Main points:
  In recursion and divide and conquer 2 points are crucial.
  i- The different base condition(can be more than 1).
  ii- The formula of recursive calls.

*/

/*  

Q1- Given N, find the number of ways to express N as the sum of 1,3, and 4.

Q2- 
    
*/



import dacProb.NumberFactor;

import dacProb.HouseRobber;

public class L34_Divide_and_Conquer {

    public static void main(String[] args) {
        
        //  Sol 1

        /*      
        NumberFactor nf = new NumberFactor();
        System.out.println(nf.waysToGetN(4));
        System.out.println(nf.waysToGetN(5));
        System.out.println(nf.waysToGetN(6));

        */

        //  Sol 2
        
        HouseRobber hr = new HouseRobber();
        int[] houseWorth = {6,7,1,30,8,2,4};

        System.out.println(hr.maxMoney(houseWorth));



    }
}
