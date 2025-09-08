// Problem25: Check if a Binary Tree is a Binary Search Tree (BST)
// You are given the root of a binary tree. Your task is to determine whether the tree is a valid Binary Search Tree (BST). A binary search tree is defined as a tree where:
// Every node’s left subtree contains only nodes with values less than the node’s value.
// Every node’s right subtree contains only nodes with values greater than the node’s value.
// Both the left and right subtrees must also be binary search trees.

// Input:
// A binary tree represented by its root node.

import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
public class CheckBST {
        public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }
    public static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("null")) return null;

    // Create the root node
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

    // Use BFS to build the tree level by level
        while (i < values.length) {
            TreeNode current = queue.poll();

    // Add left child if not 'null'
            if (i < values.length && !values[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;

    // Add right child if not 'null'
            if (i < values.length && !values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree nodes in level order (use 'null' for missing):");
        String[] input = sc.nextLine().split(" ");
        TreeNode root = buildTree(input);

        boolean result = isValidBST(root);
        System.out.println("Is the tree a valid BST? " + result);
    }  }
