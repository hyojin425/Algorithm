import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int m = 0;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (m < arr[i]) {
                m = arr[i];
                idx = i;
            }
        }

        System.out.println(m);
        System.out.println(idx + 1);

    }
}