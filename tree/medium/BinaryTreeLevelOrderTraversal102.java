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
 
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []
 
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Queue to store root element
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // List of List to store level-wise elements
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root == null){
            return list;
        }
        // add first element of the level into the queue
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> sublist = new LinkedList<Integer>();
            // if root.left and root.right exists then add them into the queue
            // and pop the root and add into the sublist
            for(int i = 0; i<level; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);      
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            // add all level-wise sublists into the final list
            list.add(sublist);
        }

        return list;

    }
}