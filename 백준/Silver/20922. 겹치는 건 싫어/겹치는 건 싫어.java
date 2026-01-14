import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void solution(int n, int k, int[] arr) {
        int left = 0;
        int[] nums = new int[100001];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[arr[i]]++;
            while(nums[arr[i]] > k) {
                nums[arr[left]]--;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int k = intArr[1];
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution(n, k, arr);
    }
}
