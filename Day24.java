//Problem24: You are given a binary tree and two distinct nodes within the tree. 
// Your task is to find the lowest common ancestor (LCA) of these two nodes. 
// The LCA of two nodes p and q is defined as the lowest node in the tree that has both p and q as descendants (where we allow a node to be a descendant of itself).
// Input:
// A binary tree represented as a series of nodes where each node has references to its left and right child.
// Two distinct nodes p and q from the tree.

import java.util.Scanner;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
public class LCA {
                    // Find LCA of two nodes
    public static TreeNode findLCA (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
    // Searching for a node by value
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //manually added the tree. 
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.print("Enter value of node p: ");
        int pVal = sc.nextInt();
        System.out.print("Enter value of node q: ");
        int qVal = sc.nextInt();

        TreeNode p = findNode(root, pVal);
        TreeNode q = findNode(root, qVal);

        if (p == null || q == null) {
            System.out.println("One or both nodes not found in the tree.");
        } else {
            TreeNode lca = findLCA(root, p, q);
            System.out.println("LCA of " + pVal + " and " + qVal + " is: " + lca.val);
        } } }
