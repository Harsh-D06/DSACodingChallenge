//Problem6: Find All Subarrays with Zero Sum
// You are given an integer array arr of size n. Your task is to find all the subarrays whose elements sum up to zero. 
// A subarray is defined as a contiguous part of the array, and you must return the starting and ending indices of each subarray.


import java.util.Scanner;
public class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr) {
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];
                if (sum == 0) {
                    System.out.println("Subarray from index " + start + " to " + end);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Zero-sum subarrays:");
        findZeroSumSubarrays(arr);
    }
}
