import java.util.*;

public class Main {

    public static int solution(int n) {
        int[] dp = new int[n + 1];
        int[] nums = {1, 2, 3};
        dp[0] = 1;
        for (int num : nums) {
            for (int i = num; i <= n; i++) {
                dp[i] += dp[i - num];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(solution(sc.nextInt()));
        }
    }
}