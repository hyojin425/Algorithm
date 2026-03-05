import java.util.*;
class Solution {
    public int solution(int[][] game_board, int[][] table) {
        n = table.length;
        m = table[0].length;
        int answer = 0;
        
        ch = new int[n][n];
        // 빈칸
        List<List<int[]>> blanks = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(game_board[i][j] == 0 && ch[i][j] == 0) {
                    List<int[]> blank = bfs(game_board, i, j, 0);
                    blanks.add(blank);
                }
            }
        }
        
        ch = new int[n][n];
        // 블록
        List<List<int[]>> blocks = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(table[i][j] == 1 && ch[i][j] == 0) {
                    List<int[]> block = bfs(table, i, j, 1);
                    blocks.add(block);
                }
            }
        }
        
        int[] used = new int[blocks.size()];
        for(List<int[]> b: blanks) {
            boolean found = false;
            for(int i = 0; i < blocks.size(); i++) {
                if(blocks.get(i).size() != b.size()) continue;
                if(used[i] == 1) continue;
                
                List<int[]> rotate = blocks.get(i);
                for(int j = 0; j < 4; j++) {
                    rotate = rotate(rotate);
                    if(match(rotate, b)) {
                        used[i] = 1;
                        answer += b.size();
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }
        }
        return answer;
    }
    
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int n, m;
    static int[][] ch;
    public static List<int[]> bfs(int[][] board, int x, int y, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{0,0});
        
        ch[x][y] = 1;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m
                   && ch[nx][ny] == 0 && board[nx][ny] == target) {
                    ch[nx][ny] = 1;
                    q.add(new int[]{nx, ny});
                    result.add(new int[]{nx - x, ny - y});
                }
            }
        }
        return normalize(result);
    }
    
    public static List<int[]> normalize(List<int[]> list) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int[] l: list) {
            minX = Math.min(minX, l[0]);
            minY = Math.min(minY, l[1]);
        }
        
        List<int[]> result = new ArrayList<>();
        for(int[] p: list){
            result.add(new int[]{p[0] - minX, p[1] - minY});
        }
        
        result.sort((a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        return result;
    }
    
    public static List<int[]> rotate(List<int[]> points) {
        List<int[]> result = new ArrayList<>();
        
        for(int[] p: points) {
            result.add(new int[]{p[1], -p[0]});
        }
        return normalize(result);
    }
    
    public static boolean match(List<int[]> a, List<int[]> b) {
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
}