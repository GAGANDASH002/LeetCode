class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(0, true, prices, memo);
    }

    private int helper(int index, boolean canBuy, int[] prices, Map<String, Integer> memo) {
        if (index == prices.length) return 0;

        String key = index + "-" + canBuy;
        if (memo.containsKey(key)) return memo.get(key);

        int profit = 0;

        if (canBuy) {
            int buy = -prices[index] + helper(index + 1, false, prices, memo);
            int skip = helper(index + 1, true, prices, memo);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[index] + helper(index + 1, true, prices, memo);
            int skip = helper(index + 1, false, prices, memo);
            profit = Math.max(sell, skip);
        }

        memo.put(key, profit);
        return profit;
    }
}
