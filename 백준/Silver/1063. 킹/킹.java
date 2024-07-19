
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String k = sc.next();
        String s = sc.next();
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        sc.close();


        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

        int i  = 9;
        for (String x : arr) {
            switch (x) {
                case "R" : i = 0; break;
                case "L" : i = 1; break;
                case "B" : i = 2; break;
                case "T" : i = 3; break;
                case "RT" : i = 4; break;
                case "LT" : i = 5; break;
                case "RB": i = 6; break;
                case "LB": i = 7; break;
            }
            char a1 = (char)(k.charAt(0) + dx[i]);
            int b1 = Integer.parseInt(String.valueOf(k.charAt(1)))+dy[i];
            char a2 = (char) (s.charAt(0) + dx[i]);
            int b2 = Integer.parseInt(String.valueOf(s.charAt(1)))+dy[i];

            String tmp = k;
            if(a1 > 64 && a1 < 73 && b1 > 0 && b1< 9) {
                k = k.replace(k.charAt(0), a1);
                k = k.replace(k.charAt(1),(char)(b1+ '0'));
                if(k.equals(s)){
                    if(a2 > 64 && a2 < 73 && b2 > 0 && b2 < 9){
                        s = s.replace(s.charAt(0), a2);
                        s = s.replace(s.charAt(1),(char)(b2+'0'));
                    } else {
                        k = tmp;
                    }
                }
            }
        }

        System.out.println(k);
        System.out.println(s);

    }

}
