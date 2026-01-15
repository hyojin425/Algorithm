import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.reverse;


public class Main {

    public static void solution(String n) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(Character c: n.toCharArray()){
            int digit = c - '0';
            list.add(digit);
            sum+= digit;

        }

        if (sum % 3 != 0 || !n.contains("0")) {
            System.out.println(-1);
            return;
        }

        Collections.sort(list, Collections.reverseOrder());
        for (int a : list) {
            System.out.print(a);
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String n = br.readLine();

        solution(n);
    }
}
