
import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int[][] dis = new int[n][m];
        for(int i =0 ; i < n; i++) {
            Arrays.fill(dis[i], -1);
        }
        dis[0][0] = 1;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            
            for(int i=0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 
                   && ny < m && maps[nx][ny] == 1 && dis[nx][ny] == -1) {
                    dis[nx][ny] = dis[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        return dis[n - 1][m - 1];
    }
}