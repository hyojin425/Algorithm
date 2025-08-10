import java.util.Scanner;


public class Main {
    public static String solution(int n, int m) {
        if (n > m) {
            return ">";
        } else if (n < m) {
            return "<";
        } else {
            return "==";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(solution(n, m));

    }

}