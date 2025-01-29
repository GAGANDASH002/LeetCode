/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is 
the smallest in lexicographical order
 among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"

// Alternative approach:
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] seen = new boolean[26];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - 'a';
            if(seen[curr]) continue;
            while(!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]){
                seen[st.pop()] = false;
            }
            st.push(curr);
            seen[curr] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();
    }
}*/
// My Approach:
class Solution {
    public String removeDuplicateLetters(String s) {
        // Create a HashMap to store the characters and their frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Populate the map with the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Result string to store the unique letters in lexicographical order
        StringBuilder res = new StringBuilder();
        
        // Boolean array to keep track of characters already in the result
        boolean[] inResult = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // Decrement the frequency of the current character
            map.put(currentChar, map.get(currentChar) - 1);
            
            // If the character is already in the result, skip it
            if (inResult[currentChar - 'a']) {
                continue;
            }

            // Remove characters from the result if:
            // 1. The character in the result is lexicographically larger than the current character.
            // 2. The character still has occurrences left in the string.
            while (res.length() > 0 && res.charAt(res.length() - 1) > currentChar && map.get(res.charAt(res.length() - 1)) > 0) {
                char removedChar = res.charAt(res.length() - 1);
                res.deleteCharAt(res.length() - 1); // Remove the last character
                inResult[removedChar - 'a'] = false; // Mark it as not in result
            }

            // Add the current character to the result
            res.append(currentChar);
            inResult[currentChar - 'a'] = true; // Mark it as in result
        }
        
        // Return the result as a string
        return res.toString();
    }
}
