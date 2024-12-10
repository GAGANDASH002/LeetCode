/*
 * Given two strings s and p, return an array of all the start indices of p's 
anagrams
 in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 
*/
class Solution {
    // Helper function for checking if s freq and p freq array are equal or not
    private boolean isEqual(int hash[], int pHash[]){
        boolean ans = true;
        for(int i = 0; i < 26; i++){
            if(hash[i] != pHash[i]){
                ans = false;
                break;
            }
        }
        return ans;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // Base case : No anagram can exist
        if(s.length() < p.length()){
            return res;
        }

        // Frequency arrays for characters in String s and p respectively
        int hash[] = new int[26];
        int pHash[] = new int[26];

        // Check for anagram starting from first index
        for(int i = 0; i<p.length(); i++){
            hash[s.charAt(i) - 'a']++;
            pHash[p.charAt(i) - 'a']++;
        }

        // If found then add index 0 to result
        if(isEqual(hash, pHash)){
            res.add(0);
        }

        // Move the sliding window to other characters in the string
        for(int i = p.length(); i < s.length(); i++){
            // Increment freq of new character
            hash[s.charAt(i) - 'a']++;
            // Decrement freq of left out char
            hash[s.charAt(i - p.length()) - 'a']--;
            // check equality
            if(isEqual(hash, pHash)){
                res.add(i - p.length() + 1);
            }
        }
        // final answer
        return res;
    }
}