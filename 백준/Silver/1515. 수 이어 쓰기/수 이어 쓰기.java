import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void solution(String str) {
        int num = 1;
        int strIdx = 0;
        while (true) {
            String cur = String.valueOf(num);
            for(char c: cur.toCharArray()) {
                if(strIdx < str.length() && c == str.charAt(strIdx)){
                    strIdx++;
                }
            }
            if(strIdx == str.length()) {
                System.out.println(num);
                break;
            }

            num++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        solution(s);
//        
    }
}
