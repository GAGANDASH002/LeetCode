/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
 
 */
class Solution {
    public String largestNumber(int[] nums) {
        // Convert all integer values to string values
        String[] arr = new String[nums.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        // Sort on the basis of custom comparator
        // Check which is great (b+a) or (a+b)
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        StringBuilder res = new StringBuilder();
        // If the largest number in the array is 0\
        // then return 0 as the answer
        if(arr[0].equals("0")){
            return "0";
        }
        // Run a loop to append the numbers into the answer string
        // to form the largest number out of the given input array
        for(int i = 0; i < arr.length; i++){
            res.append(arr[i]);
        }

        // return the final answer
        return res.toString();
    }
}