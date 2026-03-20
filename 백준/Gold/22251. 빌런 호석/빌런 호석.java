import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int n ,int k, int p, int x) {
        int[][] led = new int[10][7];
        led[0] = new int[]{1, 1, 1, 0, 1, 1, 1};
        led[1] = new int[]{0, 0, 1, 0, 0, 0, 1};
        led[2] = new int[]{0, 1, 1, 1, 1, 1, 0};
        led[3] = new int[]{0, 1, 1, 1, 0, 1, 1};
        led[4] = new int[]{1, 0, 1, 1, 0, 0, 1};
        led[5] = new int[]{1, 1, 0, 1, 0, 1, 1};
        led[6] = new int[]{1, 1, 0, 1, 1, 1, 1};
        led[7] = new int[]{0, 1, 1, 0, 0, 0, 1};
        led[8] = new int[]{1, 1, 1, 1, 1, 1, 1};
        led[9] = new int[]{1, 1, 1, 1, 0, 1, 1};

        int[][] map = new int[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                for(int m = 0; m < 7; m++) {
                    if(led[i][m] != led[j][m]) map[i][j]++;
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(i == x) continue;
            int diffCount = 0;
            int target = i;
            int current = x;


            for (int j = 0; j < k; j++) {
                diffCount += map[current % 10][target % 10];
                current /= 10;
                target /= 10;
            }

            if (diffCount <= p) { 
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(arr[0], arr[1], arr[2], arr[3]));
    }
}