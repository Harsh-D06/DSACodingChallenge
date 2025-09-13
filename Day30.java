//Problem30: The Coin Change Problem
//You are given an integer array coins[] of size n, where each element represents the denomination of a coin. 
//You are also given an integer amount, representing the total amount of money. The task is to find the minimum number of coins required to make up the given amount.
//If the amount cannot be formed by any combination of the coins, return -1.
//You can assume that you have an infinite supply of each denomination.

//Input :
//An integer array coins[] where each element represents the value of a coin.
//An integer amount representing the total amount of money.
//coins = [1, 2, 5], amount = 11

import java.util.Arrays;
class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] will store the minimum number of coins to make change for amount i.
        // Initialize dp array with amount + 1, a value larger than any possible result,
        // to represent infinity.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // Base case: 0 coins are needed to make an amount of 0.
        dp[0] = 0;

        // Iterate through each amount from 1 to the target amount.
        for (int i = 1; i <= amount; i++) {
            // For each amount, iterate through each coin denomination.
            for (int coin : coins) {
                // If the current amount i is greater than or equal to the coin's value,
                // we can potentially use this coin.
                if (i >= coin) {
                    // The minimum number of coins for amount i is the minimum of:
                    // 1. The current value in dp[i].
                    // 2. 1 (for the current coin) + the minimum coins needed for the remaining
                    //    amount (i - coin).
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        // After the loops, dp[amount] holds the minimum number of coins.
        // If dp[amount] is still greater than the initial amount, it means
        // the amount cannot be formed by the given coins. In this case, we
        // return -1. Otherwise, we return the value from dp[amount].
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
public class Coin_Change {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println("Input: coins = " + Arrays.toString(coins) + ", amount = " + amount);
        System.out.println("Output: " + solution.coinChange(coins, amount));
    }
}
