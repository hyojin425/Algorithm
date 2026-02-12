import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static long MOD = 1_000_000_007L;

    static int[] dis;
    static int n;
    static List<List<int[]>> graph = new ArrayList<>();
    public static int getFar(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        dis[start] = 0;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int v = tmp[0];
            int c = tmp[1];
            for(int[] next: graph.get(v)){
                if(dis[next[0]] == -1) {
                    dis[next[0]] = c + next[1];
                    q.add(new int[]{next[0], c + next[1]});
                }
            }
        }

        int answer = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            if(max < dis[i]) {
                answer = i;
                max = dis[i];
            }
        }

        return answer;
    }

    public static int solution() {
        dis = new int[n + 1];
        Arrays.fill(dis, -1);
        int a = getFar(1);

        Arrays.fill(dis, -1);
        int b = getFar(a);

        return dis[b];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;

                int weight = Integer.parseInt(st.nextToken());
                graph.get(from).add(new int[]{to, weight});
            }
        }

        br.close();


        System.out.println(solution());
    }
}