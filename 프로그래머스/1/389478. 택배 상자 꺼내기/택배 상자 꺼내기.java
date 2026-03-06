class Solution {
    public int solution(int n, int w, int num) {
        int rows = (n + w -1 ) / w;
        
        int row = (num - 1) / w;
        int col;
        if(row % 2== 1) {
            col = w - 1 - ((num -1) % w);
        } else {
            col = (num - 1) % w;
        }
        
        int answer = 0;
        for(int i = row + 1; i < rows; i++) {
            int val;
            if(i % 2 == 1) {
                val = i * w + (w - col);
            } else {
                val = i * w + col + 1;
            }
            
            if(val <= n) answer++;
        }
        return answer + 1;
    }
}