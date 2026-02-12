import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[][] map;
    static int n, m;
    public static int solution() {
        int[][][] dis = new int[n][m][2];
        dis[0][0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int wall = cur[2];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(map[nx][ny] == 0 && dis[nx][ny][wall] == 0) {
                        q.add(new int[]{nx, ny, wall});
                        dis[nx][ny][wall] = dis[x][y][wall] + 1;
                    } else if (map[nx][ny] == 1 && wall == 0 && dis[nx][ny][1] == 0) {
                        q.add(new int[]{nx, ny, 1});
                        dis[nx][ny][1] = dis[x][y][0] + 1;
                    }
                }
            }
        }

        int a = dis[n-1][m-1][0];
        int b = dis[n-1][m-1][1];

        if(a == 0 && b == 0) return -1;
        if(a == 0) return b;
        if(b == 0) return a;

        return Math.min(a, b);
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
            map[i] = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        System.out.println(solution());
    }
}