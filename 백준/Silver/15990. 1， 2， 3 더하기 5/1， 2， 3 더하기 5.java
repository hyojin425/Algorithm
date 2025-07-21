import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        final int MOD = 1_000_000_009;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int max = 0;
        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (m > max) {
                max = m;
            }
            arr[i] = m;
        }

        long[][] dp = new long[100001][4];

        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        if(max >= 2) {
            dp[2][1] = 0;
            dp[2][2] = 1;
            dp[2][3] = 0;
        }
        if(max >= 3) {
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
        }

        for(int i = 4; i <= max; i++){
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][2] + dp[i - 3][1]) % MOD;
        }

        for (int i : arr) {
            System.out.println((dp[i][1] + dp[i][2] + dp[i][3]) % MOD);
        }
    }
}