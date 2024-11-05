/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
Example 1 : 

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2 :

Input: head = [0,1,2], k = 4
Output: [2,0,1]
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }

        ListNode temp = head;
        int count = 1;
        // Count size of the LinkedList
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        // Link last node to head (Circular LinkedList)
        temp.next = head;
        // Calculate required no of rotations
        k = k % count;
        temp = head;
        // move temp to the node just before the new head
        for(int i = 1; i < count-k ;i++){
            temp = temp.next;
        }
        // set new head and break the circular LinkedList created earlier
        ListNode newHead = temp.next;
        temp.next = null;
        return newHead;
}
        
        
}