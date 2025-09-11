//Problem28 : Check if a Binary Tree is Symmetric
//You are given the root of a binary tree. Your task is to determine whether the tree is symmetric.
//A binary tree is symmetric if the left and right subtrees are mirror images of each other.

//Input :The root of the binary tree.
 // Input : [1, 2, 2, 3, 4, 4, 3]

import java.util.Queue;
import java.util.ArrayDeque;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }

    // Helper method to build the tree from array input (level-order)
    public TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;

        // Ensure we never poll from an empty queue
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        SymmetricTree treeChecker = new SymmetricTree();
        Integer[] input = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = treeChecker.buildTree(input);
        System.out.println("Is the tree Symmetric?: "+ treeChecker.isSymmetric(root)); // Output: true
    }
}
