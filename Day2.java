// Question2 : You are given an array arr containing n-1 distinct integers. The array consists of integers taken from the range 1 to n, 
//meaning one integer is missing from this sequence. Your task is to find the missing integer.

// Input:
// An integer array arr of size n-1 where the elements are distinct and taken from the range 1 to n.
// Example : arr = [1, 2, 4, 5]

// Output:
// Return the missing integer from the array.
// Example: Missing number: 3


// The code can be solved in methods : 1.  Sum n natural numbers , Subtract sum of array from the total sum.
// 2. Using  XOR method :  this helps for large data input. 
import java.util.Scanner;

public class MissingNumber {

    public static int findMissingNumber(int[] arr, int n) {
        int total = n * (n + 1) / 2;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }  
        return total - sum;  // subtracting the actual sum from the total to find the missing number 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Taking user-input 
        System.out.print("Enter value of n (size of full sequence): ");
        int n = sc.nextInt();

        int[] arr = new int[n - 1];   //holds an array n-1 since one number is missing 
        System.out.println("Enter " + (n - 1) + " elements:");

        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }

        int missing = findMissingNumber(arr, n);
        System.out.println("Missing number is: " + missing);
    }
}
