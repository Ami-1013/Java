
import java.util.HashMap;

public class FibonacciMemoziation {

    // Using Memoziation 
    public int fibMemo(int n, HashMap<Integer, Integer> memo){
        if (n == 1 || n == 2){
            return n-1;
        }

        if (!memo.containsKey(n)){
            memo.put(n, (fibMemo(n-1, memo) + fibMemo(n-2, memo)));
            // The operation will be done in only one HashMap compiler does'nt create a new HashMap but simply
            // pass its reference.
        }

        return memo.get(n);
        // t.c - O(n)  &    s.c - O(N)
    }

    public static void main(String[] args) {
        
        HashMap<Integer, Integer> memo = new HashMap<>();

        FibonacciMemoziation fm = new FibonacciMemoziation();
        System.out.println(fm.fibMemo(6, memo));
    }
}
