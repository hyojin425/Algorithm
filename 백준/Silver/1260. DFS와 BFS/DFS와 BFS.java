import java.lang.reflect.Array;
import java.util.*;


public class Main {
    static int n, m, v = 0;
    static int[][] graph;
    static int[] visited;

    public void dfs(int v) {
        for (int i = 1; i <= n; i++) {
            if (graph[v][i] == 1 && visited[i] == 0) {
                System.out.print(i + " ");
                visited[i] = 1;
                dfs(i);
            }
        }
    }

    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[tmp][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);

        n  = scanner.nextInt();
        m = scanner.nextInt();
        v = scanner.nextInt();
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new int[n + 1];
        System.out.print(v + " ");
        visited[v] = 1;
        t.dfs(v);
        System.out.println();

        visited = new int[n + 1];
        System.out.print(v + " ");
        visited[v] = 1;
        t.bfs(v);
    }

}