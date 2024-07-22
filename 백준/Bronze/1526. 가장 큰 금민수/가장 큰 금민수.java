
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = n; i >= 4; i--) {
            String s = Integer.toString(i);
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) != '7' && s.charAt(j) != '4') {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println(i);
                break;
            }
        }

    }


}
