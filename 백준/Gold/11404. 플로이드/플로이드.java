import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[][] dis;
    static int n;

    public static void solution(){
        for(int k= 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(dis[i][k] != Integer.MAX_VALUE && dis[k][j] != Integer.MAX_VALUE) {
                         dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);   
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n ; j++) {
                if(dis[i][j] == Integer.MAX_VALUE) System.out.print(0 + " ");
                else System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dis = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        for(int i = 1; i <= n; i++) {
            dis[i][i] = 0;
        }
        for(int i = 0; i < m; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            dis[arr[0]][arr[1]] = Math.min(dis[arr[0]][arr[1]], arr[2]);            
        }

        solution();
    }
}