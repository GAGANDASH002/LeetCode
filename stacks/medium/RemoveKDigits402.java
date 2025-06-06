/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 
 */
class Solution {
    public String removeKdigits(String num, int k) {
        // Create a stack to track order of characters
        Stack<Character> st = new Stack<>();

        // If greater element is at top then remove 
        for(char digit: num.toCharArray()){
            while(!st.isEmpty() && k > 0 && st.peek() > digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        
        // Remove remaining k elements
        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        // Add the smallest characters to resultant string
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        // Reverse the order
        res.reverse();
        
        // Handle edge cases of prevailing zeroes
        while(res.length() > 0 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }

        // Edge case of k == nums.length()
        return res.length() > 0 ? res.toString() : "0";
    }
}