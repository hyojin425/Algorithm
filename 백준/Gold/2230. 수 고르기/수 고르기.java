import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = 1;
        int answer = Integer.MAX_VALUE;
        while(right < n) {
            int diff = arr[right] - arr[left];
            if(diff < m) {
                right++;
            } else {
                left++;
                answer = Math.min(answer, diff);

                if(diff == m) {
                    return diff;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arr[0];
        int m = arr[1];

        int[] arr1 = new int[n];
        for(int i = 0; i <n; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(n, m, arr1));
    }
}