//PRoblem : Problem : Trapping Rain Water
// You are given an array height[] of non-negative integers where each element represents the height of a bar in a histogram-like structure. 
//These bars are placed next to each other, and the width of each bar is 1 unit. When it rains, water gets 
//trapped between the bars if there are taller bars on both the left and right of the shorter bars. 
//The task is to calculate how much water can be trapped between these bars after the rain.

// Input :
// An integer array height[] where each element represents the height of a bar in the histogram.
// Example : 
// height[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]


public class RainWaterTrap {
  public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped Water: " + trap(height)); // Output: 6
    }
}
