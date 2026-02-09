import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int n;
    static List<List<int[]>> graph = new ArrayList<>();
    public static int bfs(int s, int end) {        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{s, 0});        
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[1] > dis[cur[0]]) continue;
            for(int[] e : graph.get(cur[0])) {
                if(dis[e[0]] > e[1] + cur[1]) {
                    dis[e[0]] = e[1] + cur[1];
                    q.add(new int[]{e[0], e[1]+ cur[1]});
                } 
            }
        }

        return (dis[end] == Integer.MAX_VALUE)? -1 : dis[end];
    }

    public static int solution(int a, int b) {
        int answer1 = 0;

        int dis1 = bfs(1, a);
        int dis2 = bfs(a, b);
        int dis3 = bfs(b, n);
        if(dis1 == -1 || dis2 == -1 ||dis3 == -1) {
            answer1 = Integer.MAX_VALUE;
        } else answer1 = dis1 + dis2 + dis3;
        
        int answer2 = 0;
         dis1 = bfs(1, b);
         dis2 = bfs(b, a);
         dis3 = bfs(a, n);
        if(dis1 == -1 || dis2 == -1 ||dis3 == -1) {
            answer2 = Integer.MAX_VALUE;
        } else answer2 = dis1 + dis2 + dis3;

        if(answer1 == Integer.MAX_VALUE && answer2 == Integer.MAX_VALUE) {
            return -1;
        }
        return Math.min(answer1, answer2);
    }
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = intArr[0];
        int m = intArr[1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i< m; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            graph.get(arr[0]).add(new int[]{arr[1], arr[2]});
            graph.get(arr[1]).add(new int[]{arr[0], arr[2]});
        }

       int[] v = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int a = v[0];
        int b = v[1];

        System.out.println(solution(a ,b));

    }
}