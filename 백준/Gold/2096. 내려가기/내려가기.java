import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void solution(int n, int[][] arr) {
        int[][] dp1 = new int[n][3];
        int[][] dp2 = new int[n][3];

        dp1[n - 1][0] = arr[n - 1][0];
        dp1[n - 1][1] = arr[n - 1][1];
        dp1[n - 1][2] = arr[n - 1][2];

        dp2[n - 1][0] = arr[n - 1][0];
        dp2[n - 1][1] = arr[n - 1][1];
        dp2[n - 1][2] = arr[n - 1][2];
        
        for(int i = n - 2; i >= 0; i--) {
            dp1[i][0] = arr[i][0] + Math.max(dp1[i + 1][0] , dp1[i + 1][1]);
            dp2[i][0] = arr[i][0] + Math.min(dp2[i + 1][0] , dp2[i + 1][1]);

            dp1[i][1] = arr[i][1] + Math.max(dp1[i + 1][2] , 
                                             Math.max(dp1[i + 1][0] , dp1[i + 1][1]));
            dp2[i][1] = arr[i][1] + Math.min(dp2[i + 1][2] , 
                                             Math.min(dp2[i + 1][0] , dp2[i + 1][1]));

            dp1[i][2] = arr[i][2] + Math.max(dp1[i + 1][1] , dp1[i + 1][2]);
            dp2[i][2] = arr[i][2] + Math.min(dp2[i + 1][1] , dp2[i + 1][2]);
        }

        int max = Math.max(dp1[0][1], Math.max(dp1[0][0], dp1[0][2]));
        int min = Math.min(dp2[0][1], Math.min(dp2[0][0], dp2[0][2]));
        System.out.println(max + " " + min);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for(int i = 0; i< n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        solution(n, arr);
    }
}