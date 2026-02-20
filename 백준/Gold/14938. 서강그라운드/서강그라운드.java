import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] item;
    static int n, m, r;
    static List<List<int[]>> graph = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void bfs(int s) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{s, 0});

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int v = tmp[0];
            int c = tmp[1];

            for(int[] next: graph.get(v)) {
                if(dis[next[0]] > c + next[1]) {
                    dis[next[0]] = c + next[1];
                    q.add(new int[]{next[0], c + next[1]});
                }
            }
        }

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            if(dis[i] <= m) sum += item[i -1];
        }
        answer = Math.max(answer, sum);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = intArr[0];
        m = intArr[1];
        r = intArr[2];

        item = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < r; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            graph.get(arr[0]).add(new int[]{arr[1], arr[2]});
            graph.get(arr[1]).add(new int[]{arr[0], arr[2]});
        }

        for(int i = 1; i <= n; i++) {
            bfs(i);
        }
        System.out.println(answer);
    }
}