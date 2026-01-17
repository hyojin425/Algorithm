import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void solution(int n, int[][] ban) {
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 5; k++) {
                    if(ban[i][k] == ban[j][k]) {
                        answer[i]++;
                        break;
                    }

                }
            }
        }

        int max = 0;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(max < answer[i]){
                max = answer[i];
                idx = i;
            }
        }
        System.out.println(idx + 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ban = new int[n][5];
        for(int i =0; i< n; i++) {
            ban[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        solution(n, ban);

    }
}
