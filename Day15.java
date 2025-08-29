//Problem15:  Find the Longest Substring Without Repeating Characters
// You are given a string S, and your task is to find the length of the longest substring that contains no repeating characters. 
//A substring is a contiguous block of characters in the string.
// In this problem, you need to find the length of the longest substring where all the characters are unique. 
//The substring can be formed by starting at any position in the string, but it must not contain any repeated characters.

// Input :
// * A string S, where 1≤∣S∣≤105(length of string).
// * Input: S = "abcabcbb"

public class LUSS {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[256]; // Assuming ASCII
            int currLen = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (visited[c]) {
                    break;
                } else {
                    visited[c] = true;
                    currLen++;
                }
            }
            if (currLen > maxLen) {
                maxLen = currLen;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String S = "abcabcbb";
        System.out.println("Strings without repeating in total are: "+lengthOfLongestSubstring(S)); // Output: 3
    }
}
