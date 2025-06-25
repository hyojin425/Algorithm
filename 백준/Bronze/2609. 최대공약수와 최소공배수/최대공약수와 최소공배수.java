import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = gcd(nums[0], nums[1]);

        System.out.println(result);
        System.out.println((nums[0] * nums[1]) / result);
    }

    public static int gcd(int a, int b) {
        while(b > 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}