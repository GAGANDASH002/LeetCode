/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
Example 1:

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 
 Approach:
 Step 1: Perform BFS traversal on Binary tree and store parent of each node in a HashMap
 Step 2: Created a visited HashMap and a queue
 Step 3: Until we dont reach k distance initialize a variable curr_level = 0
 Step 4: Push Target Node into queue and move radially upwards and downwards incrementing curr_level by 1
 Step 5: Keep marking the nodes that are visited as true in the visited HashMap
 Step 6: Continue step 5 until curr_level = k
 Step 7: Add all remaining elements into a final result list which is the answer

 */
class Solution {
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target){
        // Create a Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            // Add level wise node into queue and mark its parent in the HashMap
            TreeNode current = queue.poll();
            if(current.left != null){
                parent_track.put(current.left, current);
                queue.add(current.left);
            }if(current.right != null){
                parent_track.put(current.right, current);
                queue.add(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Create a HashMap and call helper function for marking parents
        Map<TreeNode,TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, root);
        // Create a HashMap for visited nodes
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // Add target node into queue and mark it as visited
        queue.add(target);
        visited.put(target, true);
        // Initialize curr_level to zero
        int curr_level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            // Incremet curr_level until curr_level = k
            if(curr_level == k) break;
            curr_level++;
            for(int i = 0; i < size; i++){
                // Remove element from queue and check for left , right , and upward node
                TreeNode current = queue.poll();
                // If left node is not null and univisted then add to queue and mark it as visited
                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                // If right node is not null and univisted then add to queue and mark it as visited
                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                // If upward node is not null and univisted then add to queue using parent HashMap 
                // created using helper function and mark it as visited
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null){
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        // When curr_level = k , remaining elements in the queue are final answer
        // Add them to a list and return result
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            result.add(current.val);
        }

        return result;
}

}