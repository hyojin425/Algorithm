
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = String.valueOf(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int len = str.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) arr[i] = c - 55;
            else arr[i] = Integer.parseInt(String.valueOf(c));
        }


        int answer = 0;
        for (int i = 0; i < len; i++) {
            double m = Math.pow(b, i);
            answer += arr[len - 1 - i] * m;
        }
        System.out.println(answer);
    }
}
