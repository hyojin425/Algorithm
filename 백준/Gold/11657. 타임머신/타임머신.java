import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void solution(List<int[]> map, int n, int m) {
        long[] dis =  new long[n + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[1] = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int[] edge: map) {
                if(dis[edge[0]] != Long.MAX_VALUE 
                   && dis[edge[0]] + edge[2] < dis[edge[1]]) {
                    dis[edge[1]] = dis[edge[0]] + edge[2];
                }
            }
        }

        for(int[] edge: map) {
            if(dis[edge[0]] != Long.MAX_VALUE 
               && dis[edge[0]] + edge[2] < dis[edge[1]]) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 2; i <= n; i++) {
            if(dis[i] == Long.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dis[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int m = intArr[1];
        List<int[]> map = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            map.add(Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray());
        }
        solution(map, n , m);
    }
}