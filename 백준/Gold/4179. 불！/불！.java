import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void solution(int r, int c, char[][] map) {
        Queue<int[]> jihun = new LinkedList<>();
        Queue<int[]> f = new LinkedList<>();
        for(int i =0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 'J') jihun.add(new int[]{i, j});
                if(map[i][j] == 'F') f.add(new int[]{i, j});
            }
        }

        int L = 1;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!jihun.isEmpty()) {
            int size = f.size();
            for(int i = 0; i < size; i++) {
                int[] tmp = f.poll(); 

                for(int j = 0; j < 4; j++) {
                    int nx = tmp[0] + dx[j];
                    int ny = tmp[1] + dy[j];
                    if(nx >= 0 && nx < r && ny >= 0 && ny < c 
                       && (map[nx][ny] == '.' || map[nx][ny] == 'J')) {
                        map[nx][ny] = 'F';
                        f.add(new int[]{nx, ny});
                    }
                }
            }

            size = jihun.size();
            for(int i = 0; i < size; i++) {
                int[] tmp = jihun.poll(); 

                if(tmp[0] == r - 1 || tmp[1] == c - 1 || tmp[0] == 0 ||tmp[1] == 0) {
                    System.out.println(L);
                    return;
                }

                for(int j = 0; j < 4; j++) {
                    int nx = tmp[0] + dx[j];
                    int ny = tmp[1] + dy[j];
                    if(nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == '.') {
                        map[nx][ny] = 'J';
                        jihun.add(new int[]{nx, ny});
                    }
                }
            }
            L++;
                
        }
        System.out.println("IMPOSSIBLE");
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int r = rc[0];
        int c = rc[1];
        char[][] map = new char[r][c];
        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }


        solution(r, c, map);
    }
}