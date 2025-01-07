/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Make an array to check each combination of string with words in dictionary
        boolean[] dp = new boolean[s.length() + 1];
        // Initialize base case as True
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(String w: wordDict){
                // Check if the combination of strings are of size same as word in dictionary
                int st = i - w.length();
                // If the substring matches set the index value as true
                if(st >=0 && dp[st] && s.substring(st, i).equals(w)){
                    dp[i] = true;
                    break;
                }
            }
        }

        // If the last value in the array is true means the whole word can be segmented else if its false then the word cant be segmented into words in the dictionary
        return dp[s.length()];
    }
}