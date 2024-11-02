
/* Approach 1:

class Solution {
    public int longestValidParentheses(String s) {
        // Initialize left right and max to zero
        int left =0;
        int right =0;
        int max=0;

        for(int i=0; i<s.length(); i++){
            // increment left and right on coming across '(' or ')' respectively
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            // if a valid pair is found update max
            if(left==right){
                max=Math.max(max,left*2);
            }else if(right>left){
                // in case of a right orphan bracket reinitialize values to zero
                left=0;
                right=0;
            }
        }


        // Check the same for a left orphan bracket as well
        left=0;
        right=0;

        for(int i=s.length()-1; i>0; i--){
            if(s.charAt(i) == ')'){
                right++;
            }else{
                left++;
            }
            if(left==right){
                max=Math.max(max,left*2);
            }else if(left>right){
                left=0;
                right=0;
            }
        
        }
        return max;
    }
}
*/

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        // Initialize a stack
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max =0;

        for(int i=0; i<s.length(); i++){
            // If encountered a '(' bracket push its index into the stack
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                // if stack not empty and encountered a ')' bracket pop from the stack
                if(!stack.isEmpty()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    // if the stack is empty means we encountered a non closing ')' bracket
                    stack.push(i);
                }else{
                    // if stack is not empty calculate max
                    max = Math.max(max, i - stack.peek());
                }
            }

        }
        return max;
    }
}