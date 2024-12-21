/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// Basic approach of Level Order Traversal or BFS is used
class Solution {
    public Node connect(Node root) {
        // base case
        if(root == null) return null;
        // Queue to track BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node rightNode = null;
            // reaarange links, if rightMost node then its next pointer is set to null
            // otherwise it is set to the element on its right
            for(int i = queue.size(); i > 0; i--){
                Node current = queue.poll();
                current.next = rightNode;
                rightNode = current;
                // Add next level of elements from the right side
                if(current.right != null){
                    queue.add(current.right);
                    queue.add(current.left);
                }
            }
        }
        return root;
    }
}