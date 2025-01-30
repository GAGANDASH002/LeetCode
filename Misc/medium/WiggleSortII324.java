/*
Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

You may assume the input array always has a valid answer.

 

Example 1:

Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.

Example 2:

Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]
 
 */
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums); // Sort Array

        int n = nums.length;
        // Create a copy of sorted array
        int[] temp = Arrays.copyOf(nums, n);
        
        // Split into two halves of smaller values and larger values
        int left = (n - 1)/2;
        int right = n - 1;

        for(int i = 0; i < n; i++){
            // Fill even indices with smaller values
            if(i % 2 == 0){
                nums[i] = temp[left--];
            } else { // and odd indices with larger values
                nums[i] = temp[right--];
            }
        }
    }
}