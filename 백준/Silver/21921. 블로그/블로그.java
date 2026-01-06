import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void solution(int x, int[] arr) {

        // 초기
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        int cnt = 1;
        int max = sum;
        for (int i = 0; i < arr.length - x; i++) {
            int target = arr[i + x] - arr[i];
            sum += target;
            if(sum == max) {
                cnt++;
            } else if(sum > max) {
                max = sum;
                cnt = 1;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int x = intArr[1];

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        solution(x, arr);

//        String s = br.readLine();
//        String n = br.readLine();
    }
}
