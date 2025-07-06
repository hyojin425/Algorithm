import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.exit;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        if (n == 0) {
            System.out.println(0);
            exit(0);
        }
        
        while (n != 0) {
            int m = n % (-2);
            n /= (-2);
            if (m < 0) {
                m += 2;
                n += 1;
            }
            result.append(m);
        }
        
        System.out.println(result.reverse());
    }
}