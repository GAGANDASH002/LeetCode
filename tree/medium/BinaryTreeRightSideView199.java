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
 *}

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []

Approach:

Create an Arraylist
Right side view will always contain the root and the last node in each level
Hence check if rightmost node exists in a level than add it to the answer
Else add the left node of that level
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // Create a List data structure to store result
        ArrayList<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode root, ArrayList<Integer> result, int currLevel){
        // if encountered a leaf node then return
        if(root == null) return;

        // Add first root into the result
        if(currLevel == result.size()){
            result.add(root.val);
        }
        // Check if right side node exists then add to result
        rightView(root.right, result, currLevel + 1);
        // Else add the left side node to the result
        rightView(root.left, result, currLevel + 1);
    }
}