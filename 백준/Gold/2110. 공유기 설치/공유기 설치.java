import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static long solution(int m, int[] arr, int n) {
        Arrays.sort(arr);
        long min = 1;
        long max = arr[n - 1] - arr[0];
        long answer = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            if (check(mid, arr, m)) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }

    public static boolean check(long dis, int[] arr, int m) {
        int cnt = 1;
        int last = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - last >= dis) {
                cnt++;
                last = arr[i];
            }
        }

        return cnt >= m;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nums[0];
        int m = nums[1];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(m, arr, n));
    }
}