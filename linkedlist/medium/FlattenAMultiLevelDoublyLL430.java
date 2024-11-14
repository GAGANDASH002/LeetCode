/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

Example 1:

Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]

Example 2:

Input: head = [1,2,null,3]
Output: [1,3,2]

Example 3:

Input: head = []
Output: []
*/

class Solution {
    public Node flatten(Node head) {
        // Initialize two variables to track traversal
        Node curr = head;
        Node tail = head;
        // Stack to push parts of LL to be traversed later
        Stack<Node> stack = new Stack<Node>();

        while(curr != null){
            // If a child exists traverse the child node next and re arrange links
            if(curr.child != null){
                Node child = curr.child;
                if(curr.next != null){
                    stack.push(curr.next);
                    curr.next.prev = null;
                }
                curr.next = child;
                child.prev = curr;
                curr.child = null;
            }
            tail = curr;
            curr = curr.next;
        }
        // after reaching the end , pop from stack and relink the remaining portions
        while(!stack.isEmpty()){
            curr = stack.pop();
            tail.next = curr;
            curr.prev = tail;
            while(curr != null){
                tail = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}