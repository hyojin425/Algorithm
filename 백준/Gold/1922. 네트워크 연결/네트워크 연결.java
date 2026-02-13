import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static List<List<int[]>> graph = new ArrayList<>();
    static int n;

    public static int solution(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});
        
        int[] ch = new int[n + 1];
        
        int answer = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(ch[cur[0]] == 0) {
                ch[cur[0]] = 1;
                answer += cur[1];
            }
            
            for(int[] next: graph.get(cur[0])) {
                if(ch[next[0]] == 0) {
                    pq.add(next);
                }
            }
        }

        return answer;
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
            graph.get(arr[1]).add(new int[]{arr[0], arr[2]});
        }

        System.out.println(solution());
    }
}