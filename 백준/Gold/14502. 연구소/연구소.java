import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[][] map;
    static int totalBlank;
    static int n, m;
    static List<int[]> virus = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] ch = new int[n][m];
        for(int[] v: virus) {
            ch[v[0]][v[1]] = 1;
            q.add(v);
        }
        int[] dx = {0, -1, 1, 0};
        int[] dy = {1, 0, 0, -1};

        int cnt = 0;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for(int i =0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m 
                   && map[nx][ny] == 0 && ch[nx][ny] == 0) {
                    cnt++;
                    ch[nx][ny] = 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        answer = Math.max(answer, totalBlank - cnt);
    }

    public static void dfs(int l) {
        if(l == 3) {
            bfs();
        } else {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 0) {
                        map[i][j] = 1;
                        dfs(l + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = intArr[0];
        m = intArr[1];
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    totalBlank++;
                } else if(map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        totalBlank -= 3;

        dfs(0);
        System.out.println(answer);
    }
}