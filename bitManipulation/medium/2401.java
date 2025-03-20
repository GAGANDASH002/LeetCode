/*

You are given an array nums consisting of positive integers.

We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.

Return the length of the longest nice subarray.

A subarray is a contiguous part of an array.

Note that subarrays of length 1 are always considered nice.

 

Example 1:

Input: nums = [1,3,8,48,10]
Output: 3
Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
- 3 AND 8 = 0.
- 3 AND 48 = 0.
- 8 AND 48 = 0.
It can be proven that no longer nice subarray can be obtained, so we return 3.
Example 2:

Input: nums = [3,1,5,11,13]
Output: 1
Explanation: The length of the longest nice subarray is 1. Any subarray of length 1 can be chosen.

Approach: When the arithmetic sum and XOR of two numbers are equal then their AND operation gives 0 and hence makes a nice array.
 */
class Solution {
    public int longestNiceSubarray(int[] nums) {
        // Initiliaze variables
        int currSum = 0;
        int xorSum = 0;
        int maxWindow = 0;

        int left = 0;
        int n = nums.length;
        int right = 0;

        // Traverse the window and calculate arithmetic sum and xor sum
        while(right < n){
            currSum += nums[right];
            xorSum ^= nums[right];

            // If they are not equal slide the window to next element by removing the leftmost element from window
            while(currSum != xorSum){
                currSum -= nums[left];
                xorSum ^= nums[left]; 
                left++;            
            }

            // calculate maximum size of nice subarray
            maxWindow = Math.max(maxWindow, right - left + 1);
            right++;
        }  
        return maxWindow;    
    }
}