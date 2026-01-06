import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void solution(int k, String str) {
        List<Integer>[] idx = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            idx[i] = new ArrayList<>();
        }
        for (int i = 0; i < str.length(); i++) {
            idx[str.charAt(i) - 97].add(i);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean find = false;
        for (int i = 0; i < 26; i++) {
            List<Integer> list = idx[i];
            if (list.size() >= k) {
                for (int j = 0; j <= list.size() - k; j++) {
                    int size = list.get(j + k - 1) - list.get(j) + 1;
                    if (size < min) {
                        min = size;
                        find = true;
                    }
                    if (size > max) {
                        max = size;
                        find = true;
                    }
                }
            }
        }

        if(!find) {
            System.out.println(-1);
        } else {
            System.out.println(min + " " + max);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            solution(k, str);
        }

    }
}
