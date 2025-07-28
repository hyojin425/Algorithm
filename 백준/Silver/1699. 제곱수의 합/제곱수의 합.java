import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[1] = 1;
        if (n >= 2) dp[2] = 2;
        if (n >= 3) dp[3] = 3;
        if (n >= 4) dp[4] = 1;

        for (int i = 5; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 5; i <= n; i++) {
            if(isPerfect(i)) {
                dp[i] = 1;
            } else {
                for (int j = 1; j <= i/2; j++) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }

        System.out.println(dp[n]);
    }

    static public boolean isPerfect(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

}