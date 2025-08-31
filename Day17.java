//Problem17: Prime Factorization of a Number
//Given a positive integer N, your task is to find its prime factorization. Return a list of prime numbers that multiply together to give N.
//If N is prime, the output should be a list containing only N.
// Prime factorization is the process of breaking down a number into the set of prime numbers that, when multiplied together, result in the original number. 
//For example, if N = 18, its prime factors are [2, 3, 3] because 2×3×3=18.

// Input :
// * A single integer N, where 2≤N≤109
// * N = 18

import java.util.ArrayList;
class Prime_Factors {
    public static ArrayList<Integer> primeFactor(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Loop from 2 to n
        for (int i = 2; i <= n; i++) {
            
            while (n % i == 0 && n > 0) {
                result.add(i);
                
                // divide n by i to remove this factor
                n = n / i; 
            }
        }
        return result;
    } 
    public static void main (String[] args) {
        int n = 18;
        ArrayList<Integer> result = primeFactor(n);
        System.out.print("Prime_Factors of "+n+" are : ");
        for (int x : result ) {
            System.out.print(x + " ");
        }
    }
}
