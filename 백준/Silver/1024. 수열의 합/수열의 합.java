import java.util.*;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long l = sc.nextInt();
        sc.close();

        boolean flag = false;

        for (long i = l; i <= 100 && !flag; i++) {
            long sum = 0;
            for (long j = 0; j < i; j++) {
                sum += j;
            }

            int first = 0;

            while (true) {
                if (sum == n) {
                    for(int k = 0; k < i; k++) {
                        System.out.print(first + k + " ");
                    }
                    flag = true;
                    break;
                }

                sum += i;
                first++;
                if(sum > n) break;
            }
        }

        if(!flag) System.out.println(-1);
    }
}