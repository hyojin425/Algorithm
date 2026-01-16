import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void solution(int h, int w, int[] blocks) {
        int answer = 0;

        for (int i = 0; i < w; i++) {
            int b = blocks[i];
            int lMax = 0;
            for (int j = 0; j < i; j++) {
                lMax = Math.max(blocks[j], lMax);
            }
            int rMax = 0;
            for (int j = w - 1; j > i; j--) {
                rMax = Math.max(blocks[j], rMax);
            }
            int value = Math.min(lMax, rMax) - b;
            if (value > 0) {
                answer += value;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int h = intArr[0];
        int w = intArr[1];

        int[] blocks = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution(h, w, blocks);
    }
}
