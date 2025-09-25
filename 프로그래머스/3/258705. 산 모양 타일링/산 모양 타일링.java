class Solution {
    public int solution(int n, int[] tops) {
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        
        for(int i = 1; i <= n; i++) {
            if(tops[i - 1] == 0) {
                dp[i][0] = (dp[i-1][0] * 2 + dp[i-1][1]) % 10007;
                dp[i][1] = (dp[i-1][0] + dp[i-1][1]) % 10007;
            } else {
                dp[i][0] = (dp[i-1][0] * 3 + dp[i-1][1] * 2) % 10007;
                dp[i][1] = (dp[i-1][0] + dp[i-1][1]) % 10007;
            }
            
        }
        
        return (dp[n][0] + dp[n][1]) % 10007;
    }
}