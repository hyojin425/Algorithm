import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.System.exit;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(s -> Math.abs(Integer.parseInt(s) - arr[1]))
                .toArray();

        if (arr[0] == 1) {
            System.out.println(nums[0]);
            exit(0);
        }

        int d = gcd(nums[1], nums[0]);
        for(int i = 2; i < nums.length; i++) {
            d = gcd(d, nums[i]);
        }
        System.out.println(d);
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}