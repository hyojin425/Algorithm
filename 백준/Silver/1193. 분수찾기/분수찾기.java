import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        int m = 1;
        int a = 0, b = 0;

        while (cnt < n) {
            cnt += m;
            m++;
        }

        m--;
        cnt -= m;

        int l = n - cnt - 1;
        if (m % 2 == 0) {
            a = 1 + l;
            b = m - l;
        } else {
            a = m - l;
            b = 1 + l;
        }

        System.out.println(a + "/" + b);
    }
}
