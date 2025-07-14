import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dy = new int[n + 1];

        if (n == 1) {
            System.out.println(1);
            return;
        }

        dy[1] = 1;
        dy[2] = 3;

        for (int i = 3; i <= n; i++) {
            dy[i] = (dy[i - 1] + 2 * dy[i - 2]) % 10007;
        }

        System.out.println(dy[n]);
    }
}