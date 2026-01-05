import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    static boolean answer = false;

    public static void DFS(String s, StringBuilder t) {
        if (t.length() == s.length()) {
            if (t.toString().equals(s)) {
                answer = true;
            }
        } else {
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
                DFS(s, t);
                t.append('A');
            }
            if (t.charAt(0) == 'B') {
                t.reverse();
                t.deleteCharAt(t.length() - 1);
                DFS(s, t);
                t.append('B');
                t.reverse();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] arr = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
        String s = br.readLine();
        String n = br.readLine();
        StringBuilder t = new StringBuilder(n);
        DFS(s, t);
        System.out.println(answer ? 1 : 0);
    }
}
