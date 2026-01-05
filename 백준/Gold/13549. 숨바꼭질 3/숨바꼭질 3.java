import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;

public class Main {

    static int[] map = new int[1_000_001];

    public static int solution(int n, int k) {
        Deque<Location> d = new LinkedList<>();
        d.add(new Location(n, 0));
        map[n] = 1;
        while (!d.isEmpty()) {
            Location tmp = d.poll();
            int l = tmp.location;
            int t = tmp.time;

            if (l == k) {
                return t;
            }

            if (l + 1 < map.length && map[l + 1] > t + 1) {
                d.addLast(new Location(l + 1, t + 1));
                map[l + 1] = t + 1;
            }
            if (l - 1 >= 0 && map[l - 1] > t + 1) {
                d.addLast(new Location(l - 1, t + 1));
                map[l - 1] = t + 1;
            }
            if (l * 2 < map.length && map[l * 2] > t) {
                d.addFirst(new Location(l * 2, t));
                map[l * 2] = t;
            }
        }
        return 0;
    }

    public static class Location {
        int location;
        int time;

        public Location(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arr[0];
        int k = arr[1];
        Arrays.fill(map, Integer.MAX_VALUE);
        System.out.println(solution(n, k));
    }
}
