import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void solution(int n, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int a: arr) {
            set.add(a);
        }

        List<Integer> list = new ArrayList<>(set);
        list.sort(null);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(map.get(a)).append(" ");
        }
        System.out.println(sb);
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        solution(n, arr);
    }
}