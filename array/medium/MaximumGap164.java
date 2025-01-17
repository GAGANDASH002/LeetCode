/*
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

You must write an algorithm that runs in linear time and uses linear extra space.

 

Example 1:

Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.

Example 2:

Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
 */

/* My approach

class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);

        int maxGap = 0;
        int st = 0;
        int end = st + 1;
        
        while(st < nums.length - 1){
            maxGap = Math.max(maxGap, nums[end] - nums[st]);
            st++;
            end++;
        }

        return maxGap;
    }
}*/
// Approach 2: Bucket Sort
class Solution {
    public int maximumGap(int[] nums) {
        // Find minimum and maximum elements
        int min = nums[0], max = nums[0], n = nums.length;
        for(int x : nums){
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        // All elements are same
        if(min == max) return 0;

        // Initalize min and max Buckets to store max and min elements and also initialize bucket size
        int bucketSize = (int) Math.ceil((double) (max-min) / (n - 1));
        int [] minBucket = new int[n];
        int [] maxBucket = new int [n];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        // find bucket index of each element and fill min and max buckets
        for(int x : nums){
            int idx = (x - min)/bucketSize;
            minBucket[idx] = Math.min(x, minBucket[idx]);
            maxBucket[idx] = Math.max(x, maxBucket[idx]);
        }

        int maxGap = bucketSize;// Maximum gap is always greater or equal to bucketSize
        int prev = maxBucket[0];// Store the max element of previous bucket
        // Iterate through remaining buckets 
        for(int i = 1; i < n; i++){
            if(minBucket[i] == Integer.MAX_VALUE) continue;
            // Update maxGap and move previous to maximum element of current bucket
            maxGap = Math.max(maxGap, minBucket[i] - prev);
            prev = maxBucket[i];
        }
        return maxGap;
    }
}