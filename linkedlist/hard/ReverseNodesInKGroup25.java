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

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 
*/
class Solution {
   public ListNode reverseLL(ListNode head){
       // base case
       if(head == null || head.next == null) return head;
       // Recursively calls until last node becomes the new head
       ListNode newHead = reverseLL(head.next);
       // ReArranges link between consecutive nodes for reversal
       ListNode front = head.next;
       front.next = head;
       head.next = null;

       return newHead;
   }
   public ListNode reverseKGroup(ListNode head, int k) {
       // Only one node exists or k = 1
       if(head.next == null || k == 1) return head;
       // if only two nodes exist then reverse (k >= 2)
       if(head.next.next == null){
           ListNode newHead = reverseLL(head);
           return newHead;
       }
       // dummy node to keep track of previously processed portion
       ListNode dummy = new ListNode(0);
       ListNode h1 = head;
       ListNode temp = dummy;
       ListNode curr = head.next;
       int cnt = 2;

       while(curr != null){
           // store last node of previous kth group
           ListNode prev = curr;
           // preserve the 1st node of the next group
           curr = curr.next;
           if(cnt % k == 0){
               // break link with next group
               prev.next = null;
               ListNode newHead = reverseLL(h1);
               // connect previous group's last node to new reversed head
               temp.next = newHead;
               // move to last Node of reversed group
               temp = h1;
               // connect reversed group to next group's first node
               h1.next = curr;
               // move head to next group's first node
               h1 = curr;
           }
           cnt++;
       }
   return dummy.next;
   }   
} 
