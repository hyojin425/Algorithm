import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int m = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");

        int n = 0;
        for (int i = 0; i < m; i++) {
            n += Integer.parseInt(arr[i]) * Math.pow(a, m - 1 - i);
        }

        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
        } else {
            while (n > 0) {
                result.add(0, n % b);
                n /= b;
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}