//Probleam12:  You are given a string s consisting of different types of parentheses: (), {}, and []. 
//Your task is to determine whether the given string is valid.
// A string is considered valid if:
    // a. Every opening bracket has a corresponding closing bracket of the same type.
    // b. The brackets are closed in the correct order. This means that a closing bracket must close the most recent unmatched opening bracket.

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string of parentheses: ");
        String input = sc.nextLine();

        if (isValid(input)) {
            System.out.println("The string is VALID!");
        } else {
            System.out.println("The string is NOT valid.");
        }
        sc.close();
    }
}
