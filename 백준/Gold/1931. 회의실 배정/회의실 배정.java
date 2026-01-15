import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.reverse;


public class Main {

    public static void solution(int[][] arr, int n) {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(arr[i][0], arr[i][1]));
        }
        Collections.sort(meetings);
        int answer = 1;
        int end = meetings.get(0).end;
        for (int i = 1; i < n; i++) {
            Meeting m = meetings.get(i);
            if(end <= m.start) {
                end = m.end;
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            arr[i][0] = intArr[0];
            arr[i][1] = intArr[1];
        }
        solution(arr, n);
    }
}
