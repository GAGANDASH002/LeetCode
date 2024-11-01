/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []
 
 * 
 * // Approach 1: Merging two lists then calling function for all lists
 * subsequently
 * 
 * class Solution {
 * 
 * // merging two sorted lists
 * public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
 * ListNode dummy = new ListNode();
 * ListNode current = dummy;
 * 
 * while( list1 != null && list2 != null ){
 * if( list1.val > list2.val ){
 * current.next = list2;
 * list2 = list2.next;
 * } else{
 * current.next = list1;
 * list1 = list1.next;
 * }
 * current = current.next;
 * }
 * 
 * current.next = (list1 != null) ? list1 : list2;
 * 
 * return dummy.next;
 * }
 * 
 * // using previous function to merge k sorted lists
 * public ListNode mergeKLists(ListNode[] lists) {
 * if (lists == null || lists.length == 0) {
 * return null;
 * }
 * 
 * // setting head to 1st List's head
 * ListNode head = lists[0];
 * 
 * for(int i=0 ; i<lists.length; i++){
 * // recursively adds two lists and then returns the head
 * head = mergeTwoLists(head,lists[1]);
 * }
 * return head;
 * }
 * }
 */
// Approach 2: use Min Heap
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // create Priority Queue to add all heads of lists in ascending order
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all the heads of individual lists into the min heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        // create a dummy head to traverse through the resultant list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract minimum element until heap is not empty
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            // add next element of individual list after its previous element has been extracted
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;
    }
}