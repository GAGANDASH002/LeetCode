class Solution {
  public int minDistance(String word1, String word2) {
    final int m = word1.length();
    final int n = word2.length();

    int[][] dp = new int[m + 1][n + 1];

    // Base case (if either word1 or word2 are exhausted)
    for (int i = 1; i <= m; ++i)
      dp[i][0] = i;

    for (int j = 1; j <= n; ++j)
      dp[0][j] = j;

    for (int i = 1; i <= m; ++i)
      for (int j = 1; j <= n; ++j)
        if (word1.charAt(i - 1) == word2.charAt(j - 1))//same characters
          dp[i][j] = dp[i - 1][j - 1];//eat 5 star do nothing
        else
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;                      //replace               //delete        //insert

    return dp[m][n];
  }
}