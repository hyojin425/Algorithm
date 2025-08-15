import java.util.*;


public class Main {
    static int n, m = 0;
    static int[][] graph;
    static int[][] visited;
    static int answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public void dfs(int L, int sum, int i, int j) {
        if (L == 4) {
            answer = Math.max(answer, sum);
            return;
        } else{
            for(int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    dfs(L + 1, sum + graph[nx][ny], nx, ny);
                    visited[nx][ny] = 0;
                }
            }
        }
    }

    // 'ㅓ 모양
    public void solution(int i, int j) {
        int[][] dx = {
                {1, 2, 1}, // 'ㅜ'
                {0, 0, 1}, // 'ㅏ'
                {-1, 0, 0}, // 'ㅓ'
                {1, 1, 2}}; // 'ㅗ'
        int[][] dy = {
                {0, 0, 1}, // 'ㅜ'
                {1, 2, 1}, // 'ㅏ'
                {1, 1, 2}, // 'ㅓ'
                {0, -1, 0}}; // 'ㅗ'

        for(int k = 0; k<4; k++){
            int sum = graph[i][j];
            boolean flag = true;
            for (int l = 0; l < 3; l++) {
                int nx = i + dx[k][l];
                int ny = j + dy[k][l];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    sum += graph[nx][ny];
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer = Math.max(sum, answer);
            }
        }
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);

        n  = scanner.nextInt();
        m = scanner.nextInt();
        visited = new int[n][m];
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = scanner.nextInt();
                graph[i][j] = a;
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = 1;
                t.dfs(1, graph[i][j], i, j);
                visited[i][j] = 0;
                t.solution(i, j);
            }
        }
        System.out.println(answer);
    }

}