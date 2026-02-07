import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] chx = {1, 1, 0};
    static int[] chy = {0, 1, 1};

    public static int solution(int n, int[][] arr) {
        int[][][] dp = new int[n][n][3]; // 0: 가로, 1: 세로, 2: 대각선
        

        dp[0][1][0] = 1;
        
        for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1) continue;

                // 가로
                if(j > 0 && arr[i][j-1] == 0) {
                    dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
                }

                // 세로
                if(i > 0 && arr[i-1][j] == 0) {
                    dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
                }

                // 대각선
                if(i > 0 && j > 0
                        && arr[i-1][j] == 0
                        && arr[i][j-1] == 0) {
                    dp[i][j][2] += dp[i-1][j-1][0]
                                 + dp[i-1][j-1][1]
                                 + dp[i-1][j-1][2];
                }
               
            }
        }

        return dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i< n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        System.out.println(solution(n, arr));
    }
}