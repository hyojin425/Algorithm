import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int n;
    static int[][] map;
    static int curx, cury;
    static int answer = 0;
    public static int solution() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 9) {
                    curx = i;
                    cury = j;
                    break;
                }
            }
        }
        
        int s = 2;
        map[curx][cury] = 0;
        while(true) {
            for(int i = 0; i < s; i++) {
                if(!bfs(s)) return answer;
            }
            s++;
        }
    }

    public static boolean bfs(int s) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{curx, cury});
        int[][] visited = new int[n][n];
        visited[curx][cury] = 1;

        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int t = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            List<int[]> fishes = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                if(map[x][y] != 0 && map[x][y] < s) {
                    fishes.add(new int[]{x, y});
                }

                for(int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if(visited[nx][ny] == 0 && map[nx][ny] <= s) {
                            visited[nx][ny] = 1;
                            q.add(new int[]{nx, ny});
                       }
                    }
                }
            }

            if(!fishes.isEmpty()) {
                fishes.sort((a, b) -> {
                    if(a[0] == b[0]) return a[1] - b[1];
                        return a[0] - b[0];
                    });
                int[] target = fishes.get(0);
                curx = target[0];
                cury = target[1];
                map[target[0]][target[1]] = 0;
                answer += t;
                return true;
                
            }
            t++;
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        System.out.println(solution());
    }
}