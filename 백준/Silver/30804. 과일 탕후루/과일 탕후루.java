import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();

        int f = 0;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while(map.size() > 2) {
                map.put(arr[f], map.get(arr[f]) -1);
                if(map.get(arr[f]) == 0) map.remove(arr[f]);
                f++;
            }
            answer = Math.max(answer, i - f + 1);
        }
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
         int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(solution(arr, n));
    }
}