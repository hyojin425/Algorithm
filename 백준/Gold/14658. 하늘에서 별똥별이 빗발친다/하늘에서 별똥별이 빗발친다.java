import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int n, int m, int l, int k, int[][] arr) {
        int answer = 0;

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                int x = arr[i][0];
                int y = arr[j][1];
    
                int cnt = 0;

                for(int s = 0; s < k; s++) {
                    if(arr[s][0] >= x && arr[s][0] <= x + l &&
                       arr[s][1] >= y && arr[s][1] <= y + l) {
                        cnt++;
                    }
                }

                answer = Math.max(answer, cnt);
            }
        }

        return k - answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] star = new int[arr[3]][2];
        for(int i = 0; i < arr[3]; i++) {
            star[i] =  Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        System.out.println(solution(arr[0], arr[1], arr[2], arr[3], star));
    }
}