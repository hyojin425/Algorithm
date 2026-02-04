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
       int next = arr[cur];

       if(visited[next] == 1) {
           if(path[next] == 1) {
               int tmp = next;
               answer.add(tmp);
               while(next != arr[tmp]) {
                   tmp = arr[tmp];
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
        System.out.println(answer.size());
        List<Integer> a = new ArrayList<>(answer);
        a.sort(null);
        for(int i : a){
            System.out.println(i);
        }
    }
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new int[ n+ 1];
        path = new int[n + 1];
        arr= new int[n + 1];
        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        solution();
    }
}