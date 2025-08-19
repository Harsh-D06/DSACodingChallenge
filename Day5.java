//Problem5 : You are given an integer array arr of size n. 
//An element is considered a leader if it is greater than all the elements to its right.
//Your task is to find all such leader elements in the array.


//Finding the leader in an array 
import java.util.*;

public class Leader {
    public static void printLeaders(int arr[]){
        int n = arr.length;
        int maxFromright = arr[n-1];
        System.out.print("Leaders: "+ maxFromright + " ");

        for (int i = n-2; i>=0; i--) {
            if (arr[i]>maxFromright) {
                maxFromright = arr[i];
                System.out.print(maxFromright+" ");
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the elements: ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
                }
        
        printLeaders(arr);     
        sc.close();
    }
}
