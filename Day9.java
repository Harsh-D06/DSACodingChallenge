//Problem9 : Longest Common Prefix
// You are given an array of strings strs[], consisting of lowercase letters. 
//Your task is to find the longest common prefix shared among all the strings. If there is no common prefix, return an empty string "".
// A common prefix is a substring that appears at the beginning of all the strings in the array. The task is to identify the longest such prefix that all strings share.

import java.util.Scanner;
public class LongestCommonPrefix {
    public static String findLCP(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder prefix = new StringBuilder();
        // Loop through characters of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);

            // Compare this character with the same position in all other strings
            for (int j = 1; j < strs.length; j++) {
                // If index exceeds or mismatch found, return current prefix
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return prefix.toString();
                }
            }
            // If character matched in all strings, append to prefix
            prefix.append(currentChar);
        }
            return prefix.toString();   //to.String() :  converts an object into a readable string format
    }  
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] input = new String[n];
        System.out.println("Enter the strings one by one:");
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
        }
        String result = findLCP(input);
        System.out.println("Longest Common Prefix: " + result);
    }
}
