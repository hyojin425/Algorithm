import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static long solution(int m, int[] arr, int n) {
        Arrays.sort(arr);
        long min = 1;
        long max = arr[n - 1];
        long answer = 0;
        while(min <= max) {
            long mid = (min + max) / 2;
            if(check(arr, mid, m)) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }

    public static boolean check(int[] arr, long price, int m) {
        long sum = 0;
        for (int a : arr) {
            if(a > price) {
                sum += price;
            } else {
                sum += a;
            }
        }

        return sum <= m;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int m = Integer.parseInt(br.readLine());
        System.out.println(solution(m, arr, n));
    }
}
