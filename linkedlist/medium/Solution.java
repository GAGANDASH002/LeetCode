/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 
Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        // Perform traversal
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // Detection of cycle
            if(slow == fast){
                // Initialize two ptr at head and point of detection
                ListNode p1 = head;
                ListNode p2 = slow;

                // Find node where cycle begins
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }   
        return null;
    }
}