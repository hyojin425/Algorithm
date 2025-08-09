import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static int solution(int n, int m, char[] arr) {
        int result = Math.abs(n - 100);

        for (int i = 0; i <= 999_999; i++) {
            boolean isContain = false;
            for (char c : arr) {
                if (String.valueOf(i).contains(String.valueOf(c))) {
                    isContain = true;
                }

            }
            if (!isContain) {
                result = Math.min(result, String.valueOf(i).length() + Math.abs(i - n));
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[] arr = new char[m];

        for (int i = 0; i < m; i++) {
            arr[i] = scanner.next().charAt(0);
        }
        System.out.println(solution(n, m, arr));

    }

}