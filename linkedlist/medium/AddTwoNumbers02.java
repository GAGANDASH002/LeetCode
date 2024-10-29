package Leetcode.linkedlist.medium;
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
 * Example 1: 
 * 
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0; // initialize carry for sums greater than 9
        
        while(l1 !=  null || l2 != null){
            int firstDigit = (l1 != null)? l1.val : 0;
            int secondDigit = (l2 != null)? l2.val : 0;

            int sum = firstDigit + secondDigit + carry;
            int digit = sum % 10;
            carry = sum/10;

            ListNode newNode = new ListNode(digit);
            current.next = newNode;
            current = current.next;

            l1 = ( l1 != null )? l1.next : null;
            l2 = ( l2 != null )? l2.next : null;

        }

        if(carry > 0){
            current.next = new ListNode(carry);
        }

        return dummyHead.next;

    }
}