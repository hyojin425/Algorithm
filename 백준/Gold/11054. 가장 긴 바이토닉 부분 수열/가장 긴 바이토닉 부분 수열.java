import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int n, int[] arr) {
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }

        int answer = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
                }
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[i]) {
                    dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[1][i] + dp[0][i] - 1);
        }
        return answer;
    }
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(solution(n, arr));


    }
}
    