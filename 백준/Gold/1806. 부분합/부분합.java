import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int n, int s, int[] arr) {
        int min = 0;
        int max = n;
        int answer = 0;
        while(min <= max) {
            int mid = (min + max) / 2;
            if(check(mid, s, arr, n)) {
                max = mid -1;
                answer = mid;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }
    public static boolean check(int mid, int s, int[] arr, int n) {
        int sum = 0;
        for(int i = 0; i < mid; i++) {
            sum+= arr[i];
        }
        if(sum >= s) {
            return true;
        }

        for(int i =0; i < n - mid; i++) {
            int v = arr[i + mid] - arr[i];
            sum += v;
            if(sum >= s) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int s = intArr[1];
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(n, s, arr));
    }
}