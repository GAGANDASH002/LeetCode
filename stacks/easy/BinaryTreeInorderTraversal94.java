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

// Simple Inorder Traversal Solution
Example 1:

Input: root = [1,null,2,3]

Output: [1,3,2]

Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,2,6,5,7,1,3,9,8]
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorder(root, list);

        return list;
    }

    private void inorder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // Create an array list to store the inorder traversal of the tree
        List<Integer> list = new ArrayList<>();
        // Stack to maintain the traversed nodes
        Stack<TreeNode> stack = new Stack<>();

        
        while(root != null || !stack.isEmpty()){
            // push node into stack until left child is not empty
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            // once left child is null pop the node and add it to the resultant list            
            root = stack.pop();
            list.add(root.val);
            // move to right child and perform same operation again
            root = root.right;
        }
        return list;
}
}