import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void solution(int n, int d, int k, int c, int[] arr) {
        int[] cnt = new int[d + 1];
        int kind = 0;
        for(int i = 0; i < k; i++) {
            if(cnt[arr[i]] == 0) kind++;
            cnt[arr[i]]++;
        }

        int max = kind + (cnt[c] == 0? 1 : 0);
        for(int i = 0; i < n - 1; i++) {
            int left = arr[i];
            int right = arr[(i + k) % n];

            if (cnt[left] == 1) kind--;
            cnt[left]--;
            if (cnt[right] == 0) kind++;
            cnt[right]++;
            max = Math.max(kind + (cnt[c] == 0? 1 : 0), max);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int d = intArr[1];
        int k = intArr[2];
        int c = intArr[3];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution(n, d, k, c, arr);
    }
}
