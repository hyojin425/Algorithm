import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[][] ch;
    static char[][] map;
    static int n;
    public static void bfs(int x, int y, char t) {
        ch[x][y] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n
                  && ch[nx][ny] == 0 && map[nx][ny] == t) {
                    ch[nx][ny] = 1;
                    q.add(new int[]{nx, ny});
                  }
            }
        }
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        ch = new int[n][n];
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer1 = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(ch[i][j] == 0) {
                    bfs(i, j, map[i][j]);
                    answer1++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'R') map[i][j] = 'G';
            }
        }

        int answer2 = 0;
        for(int i = 0; i < n; i++) {
            Arrays.fill(ch[i], 0);
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(ch[i][j] == 0) {
                    bfs(i, j, map[i][j]);
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}