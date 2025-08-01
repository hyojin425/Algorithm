import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];
        dp[0] = wine[0];
        if ( n >= 2) dp[1] = wine[0] + wine[1];
        if (n >= 3) {
            dp[2] = Math.max(wine[0] + wine[1], wine[1] + wine[2]);
            dp[2] = Math.max(dp[2], wine[0] + wine[2]);
        }

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + wine[i]);
            dp[i] = Math.max(dp[i], dp[i - 3] + wine[i - 1] + wine[i]);
        }

        System.out.println(dp[n - 1]);
    }

}