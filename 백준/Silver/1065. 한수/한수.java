
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(i < 100) answer++;
            else {
                String s = Integer.toString(i);
                int l = s.length();
                int d = Integer.parseInt(String.valueOf(s.charAt(1))) - Integer.parseInt(String.valueOf(s.charAt(0)));
                boolean flag = true;
                for (int j = 2; j < l; j++) {
                    int a = Integer.parseInt(String.valueOf(s.charAt(j))) - Integer.parseInt(String.valueOf(s.charAt(j-1)));
                    if(a != d) flag = false;
                }
                if(flag) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }


}
