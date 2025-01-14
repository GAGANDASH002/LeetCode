/*
Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 
 */
class Solution {
    public String reverseWords(String s) {
        // Splitting all words ignoring whitespaces
        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder();

        for(int i = words.length - 1; i>=0; i--){
            // Add word to result
            res.append(words[i]);
            // Add a space if word is not the first word
            if(i != 0){
                res.append(" ");
            }
        }

        return res.toString().trim();
        
    }
}
/* Approach Two 
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int left = 0;
        int right = words.length - 1;

        while(left < right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        StringBuilder res = new StringBuilder();
        for(String word: words){
            if(!word.isEmpty()){
                if(res.length() > 0){
                    res.append(" ");
                }
                res.append(word);
            }
        }

        return res.toString();
    }
}
*/
