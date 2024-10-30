/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 Example 1:

 Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int count = 1;

        // find the size of the linkedlist
        while(current.next != null){
            current = current.next;
            count++;
        }

        if(head == null || head.next == null){
            return null;
        }

        // Remove head node if n = size of the list
        if(count == n){
            return head.next;
        }

        current = head;
        for(int i = 0; i<count-n-1; i++){
            current = current.next;
        }

        if(current.next != null){
            current.next = current.next.next;
        }

        return head;
    }
}