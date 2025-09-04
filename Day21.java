//Problem21:  You are given a stack of integers, and your task is to write a function that reverses the stack using recursion.
//You are not allowed to use any additional data structure (like arrays, lists, or another stack). The only operations you are allowed to 
//perform are push, pop, and peek on the stack. The reversal must be done using recursion only.

// Input:
// A stack of integers. The stack may contain positive, negative, or zero values

import java.util.Stack;
public class Reverse_Stack {
    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Step 1: Pop the top element
            int top = stack.pop();

            // Step 2: Recursively reverse stack
            reverseStack(stack);

            // Step 3: Insert the popped element at the bottom
            insertAtBottom(stack, top);
        }
    }

    // Helper function to insert an element
    private static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertAtBottom(stack, element);
            stack.push(top);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}
