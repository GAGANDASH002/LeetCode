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
Example 1:

Input: root = [2,1,3]
Output: true

Example 2:

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
*/
class Solution {
   public boolean isValidBST(TreeNode root) {
        // Set Initial max and min values to Long.Max and Long.Min
       return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
   }

   public static boolean isValid(TreeNode root, long minVal, long maxVal){
       // Base case (if reahed end of tree)
       if(root == null){
           return true;
       }
       // If right side is smaller or left side is greater than root node
       if(root.val >= maxVal || root.val <= minVal){
           return false;
       }
       // Check for valid BST conditions (i.e left subtree < root && right subtree > root)
       return isValid(root.left, minVal, root.val)
       && isValid(root.right, root.val, maxVal);

   }
} 