import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for(int i = 1; i < n; i++) {
              for(int j = 0; j < i; j++) {
                  if (arr[i] > arr[j]) {
                      dp[i] = Math.max(dp[i], dp[j] + 1);
                  }
              }
        }

        int answer = 0;
        for (int i : dp) {
            answer = Math.max(i, answer);
        }

        System.out.println(answer);
    }
}