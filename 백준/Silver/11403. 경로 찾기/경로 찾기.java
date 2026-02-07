import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[][] graph;
    static int n;

    public static boolean bfs(int i , int j) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n];
        for(int k = 0 ; k< n; k++) {
            if(graph[i][k] == 1) {
                q.add(k);
            visited[k] = 1;
            }
        }

        while(!q.isEmpty()) {
            int tmp = q.poll();
            if(tmp == j) return true;
            for(int k = 0; k< n; k++) {
                if(graph[tmp][k]== 1 && visited[k] == 0) {
                    visited[k] = 1;
                    q.add(k);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i = 0; i< n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        for(int i = 0; i< n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print((bfs(i, j)? 1 : 0 )+ " ");
            }
            System.out.println();
        }

    }
}