import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {64, 32, 16, 8, 4, 2, 1};
        int x = sc.nextInt();
        int cnt = 0;
        for (int c : arr) {
            if (x >= c) {
                cnt++;
                x -= c;
            }
            if (x == 0) break;
        }
        System.out.println(cnt);
    }
}