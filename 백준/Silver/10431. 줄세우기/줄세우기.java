import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        int answer = 0;
        List<Integer> sorted = new ArrayList<>();
        sorted.add(arr[0]);
        for(int i = 1; i < 20; i++) {
            int cur = sorted.size();
            for(int j = 0; j < sorted.size(); j++) {
                if(sorted.get(j) > arr[i]) {
                    cur = j;
                    answer += sorted.size() - cur;
                    break;
                }
            }
            sorted.add(cur, arr[i]);

        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            int[] arr = new int[20];
            for (int j = 0; j < 20; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(idx + " " + solution(arr));
        }
    }
}