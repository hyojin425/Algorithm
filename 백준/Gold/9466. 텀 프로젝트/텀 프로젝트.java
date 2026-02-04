import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] visited;
    static int[] path;
    static int[] arr;
    static int n;
    static Set<Integer> answer = new HashSet<>();

   public static void dfs(int cur) {
       visited[cur] = 1;
       path[cur] = 1;
       int next = arr[cur - 1];

       if(visited[next] == 1) {
           if(path[next] == 1) {
               int tmp = next;
               answer.add(tmp);
               while(next != arr[tmp -1]) {
                   tmp = arr[tmp -1];
                   answer.add(tmp);
               }
           }
       } else {
           dfs(next);
       }
       path[cur] = 0;
   }

    public static void solution() {
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        System.out.println(n - answer.size());
    }
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        for(int i = 0;i < t; i++) {
            n = Integer.parseInt(br.readLine());
            visited = new int[ n+ 1];
            path = new int[n + 1];
            arr = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();


            solution();
            answer = new HashSet<>();
        }
    }
}