//Problem4 : Problem : Merge Two Sorted Arrays
// You are given two sorted arrays arr1 of size m and arr2 of size n. 
// Your task is to merge these two arrays into a single sorted array without using any extra space (i.e., in-place merging). 
// The elements in arr1 should be merged first, followed by the elements of arr2, resulting in both arrays being sorted after the merge.



// Sorting 2 array without adding 3rd array  and merging it
import java.util.*;
import java.util.Arrays;
public class SortArray {
    public static void Merging(int arr1[], int arr2[]) {
        int m = arr1.length ;
        int n = arr2.length;

        int i = m - 1;      //Start from end of arr1
        int j = 0;      //Start from beginning  of arr2
        
        //Swaping elements and checking 
        while(i>=0 && j < n) {
            if(arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j] ;
                arr2[j] = temp ;
            }
            i--;
            j++;
        }

        //Sorting the array into correct order
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        //Array1 
        System.out.print("Enter size of array m : ");
        int m = sc.nextInt();
        int arr1[] = new int[m];
        System.out.print("Enter "+m+" arrays: ");
        for(int i =0; i<m; i++ ){
            arr1[i] = sc.nextInt();
        }
        
        //Array2
        System.out.print("Enter size of array n :");
        int n = sc.nextInt();
        int arr2[] = new int[n];
        System.out.print("Enter "+n+" arrays: ");
        for(int i =0; i<n; i++ ){
            arr2[i] = sc.nextInt();
        }
        Merging(arr1, arr2);

        System.out.println("Merged arr1: "+Arrays.toString(arr1));
        System.out.println("Merged arr2: "+Arrays.toString(arr2));
    }
}
