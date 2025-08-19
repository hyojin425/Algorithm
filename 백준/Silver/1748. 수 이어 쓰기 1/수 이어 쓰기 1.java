import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.pow;


public class Main {
    public int solution(int n) {
        int answer = 0;
        int l = String.valueOf(n).length();
        for(int i = 1; i < l; i++){
            int first = (int) Math.pow(10, i - 1);
            int last = (int) Math.pow(10, i) -1;
            answer += (last - first + 1) * i;
        }
        int first = (int) Math.pow(10, l - 1);
        answer += (n - first + 1) * l;
        return answer;
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);

        int n  = scanner.nextInt();
        System.out.println(t.solution(n));
    }

}