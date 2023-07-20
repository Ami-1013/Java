/*      
Big O
- Big O is a language and metric used to describe the efficiency of an algorithm.
- It is defined as upper bound and upper bound is the most amount of time required by a algorithm.{Worst case}

Big Ω (Big Omega)
- It is defined as lower bound and lower bound is the least amount of time required by algorithm. {Best case}

Big θ (Big Theta)
- It is the complexity that is within the bound of worst and best case. {Average case}


Time Complexity
- A way of showing how the runtime of a function increase as the size of input increase.


-----------------------------------------------------
Some Common Complexity

1- Constant time O(1) - The time required is same as the size of program grow. Ex- Accessing a specify element in array.
2- Linear time O(N) - The time is increase linearly as the size of program grow. Ex- Looping through an array.
3- Logarithmic time O(LogN) - The time increase very slowly when size of program grow. Is is less than O(N). Ex- Binary Search.
                              2**3 = 8 , log8 = 3, where 2 is base of log.
 
4- Quadratic time O(N**2) - Its performance is directly proportional to square size of input/program. This occur when there is 
                            multiple iteration within the dataset or in nested statement. Ex- Looking for every index in an
                            array twice.

5- Exponential time O(2**N) - It grow double with the size of input.

-----------------------------------------------------
Dropping Constant and Non dominant terms

    O(2N)  --> O(N)
    O(N + log(N))  --> O(N)

    As n -> infinity, the constant and non dominant are quite insignificant.

----------------------------------------------------
Add vs Multiply in algorithm

- If your algo in the form "do this, when you are all done, do that" then you add the runtime.
- If your algo in the form "do this for each time you do that" then you multiply the runtime.

----------------------------
assignment of a variable and if statement regardless of their size take O(1).
------------------------------------

Calculate the time complexity of every program.
- See in the video.

Complexity can be calculated by "iteration count" & "Average work". CH-6, vid-4
 
*/ 


public class L3_Big_O {
    public static void main(String[] args) {
        

    }
}
