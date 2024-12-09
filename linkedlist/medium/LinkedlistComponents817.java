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

Input: head = [0,1,2,3], nums = [0,1,3]
Output: 2
Explanation: 0 and 1 are connected, so [0, 1] and [3] are the two connected components.

Example 2:


Input: head = [0,1,2,3,4], nums = [0,3,1,4]
Output: 2
Explanation: 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        ListNode temp = head;
        Set<Integer> set = new HashSet<>();

        // Store all values of nums array into a set
        for(int i : nums){
            set.add(i);
        }

        int count = 0;
        boolean flag = false;
        while(temp != null){
            // Condition for checking consecutive connected elements in LinkedList
            if(set.contains(temp.val) && !flag){
                count ++;
                flag = true;
            }// Element not present in nums array
            else if(!set.contains(temp.val) && flag){
                flag = false;
            }
            temp = temp.next;
        }
        return count;
    }
}