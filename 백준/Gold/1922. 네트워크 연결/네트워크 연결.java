import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static List<int[]> graph = new ArrayList<>();
    static int n, m;

    static int[] unf;
    public static int find(int v) {
        if(unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static int solution(){
        graph.sort((a, b) -> a[2] - b[2]);

        int answer = 0;
        for(int i = 0; i < m; i++) {
            int[] tmp = graph.get(i);
            if(find(tmp[0]) != find(tmp[1])) {
                union(tmp[0], tmp[1]);
                answer += tmp[2];
            }
        }
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        unf = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            unf[i] = i;
        }
        
        for(int i = 0; i < m; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            graph.add(new int[]{arr[0], arr[1], arr[2]});
        }

        System.out.println(solution());
    }
}