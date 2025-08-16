// Question1 :  You are given an array arr consisting only of Os, 1s, and 2s. 
// The task is to sort the array in increasing order in linear time (i.e., O(n)) without using any extra space. 
// This means you need to rearrange the array in-place.

public class Sortingarray {
    public static void sortnum(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0)
            {
                // Swaping arr[low] and arr[mid], increment both low and mid 
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                   
            }   else if(arr[mid] == 1 )  {
                     // move mid forward
                    mid++;
                    
                }else {
                    // Swaping arr[mid] and arr[high], decrement high
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    
                }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,1,0,2,1,0};
        sortnum(arr);
        System.out.print("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");

        }
    }
}
