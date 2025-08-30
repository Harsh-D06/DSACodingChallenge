//Problem16: LCM (Least Common Multiple) of Two Numbers

// You are given two integers, N and M. Your task is to find the Least Common Multiple (LCM) of these two numbers. \
//The LCM of two integers is the smallest positive integer that is divisible by both N and M.


import java.util.*;
class LCM {

    static int lcm(int a, int b) {
        
        // Larger value
        int g = Math.max(a, b); 
        
        // Smaller value
        int s = Math.min(a, b);

        for (int i = g; i <= a * b; i += g) {
            if (i % s == 0)
                return i;
        }
        return a * b; 
    }
    
    public static void main(String[] args) {
        int a = 10, b = 5;
        System.out.println(lcm(a, b)); 
    }
}
