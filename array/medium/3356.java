class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        // Get the length of nums array
        int n = nums.length;    

        // ✅ Base Case: If nums is already a zero array, we need 0 queries
        if (Arrays.stream(nums).allMatch(x -> x == 0)) return 0;

        // ✅ Binary Search Initialization
        // Minimum possible k is 1 (at least 1 query needed)
        // Maximum possible k is queries.length (applying all queries)
        int left = 1, right = queries.length;

        // ✅ Edge Case: If applying all queries cannot make nums a zero array, return -1
        if (!canMakeZeroArray(right, nums, queries)) return -1;

        // ✅ Binary Search to find the minimum k
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If we can make nums a zero array with `mid` queries, try a smaller k
            if (canMakeZeroArray(mid, nums, queries)) {
                right = mid;  // Move the search space to the left (try fewer queries)
            } else {
                left = mid + 1;  // Otherwise, try using more queries
            }
        }

        // ✅ The minimum `k` that makes nums a zero array
        return left;
    }

    /**
     * Helper function to check if the first `k` queries can make `nums` a zero array.
     * Uses a **difference array** approach for efficient range updates.
     */
    private boolean canMakeZeroArray(int k, int[] nums, int[][] queries) {
        int n = nums.length;

        // ✅ Difference array to store range updates efficiently
        int[] diff = new int[n + 1];

        // ✅ Apply the first `k` queries
        for (int i = 0; i < k; i++) {
            int left = queries[i][0];  // Starting index of the decrement range
            int right = queries[i][1]; // Ending index of the decrement range
            int val = queries[i][2];   // Maximum decrement allowed in this query

            // Using the **difference array** technique:
            // Increase `val` at `left` (start decreasing from this index)
            diff[left] += val;

            // Decrease `val` at `right + 1` (stop decreasing after `right`)
            diff[right + 1] -= val;
        }

        // ✅ Applying the difference array to reconstruct the decremented values
        int currVal = 0;  // Keeps track of the running sum of decrements
        for (int i = 0; i < n; i++) {
            currVal += diff[i];  // Apply the accumulated difference

            // If at any index, the decrement is not enough to make nums[i] zero, return false
            if (currVal < nums[i]) return false;
        }

        // ✅ If we successfully made all elements zero, return true
        return true;
    }
}
