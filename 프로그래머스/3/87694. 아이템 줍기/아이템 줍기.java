import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        for(int[] r: rectangle) {
            int x1 = r[0];
            int y1 = r[1];
            int x2 = r[2];
            int y2 = r[3];
            for(int i = x1 * 2; i <= x2 * 2; i++) {
                for(int j = y1 * 2; j <= y2 * 2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        for(int[] r: rectangle) {
            int x1 = r[0];
            int y1 = r[1];
            int x2 = r[2];
            int y2 = r[3];
            for(int i = x1 * 2 + 1; i < x2 * 2; i++) {
                for(int j = y1 * 2 + 1; j < y2 * 2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX * 2, characterY * 2});
        map[characterX *2][characterY * 2] = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int dis = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            
            for(int j = 0; j < len; j++) {
                int[] tmp = q.poll();
                if(tmp[0] == itemX * 2 && tmp[1] == itemY * 2) {
                    return dis / 2;
                }
                for(int i = 0; i < 4; i++) {
                    int nx = tmp[0] + dx[i];
                    int ny = tmp[1] + dy[i];
                    if(nx <= 100 && nx >= 0 && ny <= 100 && ny >= 0 && 
                       map[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        map[nx][ny] = 0;
                    }
                }
            }
            dis++;
        }
        return 0;
    }
    
    
}