import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int n, int m, int[][] arr) {
        int answer = Integer.MIN_VALUE;

        // 1번
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j <= m - 4; j++) {
                answer = Math.max(answer, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3]);
            }
        }
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j <= n - 4; j++) {
                answer = Math.max(answer, arr[j][i] + arr[j + 1][i] + arr[j + 2][i] + arr[j + 3][i]);
            }
        }

        // 2번
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 1; j++) {
                answer = Math.max(answer, arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i+1][j+1]);
            }
        }

        int[][] dx = {{0, 1, 2, 2},
                   {0, 1, 2, 2},
                   {0, 0, 0, 1},
                   {0, 1, 0, 0},
                   {0, 0, 1, 2},
                   {0, 0, 1, 2},
                   {0, 1, 1, 1},
                   {0, 0, 0, -1}};
        int[][] dy = {{0, 0, 0, 1},
                   {0, 0, 0, -1},
                   {0, 1, 2, 2},
                   {0, 0, 1, 2},
                   {0, 1, 0, 0},
                   {0, 1, 1, 1},
                   {0, 0, 1, 2},
                   {0, 1, 2, 2}};
        // 3
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < 8; k++) {
                    int sum = 0;
                    boolean flag = true;
                    for(int l = 0; l < 4; l++) {
                        int nx = i + dx[k][l];
                        int ny = j + dy[k][l];
                        if(nx < n && nx >= 0 && ny < m && ny >= 0) {
                            sum += arr[nx][ny];
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }

        // 4
        int[][] dx1 = {{0, 1, 1, 2},
                      {0, 1, 1, 2},
                      {0, 0, -1, -1},
                      {0, 0, 1, 1}};
        int[][] dy1 = {{0, 0, 1, 1},
                      {0, 0, -1, -1},
                      {0, 1, 1, 2},
                      {0, 1, 1, 2}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < 4; k++) {
                    int sum = 0;
                    boolean flag = true;
                    for(int l = 0; l < 4; l++) {
                        int nx = i + dx1[k][l];
                        int ny = j + dy1[k][l];
                        if(nx < n && nx >= 0 && ny < m && ny >= 0) {
                            sum += arr[nx][ny];
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }

        // 5
        int[][] dx5 = {{0, 0, 0, 1},
                       {0, 1, 1, 2},
                       {0, 0, -1, 0},
                       {0, -1, 0, 1}};
        int[][] dy5 = {{0, 1, 2, 1},
                       {0, 0, 1, 0},
                       {0, 1, 1, 2},
                       {0, 1, 1, 1}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < 4; k++) {
                    int sum = 0;
                    boolean flag = true;
                    for(int l = 0; l < 4; l++) {
                        int nx = i + dx5[k][l];
                        int ny = j + dy5[k][l];
                        if(nx < n && nx >= 0 && ny < m && ny >= 0) {
                            sum += arr[nx][ny];
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        answer = Math.max(answer, sum);
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

        int[][] arr1 = new int[n][m];
        for(int i = 0; i <n; i++) {
            arr1[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        System.out.println(solution(n, m, arr1));
    }
}