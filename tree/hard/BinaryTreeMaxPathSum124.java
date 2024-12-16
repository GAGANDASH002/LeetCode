/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return max_sum;
    }

    private int findMax(TreeNode root){
        if(root ==  null) return 0;

        // Find the maxmimum sum of left and right tree of a node
        // Max is taken to avoid -ve values
        int leftTreeMax = Math.max(findMax(root.left),0);
        int rightTreeMax = Math.max(findMax(root.right),0);

        // If we assume current node as root
        int ifRootSum = root.val + leftTreeMax + rightTreeMax;

        // Update max_sum
        max_sum = Math.max(max_sum, ifRootSum);

        // If we assume that current node is not root
        // return the maximum sum to the previous call
        return root.val + Math.max(leftTreeMax, rightTreeMax);

        
    }
}