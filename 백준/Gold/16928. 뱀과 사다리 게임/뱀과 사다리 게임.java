import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    public static void solution(int n, int m, int[][] arr) {
        int[] visited = new int[101];
        int[] board = new int[101];
        for(int i = 0; i < n + m; i++) {
            board[arr[i][0]] = arr[i][1];
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 1;
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int tmp = queue.poll();
                if(tmp == 100) {
                    System.out.println(L);
                    return;
                }
                for(int j = 1; j <= 6; j++) {
                    int next = tmp + j;
                    if(next <= 100 && board[next] !=0) {
                        next = board[next];
                    }

                    if(next <= 100 && visited[next] == 0) {
                        queue.add(next);
                        visited[next] = 1;
                    }
                }
            }
            L++;

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int m = intArr[1];

        int[][] arr = new int[n + m][2];

        for(int i = 0; i < n + m; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        solution(n, m, arr);
    }
}
