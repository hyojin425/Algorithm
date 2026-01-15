import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void solution(int n, String ball) {
        List<Integer> red = new ArrayList<>();
        List<Integer> blue = new ArrayList<>();
        for(int i = 0; i< ball.length(); i++) {
            char c = ball.charAt(i);
            if(c == 'R') red.add(i);
            else blue.add(i);
        }

        int R1 = 0;
        int R2 = 0;
        int i = 0;
        for(int r: red) {
            if(r != i) R1++;
            if(r != i + blue.size()) R2++;
            i++;
        }
        int R = Math.min(R1, R2);

        int B1 = 0;
        int B2 = 0;
        i = 0;
        for(int b: blue) {
            if(b != i) B1++;
            if(b != i + red.size()) B2++;
            i++;
        }
        int B = Math.min(B1, B2);


        System.out.println(Math.min(B, R));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ball = br.readLine();

        solution(n, ball);
    }
}
