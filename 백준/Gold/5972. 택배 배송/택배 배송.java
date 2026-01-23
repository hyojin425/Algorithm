import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static class Edge implements Comparable<Edge>{
        int x;
        int weight;

        public Edge(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            if(o.weight == this.weight) {
                return o.x - this.x;
            }
            return this.weight - o.weight;
        }
    }

    public static int solution(int n , int m , int[][] arr) {
        List<List<Edge>> map = new ArrayList<>();
        for(int i = 0; i<= n; i++) {
            map.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            map.get(arr[i][0]).add(new Edge(arr[i][1], arr[i][2]));
            map.get(arr[i][1]).add(new Edge(arr[i][0], arr[i][2]));
        }

        int[] dis = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(1, 0));
        while(!q.isEmpty()) {
            Edge tmp = q.poll();
            int x = tmp.x;
            int w = tmp.weight;
            for(Edge e: map.get(x)) {
                if(dis[e.x] > w + e.weight) {
                    dis[e.x] = w + e.weight;
                    q.add(new Edge(e.x, dis[e.x]));
                }
            }
        }

        return dis[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int m = intArr[1];

        int[][] arr = new int[m][3];
        for(int i = 0; i< m; i++) {
            arr[i] =  Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(solution(n, m, arr));

    }
}
