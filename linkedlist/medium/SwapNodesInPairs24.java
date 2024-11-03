/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
Example 1:

Input: head = [1,2,3,4]

Output: [2,1,4,3]

Example 2:

Input: head = []

Output: []

Example 3:

Input: head = [1]

Output: [1]

Example 4:

Input: head = [1,2,3]

Output: [2,1,3]

 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Initialize dummy node before head
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode current = head;

        // check whether pair of nodes exist
        while(current != null && current.next != null){
            // save next Pair's first node
            ListNode nextPair = current.next.next;
            // Store second node of first pair
            ListNode second = current.next;

            // swap first pair of nodes
            second.next = current;
            current.next = nextPair;
            prev.next = second;

            // move variables to second pair
            prev=current;
            current=nextPair;
        }
        return dummy.next;
    }
}