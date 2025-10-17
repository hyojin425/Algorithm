import java.util.*;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] graph;

    public static void BFS(int x, int y, int n, int m) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        graph[y][x] = 0;
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nx = tmpX + dx[i];
                int ny = tmpY + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && graph[ny][nx] == 1) {
                    queue.add(new int[]{nx, ny});
                    graph[ny][nx] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();
            graph = new int[n][m];
            for (int j = 0; j < k; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                graph[y][x] = 1;
            }
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if(graph[j][l] == 1) {
                        BFS(l, j, n, m);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}