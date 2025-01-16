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
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 
 */
class Solution {
    public void reorderList(ListNode head) {
        // Base case
        if(head == null) return;

        ListNode slow = head, fast = head;
        
        // Find middle of LinkedList
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second Half of LinkedList 
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode prev = null;

        while(secondHalf != null){
            ListNode temp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = temp;
        }

        // Rearrange the first half and the reversed second half
        ListNode firstHalf = head;
        while(prev != null){
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = prev.next;
            firstHalf.next = prev;
            prev.next = temp1;
            firstHalf = temp1;
            prev = temp2;
        }
    }
}