import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void solution(int n, String[] arr) {
        int max = Integer.MIN_VALUE;
        String[] answer = new String[2];
        for(int i =0 ; i < n; i++) {
            String cur = arr[i];
            for(int j = i + 1; j < n; j++) {
                String t = arr[j];

                int len = Math.min(cur.length(), t.length());

                if(len <= max) continue;
                
                int cnt = 0;
                for(int k = 0; k < len; k++) {
                    if(cur.charAt(k) == t.charAt(k)) cnt++;
                    else break;
                }
                
                if(cnt > max) {
                    max = cnt;
                    answer[0] = cur;
                    answer[1] = t;
                }
            }
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        
        solution(n, arr);
    }
}
