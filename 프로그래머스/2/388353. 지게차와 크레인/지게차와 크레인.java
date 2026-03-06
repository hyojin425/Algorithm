import java.util.*;
class Solution {
    static char[][] store;
    static int n, m;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
         n = storage.length;
         m = storage[0].length();
        store = new char[n][m];
        for(int i = 0; i < n; i++) {
            store[i] = storage[i].toCharArray();
        }
        
        int[] dx = {0, -1, 1, 0};
        int[] dy = {1, 0, 0, -1};
        
        for(String s: requests) {
            char c = s.charAt(0);
            List<int[]> removes = new ArrayList<>();
            int[][] outside = new int[n][m];
            Queue<int[]> q = new LinkedList<>();
            for(int i= 0; i < n; i++) {
                for(int j = 0 ; j < m; j++) {
                    if((i == 0|| j == 0 || i == n - 1|| j == m -1) && store[i][j] == ' ') {
                        outside[i][j] = 1;
                        q.add(new int[]{i, j});
                    }
                }
            }
            while(!q.isEmpty()) {
                int[] tmp = q.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = tmp[0] + dx[i];
                    int ny = tmp[1] + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m 
                      && store[nx][ny] == ' ' && outside[nx][ny] == 0) {
                        outside[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            
            if(s.length() == 1) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(store[i][j] != c) continue;
                        if(i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                            removes.add(new int[]{i, j});
                        } else {
                            for(int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if(nx >= 0 && nx < n && ny >= 0 && ny < m 
                                && outside[nx][ny] == 1) {
                                    removes.add(new int[]{i, j});
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                for(int k = 0; k < n; k++) {
                    for(int l = 0; l < m; l++) {
                        if(store[k][l] == c) {
                            removes.add(new int[]{k, l});
                        }
                    }
                }
            }
            
            for(int[] r: removes) {
                store[r[0]][r[1]] = ' ';
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++ ){
                if(store[i][j] == ' ') answer++;
            }
        }
        System.out.println(answer);

        return n * m - answer;
    }
}