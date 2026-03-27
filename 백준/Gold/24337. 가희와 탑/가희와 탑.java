import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void solution(int n ,int a, int b) {
        int max = Math.max(a, b);
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        if(a == 1) answer[0] = max; 
        else answer[n - b] = max;

        int c = 1;
        for(int i = n - 1; i > n - b; i--) {
            answer[i] = c;
            c++;
        }
        
        int v = 1;
        for(int i = n - b - a + 1; i < n - b; i++) {
            if(i < 0 || i > n) {
                System.out.println(-1);
                return;
            }
            answer[i] = v;
            v++;
        }

        int prev = answer[0];
        int cntA = 1;
        for(int i = 1; i < n; i++) {
            if(answer[i] > prev) {
                cntA++;
                prev = answer[i];
            }
        }

        prev = answer[n - 1];
        int cntB = 1;
        for(int i = n - 1; i >= 0; i--) {
            if(answer[i] > prev) {
                cntB++;
                prev = answer[i];
            }
        }

        if(cntA != a || cntB != b) System.out.print(-1);

        for(int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nab = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = nab[0];
        int a = nab[1];
        int b = nab[2];
        solution(n, a, b);
    }
}