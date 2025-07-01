import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = arr[0];
        int m = arr[1];
        int r = n - m;

        int fiveCnt = count(n, 5) - count(m, 5) - count(r, 5);
        int twoCnt = count(n, 2) - count(m, 2) - count(r, 2);

        System.out.println(Math.min(fiveCnt, twoCnt));
    }

    public static int count(int m, int n) {
        int cnt = 0;
        while (m >= n) {
            cnt += m/n;
            m /= n;
        }
        return cnt;
    }
}