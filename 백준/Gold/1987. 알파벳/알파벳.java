import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    static int answer = Integer.MIN_VALUE;
    static int[] alphabet = new int[26];
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[][] map;
    static int n, m;
    public static void dfs(int len, int x, int y) {
        answer = Math.max(answer, len);
        for(int i = 0; i< 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(alphabet[map[nx][ny] - 'A'] == 0) {
                    alphabet[map[nx][ny] - 'A'] = 1;
                    dfs(len + 1, nx, ny);
                    alphabet[map[nx][ny] - 'A'] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = intArr[0];
        m = intArr[1];

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        alphabet[map[0][0] - 'A'] = 1;
        dfs(1, 0, 0);
        System.out.println(answer);

    }
}