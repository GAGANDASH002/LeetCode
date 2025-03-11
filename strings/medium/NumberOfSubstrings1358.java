/*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

Example 3:

Input: s = "abc"
Output: 1
 */
class Solution {
    public int numberOfSubstrings(String s) {
        // Initialize total Count of valid substrings with atleast one occurence of unique characters in string
        int totalCount = 0;
        // Starting index of sliding window
        int start = 0;
        // store count of unique characters of given string
        int[] charCount = new int[3];

        // traverse the length of string
        for(int end = 0; end < s.length(); end++){
            // Increment the count of characters traversed in the created array
            charCount[s.charAt(end) - 'a']++;

            // If there is atleast one occurence of 'a', 'b', 'c' then count the substrings
            while(charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0){
                // increase the number of valid substrings
                totalCount += s.length() - end;
                // decrement count of the start character of window
                charCount[s.charAt(start) - 'a']--;
                // move the start of window forward
                start++;
            }
        }
        return totalCount;
    }
}