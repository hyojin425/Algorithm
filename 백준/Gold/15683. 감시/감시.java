import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static List<int[]> cctv = new ArrayList<>();
    static int[][] map;
    static int n, m;
    public static void solution() {
        int cnt = 0;
        List<int[]> cctv5 = new ArrayList<>();
        for(int i =0; i < n; i++) {
            for(int j = 0; j <m; j++) {
                if(map[i][j] == 0) cnt++;
                if(map[i][j] > 0 && map[i][j] < 5) cctv.add(new int[]{i, j});
                if(map[i][j] == 5) cctv5.add(new int[]{i, j});
            }
        }

        // 5 찾기
        for(int[] c : cctv5) {
            int x = c[0];
            int y = c[1];

            // 세로
            int j = x + 1;
            while(j < n && map[j][y] != 6) {
                if(map[j][y] == 0) {
                    cnt--;
                    map[j][y] = -1;
                }
                j++;
            }
            j = x - 1;
            while(j >= 0 && map[j][y] != 6) {
                if(map[j][y] == 0) {
                    cnt--;
                    map[j][y] = -1;
                }
                j--;
            }

            // 가로
            j = y - 1;
            while(j >= 0 && map[x][j] != 6) {
                if(map[x][j] == 0) {
                    cnt--;
                    map[x][j]= -1;
                }
                j--;
            }
            j = y + 1;
            while(j < m && map[x][j] != 6) {
                if( map[x][j] == 0) {
                    cnt--;
                    map[x][j] = -1;
                }
                j++;
            }
        }
        rotate[1][0] = new int[]{3};
        rotate[1][1] = new int[]{4};
        rotate[1][2] = new int[]{1};
        rotate[1][3] = new int[]{2};

        rotate[2][0] = new int[]{1, 3};
        rotate[2][1] = new int[]{2, 4};
        rotate[2][1] = new int[]{1, 3};
        rotate[2][1] = new int[]{2, 4};

        rotate[3][0] = new int[]{2, 3};
        rotate[3][1] = new int[]{3, 4};
        rotate[3][2] = new int[]{4, 1};
        rotate[3][3] = new int[]{1, 2};

        rotate[4][0] = new int[]{1,2,3};
        rotate[4][1] = new int[]{2,3,4};
        rotate[4][2] = new int[]{3,4,1};
        rotate[4][3] = new int[]{4,1,2};

        arr = new int[cctv.size()];
        visited = new int[n][m];
        dfs(0);

        System.out.println(cnt - max);
    }

    static int[][][] rotate = new int[5][4][3];
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int[][] visited;
    public static void dfs(int l) {
        if(l == arr.length) {
            for(int i =0; i < n; i++) {
                Arrays.fill(visited[i], 0);
            }
            int cnt = 0;
            for(int i = 0; i < arr.length; i++) {
                int r = arr[i];
                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];
                int c = map[x][y];

                for(int v: rotate[c][r]) {
                    if(v == 1) {
                        int j = y - 1;
                        while(j >= 0 && map[x][j] != 6) {
                            if(map[x][j] == 0 && visited[x][j] == 0) {
                                cnt++;
                                visited[x][j] = 1;
                            }
                            j--;
                        }
                    }

                    if(v == 2) {
                        int j = x - 1;
                        while(j >= 0 && map[j][y] != 6) {
                            if(map[j][y] == 0 && visited[j][y] == 0) {
                                cnt++;
                                visited[j][y] = 1;
                            }
                            j--;
                        }
                    }

                    if(v == 3) {
                        int j = y + 1;
                        while(j < m && map[x][j] != 6) {
                            if(map[x][j] == 0 && visited[x][j] == 0) {
                                cnt++;
                                visited[x][j] = 1;
                            }
                            j++;
                        }
                    }

                    if(v == 4) {
                        int j = x + 1;
                        while(j < n && map[j][y] != 6) {
                            if(map[j][y] == 0 && visited[j][y] == 0) {
                                cnt++;
                                visited[j][y] = 1;
                            }
                            j++;
                        }
                    }
                }
            }
            max = Math.max(max, cnt);
        } else {
            for(int i = 0; i < 4; i ++) {
                arr[l] = i;
                dfs(l + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];
        map = new int[n][m];
        for(int i =0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        
        solution();
    }
}