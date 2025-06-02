class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int maxScore = 0;
        int score = 0;
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        while(left <= right){
            if(tokens[left] <= power){
                score++;
                power -= tokens[left];
                left++;
            }
            else if(score > 0){
                score--;
                power += tokens[right];
                right--;
            }
            else{
                break;
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}