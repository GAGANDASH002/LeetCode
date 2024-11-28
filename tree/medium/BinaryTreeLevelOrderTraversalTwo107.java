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
Output: [[15,7],[9,20],[3]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Create main output list to store the level order traversal
        ArrayList<List<Integer>> output = new ArrayList<>();
        if(root == null){
            return output;
        }
        // Create a queue to push nodes of each level into queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // Check for the children of all nodes at each level
        while(!queue.isEmpty()){
            int size = queue.size();
            // Create a temporary List to store the children of the current node in the queue
            List<Integer> temp = new ArrayList<>();
            for(int i =0; i<size; i++){
                // Pop node from queue and push into the temporary list
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                // Add children of the current node to the queue 
                if(curr.left != null){
                    queue.offer(curr.left);
                }if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        // Add each level traversal to output list
        output.add(temp);
        }
        // Reverse output as the question demands Bottom Level Order Traversal
        Collections.reverse(output);
        return output;
    }
}