import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[][] graph;
    static int n, m;

    public static void bfs(int i , int j) {
        int[][] dp = new int[n][m];
        for(int k = 0; k < n; k++) {
            Arrays.fill(dp[k], -1);
        }
        dp[i][j] = 0;
        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = 1;

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    if(graph[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        dp[nx][ny] = dp[tmp[0]][tmp[1]] + 1;   
                    }
                }
            }
        }

        for(int k = 0; k < n; k++) {
            for(int l = 0; l< m; l++) {
                if(graph[k][l] == 0) System.out.print(0 + " ");
                else System.out.print(dp[k][l] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = arr[0];
        m = arr[1];
        graph = new int[n][m];
        for(int i = 0; i< n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        int k = 0;
        int l = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< m; j++) {
                if(graph[i][j] == 2) {
                    k = i;
                    l = j;
                }
            }
        }

        bfs(k, l);
    }
}