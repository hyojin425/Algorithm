import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void solution(int n) {
        if(n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }
        int cnt = n / 5;
        n %= 5;
        if(n % 2 != 0) {
            n += 5;
            cnt--;
        }
        cnt += n / 2;

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        solution(n);
    }
}
