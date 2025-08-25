//Problem11 : Permutations of a String
// You are given a string s. Your task is to generate and return all possible permutations of the characters in the string. 
//A permutation is a rearrangement of the characters in the string, and each character must appear exactly once in every permutation. 
//If there are duplicate characters in the string, the resulting permutations should also be unique (i.e., no repeated permutations).

// Input :
// A string s consisting of lowercase English letters. The length of the string n satisfies 1≤𝑛≤9.
// Input: "abc"

import java.util.*;
public class StringPermutations {
    public static Set<String> getPermutations(String str) {
        Set<String> result = new HashSet<>();
        permute(str, "", result);
        return result;
    }
        private static void permute(String str, String prefix, Set<String> result) {
        if (str.length() == 0) {
            result.add(prefix);
            return;
        }
          for (int i = 0; i < str.length(); i++) {
            String remaining = str.substring(0, i) + str.substring(i + 1);
            permute(remaining, prefix + str.charAt(i), result);
        }
    }
        public static void main(String[] args) {
        String input = "abcd";
        Set<String> permutations = getPermutations(input);
        System.out.println("The result permutations are:\n"+ permutations);
    }
}
