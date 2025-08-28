//Problem14 :  Count Substrings with Exactly K Distinct Characters
// You are given a string s of lowercase English alphabets and an integer k. Your task is to count all possible substrings of s that contain exactly k distinct characters.

// Input:
// A string s consisting of lowercase English letters.
// An integer k, where 1 ≤ 𝑘 ≤ 26
// The length of the string satisfies 1 ≤ 𝑛 ≤ 104


import java.util.*;

public class Count_SS{
    // Function to count substrings with at most k distinct characters
    static int count(String s, int k) {
        int ans = 0;
        int[] freq = new int[26];
        int distinctCnt = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            freq[s.charAt(j) - 'a']++;
            if (freq[s.charAt(j) - 'a'] == 1) distinctCnt++;

            while (distinctCnt > k) {
                freq[s.charAt(i) - 'a']--;
                if (freq[s.charAt(i) - 'a'] == 0) distinctCnt--;
                i++;
            }
            ans += j - i + 1;
        }

        return ans;
    }  // Function to count substrings with exactly k distinct characters
    static int countSubstr(String s, int k) {
        return count(s, k) - count(s, k - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = scanner.nextLine().toLowerCase();

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        int result = countSubstr(s, k);
        System.out.println("Number of substrings with exactly " + k + " distinct characters: " + result);

        scanner.close();
    }
}
