import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int n;
    static int[] arr;
    static int answer = 0;
    public static void dfs(int dept) {
        if(dept == n) answer++;
        else {
            for(int i = 0;i < n; i++) {
                arr[dept] = i;
                if(check(dept)) {
                    dfs(dept + 1);
                }
            }
        }
    }

    public static boolean check(int dept) {
        for(int i = 0; i < dept; i++) {
            if(arr[dept] == arr[i]) return false;
            else if(Math.abs(i - dept)
                == Math.abs(arr[i] - arr[dept])) return false;
        }

        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        Arrays.fill(arr, -1);
        dfs(0);
        System.out.println(answer);
    }
}