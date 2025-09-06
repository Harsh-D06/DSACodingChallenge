//Problem23: Sliding Window Maximum
// You are given an array of integers arr and a positive integer k. Your task is to find the maximum element in each sliding window of size k.
// The window slides from left to right, one element at a time, and you need to return the maximum element for each of these windows.

// Input :
// * An integer array arr of size n, where 1≤n≤105
// * An integer k, where 1≤k≤n
// * Input: arr = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
// * Output: [3, 3, 5, 5, 6, 7]

import java.util.*;
public class SlidingWindowMax {
    public static int[] findMaxInWindows(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            //1. Remove indices outside the window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 2. Remove smaller elements from the back
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            // 3. Add current index
            deque.offerLast(i);

            // 4. Record max once window is full
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] output = findMaxInWindows(arr, k);
        System.out.print("Sliding Window Maximums: ");
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
