

// By using (1,3,4) to find fator of number

public class NumberFactor {
    
    // Using Top-down Memoization Dp
    private int waysToGetTD(int n, int[] memo) {

        if (n==0 || n==1 || n==2){
            return 1;  // 1 way
        }

        if (n==3){
            return 2; // due to this n can't go negative
        }

        if (memo[n] == 0){   // default value of int[] array is zero. The min value in memo is 1.
            int sp1 = waysToGetTD(n-1, memo);  // sp = sub problem.
            int sp2 = waysToGetTD(n-3, memo);
            int sp3 = waysToGetTD(n-4, memo);
            
            memo[n] = sp1 + sp2 + sp3;
        }

        return memo[n];
    }
    
    public int waysToGetTD(int n){
        int[] memo = new int[n+1]; // n+1, because NumberFactor starts with 0 to n, so we need n+1 cells.
        
        return waysToGetTD(n, memo);
    }

    // Bottom-Up Tabulation approach
    public int waysToGetBU(int n ){

        if (n==0 || n==1 || n==2) return 1;

        int[] tab = new int[n+1];

        tab[0] = tab[1] = tab[2] = 1; // initializing intial values.
        tab[3] = 2; // 2 ways

        for(int i=4; i<n+1; ++i){

            tab[i] = tab[i-1] + tab[i-3] + tab[i-4]; // 1,3,4 are give number factors.
            // Logic of for loop(starting from 4) and value of tab[3] helps to avoid "i" going to negative
        }

        return tab[n];
    }


    public static void main(String[] args) {
        
        NumberFactor nf = new NumberFactor();

        System.out.println("******** Memoization ****************");
        System.out.println(nf.waysToGetTD(0)); // 1 way
        System.out.println(nf.waysToGetTD(5)); // 6 ways
        

        System.out.println("\n ******** Tabulation ***********");
        
        System.out.println(nf.waysToGetBU(0)); // 1 way
        System.out.println(nf.waysToGetBU(3)); // 2 ways
        System.out.println(nf.waysToGetBU(5)); // 6 ways
    }


}
