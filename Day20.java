//Problem20:  Sort a Stack Using Recursion
// Given a stack of integers, your task is to write a function that sorts the stack in ascending order. 
//You are not allowed to use any additional data structure like arrays, lists, or another stack. 
//The only operations you are allowed to perform are push, pop, and peek on the stack. The sorting must be performed using recursion only.

// You need to recursively sort the stack, ensuring that after the sorting process, the stack remains sorted without using any additional data structures. 
// You can only use the stack's own operations and recursion to solve this problem.

// Input :
// A stack containing integers. The stack may have positive, negative, or zero values.
// Input: [3, 1, 4, 2]

import java.util.Stack;
public class SortStackRecursively {
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Step 1: Remove the top element
            int top = stack.pop();

            // Step 2: Recursively sort the remaining stack
            sortStack(stack);

            // Step 3: Insert the top element back in sorted order
            insertInSortedOrder(stack, top);
        }
    }

    // to insert an element into the sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // to check if stack is empty or top element is less than or equal to current element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            // Remove the top and recurse
            int top = stack.pop();
            insertInSortedOrder(stack, element);

            // Push the top element back
            stack.push(top);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
