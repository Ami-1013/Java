import java.util.ArrayList;

public class FibonacciTabulation {

    // using Tabulatin
    public static int fibTab(int n){
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(0);
        arrList.add(1);

        for (int i=2; i<n; ++i){
            arrList.add(arrList.get(i-1) + arrList.get(i-2));
        }

        return arrList.get(n-1);

        // t.c - O(n)  &    s.c - O(N)

    }

     
    public static void main(String[] args) {
        System.out.println(fibTab(5));
        System.out.println(fibTab(6));
    }
    
}
