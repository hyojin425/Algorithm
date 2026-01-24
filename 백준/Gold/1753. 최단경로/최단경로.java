import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            if(this.w == o.w) {
                return this.to - o.to;
            }
            return this.w - o.w;
        }
    }


    public static void solution(int n , int m, int k, int[][] arr) {
        List<List<Edge>> map = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        for(int i =0; i< m; i++) {
            map.get(arr[i][0]).add(new Edge(arr[i][1], arr[i][2]));
        }

        int[] dis = new int[n + 1];
        for(int i = 0; i<=n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(k, 0));
        dis[k] = 0;

        while(!q.isEmpty()) {
            Edge tmp = q.poll();
            int to = tmp.to;
            int w = tmp.w;
            for(Edge e: map.get(to)) {
                if(dis[e.to] > e.w + w) {
                    q.add(new Edge(e.to, e.w + w));
                    dis[e.to] = e.w + w;
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(dis[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dis[i]);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int m = intArr[1];

        int k = Integer.parseInt(br.readLine());

        int[][] arr = new int[m][3];
        for(int i = 0; i< m; i++) {
            arr[i] =  Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        solution(n, m, k, arr);
    }
}
