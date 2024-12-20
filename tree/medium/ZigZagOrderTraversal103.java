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
 * Example 1:
 
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []
 
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Create resultant list
        List<List<Integer>> result = new LinkedList<>();
        // base case
        if (root == null) {
            return result;
        }   

        // Add root node to queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // Boolean variable to toggle zigzag traversal
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Add current node's value in the correct order
                if (leftToRight) {
                    levelList.addLast(currentNode.val);
                } else {
                    levelList.addFirst(currentNode.val);
                }

                // Add children to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Toggle direction for the next level
            leftToRight = !leftToRight;

            // Add the current level to the result
            result.add(levelList);
        }

        return result;
    }
}
