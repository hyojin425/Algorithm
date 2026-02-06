import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int n, int[][] arr) {
        int[][] dp = new int[2][n];

        if(n == 1) return Math.max(arr[0][0], arr[1][0]); 

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[0][1] = arr[0][1] + dp[1][0];
        dp[1][1] = arr[1][1] + dp[0][0];

        for(int i = 2; i < n; i++) {
            int max = Math.max(dp[0][i - 2], dp[1][i - 2]);
            dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], max);
            dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], max);
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int j = 0; j < t; j++) {
             int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
             for(int i = 0; i< 2; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            System.out.println(solution(n, arr));
        }
    }
}