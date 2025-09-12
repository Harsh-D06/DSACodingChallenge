//Problem29: Fibonacci Sequence using Dynamic Programming
//You are given an integer n. Your task is to calculate the n-th Fibonacci number using Dynamic Programming.

//Input : A single integer n (0 ≤ n ≤ 1000)
//Input : 5

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    // Memoization approach (Top-Down Dynamic Programming)
    private static Map<Integer, Long> memo = new HashMap<>();

    public static long fibonacciMemo(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        long result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        memo.put(n, result);
        return result;
    }

    // Tabulation approach (Bottom-Up Dynamic Programming)
    public static long fibonacciTab(int n) {
        if (n <= 1) {
            return n;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    // Optimized Tabulation (Space-Optimized)
    public static long fibonacciSpaceOpt(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0;
        long b = 1;
        long c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
       public static void main(String[] args) {
        int n = 5;

        // Example using Memoization
        long resultMemo = fibonacciMemo(n);
        System.out.println("Fibonacci (Memoization) of " + n + " is: " + resultMemo);

        // Example using Tabulation
        long resultTab = fibonacciTab(n);
        System.out.println("Fibonacci (Tabulation) of " + n + " is: " + resultTab);

        // Example using Space-Optimized Tabulation
        long resultSpaceOpt = fibonacciSpaceOpt(n);
        System.out.println("Fibonacci (Space-Optimized) of " + n + " is: " + resultSpaceOpt);
    }
    }
