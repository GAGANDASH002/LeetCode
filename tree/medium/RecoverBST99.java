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
 * 
 Example 1:

Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:

Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 
 */
class Solution {
    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;
    // Inorder traversal always gives an ascending order
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);

        // if previous val is greater than current val
        if(prev != null && (root.val < prev.val)){
            // This is the first violation , so mark these as first and midddle
            if(first == null){
                first = prev;
                middle = root;
            }

            // Second violation
            else{
                last = root;
            }
        }

        // Mark current node as previous and move ahead
        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        // If both violations are found and
        // Swapped nodes are not adjacent then swap
        if(first != null && last != null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        // Both violations are found 
        // But both swapped nodes are adjacent then swap them
        else if(first != null && middle != null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}