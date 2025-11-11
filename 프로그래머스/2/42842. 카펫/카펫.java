class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = 3; i<=sum/3; i++){
            for(int j = 3; j <= i; j++) {
                if(i * j == sum && (i - 2) * (j - 2) == yellow) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}