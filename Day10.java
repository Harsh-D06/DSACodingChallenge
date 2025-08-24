//Problem10 : Group Anagrams
// You are given an array of strings strs[]. Your task is to group all the strings that are anagrams of each other.
//An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//The goal is to return the grouped anagrams as a list of lists, where each sublist contains words that are anagrams of each other.

import java.util.*;
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Sort the word to get the key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            // Group by sorted key
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
      return new ArrayList<>(map.values());
    }
      public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);
         for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
