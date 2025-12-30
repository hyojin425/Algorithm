import java.util.Scanner;

public class Main {

    public static int solution(int h, int w, int n, int m) {
        int answer = 1;
        if(h % (n + 1) == 0) {
            answer *= h /( n + 1);
        } else {
            answer *= h /(n + 1) + 1;
        }

        if(w % (m + 1) == 0) {
            answer *= w /( m + 1);
        } else {
            answer *= w /(m + 1) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(h, w, n, m));
    }
}