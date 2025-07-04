import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder result = new StringBuilder();
        int[] arr = {1, 2, 4};

        int sum = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int j = (str.length() - 1 - i) % 3;
            sum += Integer.parseInt(String.valueOf(str.charAt(i))) * arr[j];
            if (j == 2 || i == 0) {
                result.append(sum);
                sum = 0;
            }
        }

        System.out.println(result.reverse());
    }
}