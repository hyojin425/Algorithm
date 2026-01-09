import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    public static void solution(int n, int d, int[][] arr) {
        int[] dp = new int[d +1];
        dp[0] = 0;
        List<Gil> graph[] = new ArrayList[d + 1];
        for (int i = 0; i < n; i++) {
            if(arr[i][1] <= d) {
                if(graph[arr[i][1]] == null) {
                    graph[arr[i][1]] = new ArrayList<>();
                }
                graph[arr[i][1]].add(new Gil(arr[i][0], arr[i][2]));
            }
        }

        for(int i = 1; i <= d; i++) {
            int dis = dp[i - 1] + 1;
            if (graph[i] != null){
                for(Gil g: graph[i]) {
                    int start = g.start;
                    dis = Math.min(dis, dp[start] + g.dis);
                }
            }
            dp[i] = dis;
        }

        System.out.println(dp[d]);
    }

    public static class Gil {
        int start;
        int dis;

        public Gil(int start, int dis) {
            this.start = start;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int d = intArr[1];

        int[][] arr = new int[n][3];

        for(int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        solution(n, d, arr);

    }
}
