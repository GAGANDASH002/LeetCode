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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
       // Map all values of inorder array with indices into HashMap
       for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
       }
       
       TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length -1, 
       inMap);

       return root;
    }

    private TreeNode buildTree(int preorder[], int preStart, int preEnd, int inorder[],
    int inStart, int inEnd, Map<Integer, Integer> inMap){
        // Base case
        if(preStart > preEnd || inStart > inEnd) return null;

        // First node of preorder is Root (root left right)
        TreeNode root = new TreeNode(preorder[preStart]);

        // get root value in inorder using hashmap
        int inRoot = inMap.get(root.val);
        // Number of nodes remaining on left subtree
        int numsLeft = inRoot - inStart;

        // Build remaining nodes recursively
        root.left = buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot
        -1, inMap);
        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot + 1,
        inEnd, inMap);

        return root;
    }
}