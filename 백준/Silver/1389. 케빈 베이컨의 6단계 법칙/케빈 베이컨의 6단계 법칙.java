import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] answer;
    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    public static void solution(int[][] graph) {
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] a: graph) {
            list.get(a[0]).add(a[1]);
            list.get(a[1]).add(a[0]);
        }


        answer = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            bfs(i);
        }

        int min = Integer.MAX_VALUE;
        int result = -1;
        for(int i = 1; i <= n; i++) {
            if(answer[i] < min) {
                result = i;
                min = answer[i];
            }
        }

        System.out.println(result);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        dis[start] = 0;

        int l = 0;
        int sum = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int tmp = q.poll();
                for(int next: list.get(tmp)){
                    if(dis[next] == -1) {
                        q.add(next);
                        dis[next] = l + 1;
                        sum += dis[next];
                    }
                }
            }
            l++;
        }

        answer[start] = sum;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = intArr[0];
        int m = intArr[1];

        int[][] graph = new int[m][2];
        for(int i = 0; i < m; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        solution(graph);
    
    }
}