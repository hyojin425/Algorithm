import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[][] map;
    static int[][] visited;
    static int n, m;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited = new int[n][m];
        visited[0][0] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i= 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(visited[nx][ny] == 0 && map[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static int solution() {
        Queue<int[]> q= new LinkedList<>();
        int answer = 0;
        while(true) {
            bfs();

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 1) {
                        int cnt = 0;
                        for(int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if(visited[nx][ny] == 1) {
                                cnt++;
                            }
                        }
                         if(cnt >= 2) q.add(new int[]{i, j});
                    }
                }
            }

            if(q.isEmpty()) break;

            while(!q.isEmpty()) {
                int[] tmp = q.poll();
                map[tmp[0]][tmp[1]] = 0;
            }

            answer++;
        }
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = arr[0];
        m = arr[1];

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        System.out.println(solution());
    }
}