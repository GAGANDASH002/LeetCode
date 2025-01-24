/*
Given an integer array nums, find a 
subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
 */
class Solution {
    public int maxProduct(int[] nums) {
        // Initialize variables
        int max = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        int n = nums.length;
        // Traverse through the array
        for(int i = 0; i < n; i++){
            // Base case (If encountered with zero reset prefix and suffix values assuming that a new subarray starts)
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            // Calculate prefix subarray product from front
            prefix = prefix * nums[i];
            // Calculate suffix subarray product from back
            suffix = suffix * nums[n - i - 1];

            // Return the maximum of the three variables
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}