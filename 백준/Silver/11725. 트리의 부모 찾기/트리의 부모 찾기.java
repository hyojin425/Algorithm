import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void solution(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] visited = new int[n + 1];
        visited[1] = 1;
        
        while(!q.isEmpty()) {
            int tmp = q.poll();
            for(int i = 0; i < tree.get(tmp).size(); i++) {
                int c = tree.get(tmp).get(i);
                if(visited[c] == 0) {
                    visited[c] = 1;
                    q.add(c);
                    map.put(c, tmp);
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            System.out.println(map.get(i));
        }
    }

    static List<List<Integer>> tree = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<= n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i< n - 1; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            tree.get(arr[0]).add(arr[1]);
            tree.get(arr[1]).add(arr[0]);
        }

        solution(n);
    }
}