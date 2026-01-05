import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static long solution(int n, int[] arr) {
        long answer = 0;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(arr[i] > max){
                max = arr[i];
            } else {
                answer += max - arr[i];
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(solution(n, arr));
        }

//        String s = br.readLine();
//        String n = br.readLine();
    }
}
