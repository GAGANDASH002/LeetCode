class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return f(nums, goal) - f(nums, goal - 1);
    }
    private int f(int[] nums, int goal) {
        if (goal < 0) return 0;
        int l = 0, r = 0, n = nums.length;
        int s = 0, ans = 0;
        while (r < n) {
            s += nums[r];
            while (s > goal) {
                s -= nums[l];
                l++;
            }
            ans += (r - l + 1);
            r++;
        }
        return ans;
    }
}