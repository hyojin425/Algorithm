import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static int BFS(int n, int m, int[][] map) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        Queue<Location> q = new LinkedList<>();
        for(int i = 0 ; i< m; i++) {
            for(int j = 0; j< n; j++) {
                if(map[i][j] == 1) {
                    q.add(new Location(i, j));
                }
            }
        }

        int answer = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                Location tmp = q.poll();
                int x = tmp.x;
                int y = tmp.y;
                for(int j = 0; j< 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        q.add(new Location(nx, ny));
                    }
                }
            }
            answer++;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                if(map[i][j] == 0) {
                    return  -1;
                }
            }
        }
        return answer - 1;
    }

    public static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int m = intArr[1];
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(BFS(n, m, arr));
    }
}
