import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void solution(int n, int[] arr) {
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int max = 1;
        int lastIdx = 0;
        for(int i = 1; i< n; i++) {
            for(int j = i -1; j>= 0; j--) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if(max < dp[i]) {
                max = dp[i];
                lastIdx = i;
            }
        }

        Stack<Integer> stack = new Stack<>();
        while(lastIdx != -1) {
            stack.push(arr[lastIdx]);
            lastIdx = prev[lastIdx];
        }
        
        System.out.println(max);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() +  " ");
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution(n, intArr);
    }
}