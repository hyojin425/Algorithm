import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    static char[] operation = {' ', '+', '-'};
    static char[] arr;
    static int n;
    public static void DFS(int l) {
        if(n - 1 == l) {
            StringBuilder formula = new StringBuilder();
            formula.append(1);
            for(int i = 0; i < l; i++) {
                formula.append(arr[i]);
                formula.append(i + 2);
            }

            String exp = formula.toString().replace(" ", "");
            int sum = 0;
            int num = 0;
            char sign = '+';
            for (int i = 0; i < exp.length(); i++) {
                char c = exp.charAt(i);

                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                } else {
                    sum += (sign == '+') ? num : -num;
                    sign = c;
                    num = 0;
                }
            }
            sum += (sign == '+') ? num : -num;

            if(sum == 0) {
                for(char c: String.valueOf(formula).toCharArray()) {
                    System.out.print(c);
                }
                System.out.println();
            }

        } else {
            for(int i = 0; i < 3; i++){
                arr[l] = operation[i];
                DFS(l + 1);

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i< t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new char[n - 1];
            DFS(0);

            if (i != t - 1) {
                System.out.println();
            }
        }
//        
    }
}
