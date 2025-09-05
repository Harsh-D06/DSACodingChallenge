//Problem22: First Element to Repeat k Times
//You are given an array of integers and an integer k. Your task is to find the first element in the array that appears exactly k times. If no such element exists, return -1.

// Input:
// An integer array arr of size n, where 1≤n≤105
// An integer k, where 1≤k≤n

import java.util.HashMap; 
public class FirstKRepeater  {
    public static int findKRepeater (int arr[], int k) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int num =  arr[i];
            int Count =  countMap.getOrDefault(num, 0 ) +1;
            countMap.put(num , Count);
            
            if (Count  == k) {
                countMap.put(-num, 1);
            }
            
            if (Count > k) {
                countMap.remove(-num);
            }
        }
            for (int i=0; i<arr.length; i++) {
            int num = arr[i];
             if (countMap.containsKey(-num)) {
                return num;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
	    int arr[] = {6, 6, 6, 6, 7, 7, 8, 8, 8};
	    int k = 2;
	    int result = findKRepeater(arr, k);
		System.out.println("First element to appear exactly " +k+ " times is:  "+ result);
	}
}
