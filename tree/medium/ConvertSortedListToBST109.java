/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // Base cases if no node or only single node in LinkedList
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = slow;

        // Basic Traversal where slow reaches middle node by traversing one node at a time
        // whereas fast moves two nodes at a time
        while(fast != null && fast.next != null){
            mid = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        // make middle node as root
        TreeNode root = new TreeNode(slow.val);

        // disconnect root from left part of LinkedList
        mid.next = null;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;

    }
}