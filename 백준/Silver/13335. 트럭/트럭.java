import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int n, int w, int l, int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i < w; i++) {
            q.add(0);
        }

        int sum = 0;
        int answer = 0;
        int i = 0;
        while(i < n) {
            answer++;
            sum -= q.poll();

            if(sum + arr[i] <= l) {
                q.add(arr[i]);
                sum += arr[i];
                i++;
            } else {
                q.add(0);
            }
        }

        if(sum != 0) {
            answer += w;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arr[0];
        int w = arr[1];
        int l = arr[2];

        int[] arr1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(n, w,l, arr1));
    }
}