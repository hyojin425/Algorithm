import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[][] map;
    static int r, c;
    static int upx, downx ,y;

    public static void diffusion() {
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        int[][] tmp = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] > 0) {
                    int cnt = 0;
                    int spread = map[i][j] / 5;
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx >= 0 && nx < r && ny >= 0 && ny < c 
                           && map[nx][ny] != -1) {
                            cnt++;
                            tmp[nx][ny] += spread;
                        }
                    }
                    tmp[i][j] += map[i][j] - spread * cnt;
                }
            }
        }

        tmp[upx][y] = -1;
        tmp[downx][y] = -1;
        map = tmp;
    }

    public static void circular(int upx, int downx) {
        for(int i = downx + 2; i < r; i++) {
            map[i - 1][0] = map[i][0];
        }
        for(int i = 1; i < c; i++) {
            map[r - 1][i - 1] = map[r - 1][i];
        }
        for(int i = r - 2; i >= downx; i--) {
            map[i + 1][c - 1] = map[i][c - 1];
        }
        for(int i = c - 2; i > 0; i--) {
            map[downx][i + 1] = map[downx][i];
        }
        map[downx][1] = 0;

        for(int i = upx - 2; i >= 0; i--) {
            map[i + 1][0] = map[i][0];
        }
        for(int i = 1; i < c; i++) {
            map[0][i - 1] = map[0][i];
        }
        for(int i = 1; i <= upx; i++) {
            map[i - 1][c - 1] = map[i][c - 1];
        }
        for(int i = c - 2; i > 0; i--) {
            map[upx][i + 1] = map[upx][i];
        }
        map[upx][1] = 0;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        r = intArr[0];
        c = intArr[1];
        int t = intArr[2];

        map = new int[r][c];
        for(int i = 0; i < r; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

         upx = -1;
         downx = -1;
         y = -1;
        for(int i = 0; i < r; i++) {
            if(upx != -1) break;
            for(int j = 0; j < c; j++) {
                if(map[i][j] == -1) {
                    upx = i;
                    downx = i + 1;
                    y = j;
                    break;
                }
            }
        }

        for(int i = 0; i < t; i++) {
            diffusion();
            circular(upx, downx);
        }


        int answer = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] != -1) answer += map[i][j];
            }
        }

        System.out.println(answer);
    }
}