/*      Dynamic Programming (DP)

- Dynamic programming is a algorithmic technique for solving an optimization problem by breaking it down into 
  simpler subproblem and utilizing the fact that the optimal solution to the overall problem depends upon the 
  optimal solution to its subproblems.

- Dynamic programming is the optimization of "divide and conquer" (resursion).

- Two key points of DP
  1- Optimal Substructure(like divide and conquer):
        If any problem's overall optimal solution can be constructed from the optimal solution of its 
        subproblems then this problem has optimal solution.

  2- Overlapping subproblems:
        Subproblems are the smaller version of the original problem. Any problem has overlapping sub-problems
        if finding its solution involves the solving the same subproblem multiple times.

        This is the main point which decide that a "divide and conquer" problem can be solved using 
        dynamic programming. Ex- Merge sort which is divide & conquer algo can't be solved by using
        DP because subproblems don't overlap.


- Ways to solve
  1- Top Down with Memoization:
        Solve the bigger problem by recursively finding the solution to the smaller subproblems. Whenever we 
        solve a subproblem, we cache its result so that we don't end up solving it repeatedly if it is called
        multiple times.
        This technique of storing the results of already solved subproblems is called Memoization.

        Here we break problem from top to down and then start building solution from down to top.

  2- Bottom Up with Tabulation:
        Tabulation is opposite of Top Down approach and avoid "recursion". In this apporach, we solve the 
        problem "bottom-up"(i.e by solving all the related subproblem first). This is done by filling up a 
        table. Based on the results in the table, the solution to the top/original problem is then computed.


*/
