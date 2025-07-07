import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int MAX = 1_000_000;

        // 소수 배열 초기화
        boolean[] isPrime = new boolean[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }

        // 소수가 아닌 수 false로 바꾸기
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (isPrime[i] == true) {
                int j = 2;
                while (i * j <= MAX) {
                    isPrime[i * j] = false;
                    j++;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int j = 2; j <= n / 2; j++) {
                if (isPrime[j] && isPrime[n - j]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}