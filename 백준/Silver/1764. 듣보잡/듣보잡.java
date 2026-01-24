import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;


public class Main {

    public static void solution(int n, int m, String[] arr) {
        Map<String, Integer> person = new HashMap<>();
        for(int i = 0; i< n + m; i++) {
            person.put(arr[i], person.getOrDefault(arr[i], 0) + 1);
        }

        List<String> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> e: person.entrySet()) {
            if(e.getValue() > 1) {
                answer.add(e.getKey());
            }
        }
        System.out.println(answer.size());
        answer.sort(null);
        for(String s: answer) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int m = intArr[1];

        String[] arr = new String[n + m];
        for (int i = 0; i < m + n; i++) {
            arr[i] = br.readLine();
        }

        solution(n, m, arr);
    }
}
