
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long l = sc.nextInt();
        sc.close();

        boolean flag = false;
        for (long i = l; i <= 100 && !flag; i++) {
            long sum = (i * (i - 1)) / 2;
            long idx = 0;

            while (true) {
                if (sum == n) {
                    for (long k = 0; k < i; k++) {
                        System.out.print(k + idx + " ");
                    }
                    flag = true;
                    break;
                }

                sum += i;
                idx++;
                if (sum > n) break;
            }
        }

        if (!flag) System.out.println(-1);

    }


}
