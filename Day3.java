// Problem3 : Find the Duplicate Number You are given an array arr containing n+1 integers, where each integer is in the range [1, n] inclusive. 
//There is exactly one duplicate number in the array, but it may appear more than once. 
//Your task is to find the duplicate number without modifying the array and using constant extra space.

import java.util.*;

public class FindingDuplicate {

    public static int Duplicate(int[] nums) {
        int slow = nums[0]; //  slow pointer starts at first element
        int fast = nums[0]; // fast pointer starts at first element

        // Phase 1: Detect cycle
        do {
            slow = nums[slow];         // moves one step
            fast = nums[nums[fast]];   // moves two steps
        } while (slow != fast);        

        // Phase 2: Find entry point of cycle (duplicate)
        slow = nums[0];   

        while (slow != fast) {
            slow = nums[slow]; //  moves one step
            fast = nums[fast]; //  moves one step
        }

        return slow; // returns duplicate number
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        int[] arr = new int[n + 1];

        System.out.println("Enter " + (n + 1) + " elements in range 1 to " + n + ":");

        for (int i = 0; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }

        int Fduplicate = Duplicate(arr);
        System.out.println("Duplicate number is: " + Fduplicate);
    }
}
