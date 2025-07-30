import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = arr[0];
        int k = arr[1];

        long[][] dp = new long[k + 1][n + 1];
        for (int i = 1; i <= k; i++){
            dp[i][1] = i;
        }
        for (int i = 1; i <= n; i++){
            dp[1][i] = 1;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_000;
            }
        }

        System.out.println(dp[k][n]);
    }

}