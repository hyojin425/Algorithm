import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            arr[i] = m;
        }

        int[] dy = new int[12];

        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        
        for(int i = 4; i <= 11; i++){
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }

        for (int i : arr) {
            System.out.println(dy[i]);
        }
    }
}