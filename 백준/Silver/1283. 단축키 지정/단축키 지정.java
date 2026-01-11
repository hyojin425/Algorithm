import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    public static void solution(int n, String[] arr) {
        Set<Character> keys = new HashSet<>();
        for (String a : arr) {
            String lows = a.toLowerCase();
            int keyIdx = -1;

            String[] option = lows.split(" ");
            for (int i = 0; i < option.length; i++) {
                if (!keys.contains(option[i].charAt(0))) {
                    keys.add(option[i].charAt(0));
                    int pos = 0;
                    for (int j = 0; j < i; j++) {
                        pos += option[j].length() + 1;
                    }
                    keyIdx = pos;
                    break;
                }
            }

            if(keyIdx == -1) {
                for (int i = 1; i < lows.length(); i++) {
                    char cur = lows.charAt(i);
                    if (cur != ' ' & !keys.contains(cur)) {
                        keys.add(cur);
                        keyIdx = i;
                        break;
                    }
                }
            }

            if(keyIdx == -1) {
                System.out.println(a);
            } else {
                for(int i = 0; i < a.length(); i++) {
                    if(i == keyIdx) {
                        System.out.print("[" + a.charAt(i) + "]");
                    } else {
                        System.out.print(a.charAt(i));
                    }
                }
                System.out.println();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] =  br.readLine();
        }

        solution(n, arr);
    }
}
