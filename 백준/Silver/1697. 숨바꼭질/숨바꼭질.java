import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] map = new int[1_000_001];

    public static int BFS(int k, int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        map[n] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                if(tmp == k) return answer;

                if(tmp + 1 < map.length && map[tmp + 1] == 0) {
                    q.add(tmp + 1);
                    map[tmp + 1] = 1;
                }
                if(tmp - 1 >= 0 && map[tmp -1] == 0) {
                    q.add(tmp - 1);
                    map[tmp -1] = 1;
                }
                if(tmp * 2 < map.length && map[tmp * 2] == 0) {
                    q.add(tmp * 2);
                    map[tmp * 2] = 1;
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arr[0];
        int k = arr[1];
        System.out.println(BFS(k, n));
    }
}
