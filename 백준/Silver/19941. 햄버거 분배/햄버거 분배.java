import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void solution(int n, int k, String burger) {
        int[] ate = new int[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if (burger.charAt(i) == 'P') {
                for(int j = i - k; j <= i + k; j++) {
                    if(j >= 0 && j < n && burger.charAt(j) == 'H' && ate[j] == 0) {
                        ate[j] = 1;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int k = intArr[1];
        String burger = br.readLine();
        solution(n, k, burger);
    }
}
