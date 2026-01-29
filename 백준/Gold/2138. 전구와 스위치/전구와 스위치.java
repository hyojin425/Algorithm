import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int solution(int n, int[] arr, int[] target, boolean first) {
        int answer = 0;
        if(first) answer = 1;
        for(int i = 1; i< n; i++) {
            if(arr[i - 1] != target[i - 1]) {
                arr[i - 1] = (arr[i -1] + 1) % 2;
                arr[i] = (arr[i] + 1) % 2;

                if(i < n -1) arr[i + 1] = (arr[i + 1]+1) % 2;
                answer++;
            }
        }

        if(Arrays.equals(target, arr)) {
            return answer;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
            .toArray(); 
        int[] target = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
            .toArray(); 

        int[] tmp = arr.clone();
        tmp[0] = (tmp[0] + 1) % 2;
        tmp[1] = (tmp[1] + 1) % 2;
        int answer = Math.min(solution(n, arr, target, false), solution(n, tmp, target, true));

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}