//Problem18:  Count the Number of Divisors of a Number
// Given a positive integer N, your task is to find the total number of divisors (factors) of N.
//A divisor of N is any integer that divides N without leaving a remainder.
// A divisor of a number is any integer that divides the number evenly (i.e., without a remainder). 
//For example, for N = 12, its divisors are 1, 2, 3, 4, 6, 12, so the total number of divisors is 6.

// Input :
// A single integer N, where 1≤N≤109
// N = 12

public class DivisorCounter {
    public static int countDivisors(int n) {
        if (n <= 0) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            // Check if i is a divisor of n.
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
        public static void main(String[] args) {
        int N = 997;
        int numberOfDivisors = countDivisors(N);
        System.out.println("The number of divisors for N :" + N + " is: " + numberOfDivisors);
    }
}
