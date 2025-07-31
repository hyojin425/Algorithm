import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[10][n + 1];

        for (int i = 0; i < 10; i++) {
            dp[i][1] = 1;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10_007;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[i][n];
        }
        System.out.println(result  % 10_007);
    }

}