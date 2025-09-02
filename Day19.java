//Problem19: Evaluate a Postfix Expression
// Given a postfix expression (also known as Reverse Polish Notation), your task is to evaluate the expression and return the result. 
// The expression can contain integers and the four basic arithmetic operators +, -, *, and /. 
//   Assume that the input is always valid and the division operator performs integer division, truncating towards zero.

// Input :
// - A string representing a postfix expression where operands and operators are separated by spaces.
// - The string contains only integers (both positive and negative) and the operators +, -, *, and /.
// - Input: "2 1 + 3 *"

import java.util.Stack;
class Main {
    static int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            String token = arr[i];
 // If the token is a number, push it onto the stack.
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            }  else {
// Pop two operands. The order is crucial: val2 is the first operand, val1 is the second.
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(val2 + val1);
                        break;
                    case "-":
                        stack.push(val2 - val1);
                        break;
                    case "*":
                        stack.push(val2 * val1);
                        break;
                    case "/":
                        // Handle division by zero to prevent a runtime exception.
                        if (val1 == 0) {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        stack.push(val2 / val1);
                        break;
                    case "^":
                        // In Java, '^' is the bitwise XOR operator, not exponentiation.
                        stack.push(val2 ^ val1);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }
        return stack.pop();
    }
        public static void main(String[] args) {
        String expression = "3 4 2 * 1 5 - 2 3 ^ ^ / +";
        String[] arr = expression.split(" ");
        int result = evaluatePostfix(arr);
        System.out.println("The result of the expression is: " + result);
    }
}



