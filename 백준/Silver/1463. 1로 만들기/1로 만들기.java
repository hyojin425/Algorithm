import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.exit;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dy = new int[n + 1];

        dy[1] = 0;
        if (n >= 2) dy[2] = 1;
        if (n >= 3) dy[3] = 1;

        for (int i = 4; i <= n; i++) {
            int result = Integer.MAX_VALUE;
            if ((i % 3) == 0) {
                result = Math.min(result, dy[i / 3] + 1);
            }
            if ((i % 2) == 0) {
                result = Math.min(result, dy[i / 2] + 1);
            }
            result = Math.min(result, dy[i - 1] + 1);
            dy[i] = result;
        }

        System.out.println(dy[n]);

    }
}