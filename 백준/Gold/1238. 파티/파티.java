import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;


public class Main {

    public static class Edge implements Comparable<Edge>{
        int to;
        int w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static List<List<Edge>> map = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;
    public static void solution(int n, int m, int k, int[][] arr) {
        for(int i =0; i<= n; i++) {
            map.add(new ArrayList<>());
        }
        for(int i = 0; i< m; i++){
            map.get(arr[i][0]).add(new Edge(arr[i][1], arr[i][2]));
        }

        for(int i = 1; i <= n; i++) {
            int sum = BFS(i, k, n) + BFS(k, i, n);
            answer = Math.max(answer, sum);
        }
    }

    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static int BFS(int start, int k, int n) {
        pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        int dis[] = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(dis[cur.to] < cur.w) continue;

            for(Edge next: map.get(cur.to)) {
                int nextW = cur.w + next.w;
                if(dis[next.to] > nextW) {
                    dis[next.to] = nextW;
                    pq.add(new Edge(next.to, nextW));
                }
            }
        }

        return dis[k];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int m = intArr[1];
        int k = intArr[2];

        int[][] arr = new int[m][3];
        for(int i = 0; i < m; i++) {
            arr[i] =  Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        solution(n, m, k, arr);
        System.out.println(answer);
    }
}
