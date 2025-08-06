import java.util.Scanner;


public class Main {
    public static int solution(int n, int[][] arr) {
        int[][] dp = new int[n][3];

        // 1번째를 R로 선택한 경우
        dp[1][0] = Integer.MAX_VALUE;
        dp[1][1] = arr[0][0] + arr[1][1];
        dp[1][2] = arr[0][0] + arr[1][2];
        for (int i = 2; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }
        int result1 = Math.min(dp[n - 1][1], dp[n - 1][2]);

        // 1번째를 G로 선택한 경우
        dp[1][0] = arr[0][1] + arr[1][0];
        dp[1][1] = Integer.MAX_VALUE;
        dp[1][2] = arr[0][1] + arr[1][2];
        for (int i = 2; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }
        int result2 = Math.min(dp[n - 1][0], dp[n - 1][2]);

        // 1번째를 B로 선택한 경우
        dp[1][0] = arr[0][2] + arr[1][0];
        dp[1][1] = arr[0][2] + arr[1][1];
        dp[1][2] = Integer.MAX_VALUE;
        for (int i = 2; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }
        int result3 = Math.min(dp[n - 1][1], dp[n - 1][0]);

        int tmp = Math.min(result1, result2);
        return Math.min(tmp, result3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] array = new int[n][3];
        for (int i = 0; i < n; i++) {
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
            array[i][2] = scanner.nextInt();
        }
        System.out.println(solution(n, array));
    }

}