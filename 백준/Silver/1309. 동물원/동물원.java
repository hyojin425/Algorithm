import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[1] = 3;
        if(n >= 2) dp[2] = 7;
        int m = 5;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + m + m) % 9901;
            m = dp[i - 1] + m;
        }

        System.out.println(dp[n] % 9901);
    }

}