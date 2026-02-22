import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
 
    public static void solution(int n, int[] a, int m, int[] b) {
        List<Integer> answer = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(true) {
            int max = Integer.MIN_VALUE;
            int ai = -1;
            int bj = -1;
            for(int x = i; x < n; x++) {
                for(int y = j; y < m; y++) {
                    if(a[x] == b[y] && max < a[x]) {
                        max = a[x];
                        ai = x;
                        bj = y;
                    }
                }
            }
            if(max == Integer.MIN_VALUE) break;
            answer.add(max);
            i = ai + 1;
            j = bj + 1;
        
        }
        
        System.out.println(answer.size());
        for(int v : answer) {
            System.out.print(v + " ");
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int m = Integer.parseInt(br.readLine());
        int[] b = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        solution(n, a, m, b);
    
    }
}