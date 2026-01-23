import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void solution(int n, int[] arr) {
        int[] answer = new int[n];
        Stack<Top> stack = new Stack<>();

        stack.add(new Top(0, 0));
        stack.add(new Top(arr[0], 1));
        for(int i = 1; i< n; i++) {
            while(stack.peek().hight > 0 && stack.peek().hight < arr[i]) {
                stack.pop();
            }
            answer[i] = stack.peek().idx;
            stack.add(new Top(arr[i], i + 1));
        }

        for(int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static class Top {
        int hight;
        int idx;

        public Top(int hight, int idx) {
            this.hight = hight;
            this.idx =idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr =  Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution(n, arr);

    }
}
