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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //bfs(level order traversal)
        if(depth==1){
            TreeNode res = new TreeNode(val);
            res.left=root;
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        depth--;
        q.offer(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
            TreeNode node = q.poll();
            if(depth==1){
                TreeNode tl = node.left;
                TreeNode tr = node.right;
                node.left = new TreeNode(val);
                node.right = new TreeNode(val);
                node.left.left = tl;
                node.right.right = tr;
            }
            else{
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            }
            depth--;
        }
        return root;
    }
}