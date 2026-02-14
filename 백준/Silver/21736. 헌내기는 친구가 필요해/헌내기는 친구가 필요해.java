import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int n, int m, char[][] map) {
        int[] doyeon = new int[2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'I') {
                    doyeon[0] = i;
                    doyeon[1] = j;
                    break;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(doyeon);

        int answer = 0;
        int[] dx = {0, -1, 1, 0};
        int[] dy = {1, 0, 0, -1};
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(map[nx][ny] == 'O') {
                        map[nx][ny] = 'I';
                        q.add(new int[]{nx, ny});
                    }
                    if(map[nx][ny] == 'P') {
                        map[nx][ny] = 'I';
                        answer++;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arr[0];
        int m = arr[1];

        char[][] map = new char[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = solution(n,m , map);
        System.out.println(answer == 0 ? "TT" : answer);
    }
}