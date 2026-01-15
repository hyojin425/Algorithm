import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.reverse;


public class Main {

    public static void solution(int[] arr, int n) {
        Arrays.sort(arr);
        int answer = 0;
        int cnt = 0;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            cnt++;
            if(cnt % 3 == 0) {
                answer += sum;
                sum = 0;
                cnt = 0;
            } else {
                sum += arr[i];
            }
        }
        answer += sum;
        System.out.println(answer);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        solution(arr, n);

    }
}
