import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.reverse;


public class Main {

    public static void solution(int[][] arr, int n) {
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i< n; i++) {
            lines.add(new Line(arr[i][0], arr[i][1]));
        }
        Collections.sort(lines);
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for(int i = 1; i < n; i++){
            Line cur = lines.get(i);
            for(int j = i - 1; j >=0; j--){
                if(cur.b >= lines.get(j).b) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i: dp) {
            max = Math.max(i, max);
        }
        System.out.println(n - max);
    }

    public static class Line implements Comparable<Line>{
        int a;
        int b;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Line o) {
            if(o.a == this.a) {
                return this.b - o.b;
            }
            return this.a - o.a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            arr[i][0] = intArr[0];
            arr[i][1] = intArr[1];
        }
        solution(arr, n);
    }
}
