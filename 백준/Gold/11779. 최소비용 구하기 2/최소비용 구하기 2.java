import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    static List<List<int[]>> graph = new ArrayList<>();
    static int n;
    public static void solution(int start, int end) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{start, 0});

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;

        int[] prev = new int[n + 1];

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int v = tmp[0];
            int c = tmp[1];

            if(dis[v] < c) continue;
            for(int[] next: graph.get(v)) {
                if(dis[next[0]] > c + next[1]) {
                    dis[next[0]] = c + next[1];
                    prev[next[0]] = tmp[0];
                    q.add(new int[]{next[0], next[1] + c});
                }
            }
        }

        int tmp = end;
        Stack<Integer> stack = new Stack<>();
        while(tmp != start) {
            stack.push(tmp);
            tmp = prev[tmp];
        }
        stack.push(start);

        System.out.println(dis[end]);
        System.out.println(stack.size());

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            graph.get(arr[0]).add(new int[]{arr[1], arr[2]});
        }

        int[] startAndEnd = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution(startAndEnd[0], startAndEnd[1]);
    }
}