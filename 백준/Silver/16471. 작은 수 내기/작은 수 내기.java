import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void solution(int n, int[] ju, int[] owner) {
        Arrays.sort(ju);
        Arrays.sort(owner);
        int cnt = 0;
        int ownerIdx = 0;
        for(int i = 0; i < n; i++) {
            while(ownerIdx < n && ju[i] >= owner[ownerIdx]) {
                    ownerIdx++;
            }

            if(ownerIdx >= n) {
                break;
            }

            if(ju[i] < owner[ownerIdx]) {
                ownerIdx++;
                cnt++;
            }
        }

        if(cnt >= (n + 1) / 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        int[] ju = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] owner = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution(n, ju, owner);
    }
}
