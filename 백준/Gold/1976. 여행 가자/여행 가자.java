import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void solution(int n, int m, int[][] map, int[] target) {
        for(int i = 0; i< m - 1; i++) {
            if(!BFS(target[i], target[i + 1], map, n)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static boolean BFS(int start, int end, int[][] map, int n) {
        boolean answer = false;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n];
        visited[start - 1] = 1;
        q.add(start - 1);
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i =0 ; i< len; i++) {
                int tmp = q.poll();
                if(tmp == end - 1) {
                    return true;
                }
                for(int j = 0; j< n; j++) {
                    if(map[tmp][j] == 1 && visited[j] == 0) {
                        q.add(j);
                        visited[j] = 1;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0 ; i< n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray(); 
        }

        int[] target = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray(); 

        solution(n, m, map , target);
    }
}