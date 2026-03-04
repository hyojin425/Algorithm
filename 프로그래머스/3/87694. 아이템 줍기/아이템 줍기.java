import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int n = rectangle.length;
        int[][] map = new int[102][102];
        for(int i = 0; i < n; i++) {
            int[] tmp = rectangle[i];
            for(int j = tmp[0] * 2; j <= tmp[2] * 2; j++) {
                for(int k = tmp[1] * 2; k <= tmp[3] * 2; k++) {
                    map[j][k] = 1;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            int[] tmp = rectangle[i];
            for(int j = tmp[0] * 2 + 1; j < tmp[2] * 2; j++) {
                for(int k = tmp[1] * 2 + 1; k < tmp[3] * 2; k++) {
                    map[j][k] = 0;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX * 2, characterY * 2});
        int[][] dis = new int[102][102];
        dis[characterX * 2][characterY * 2] = 1;
        
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int i =0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx == itemX * 2 && ny == itemY * 2) return dis[x][y] / 2;
                
                if(nx >= 0 && nx < 102 && ny >= 0 && ny < 102 
                  && map[nx][ny] == 1 && dis[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    dis[nx][ny] = dis[x][y] + 1;
                }
            }
        }
        int answer = 0;
        return answer;
    }
}