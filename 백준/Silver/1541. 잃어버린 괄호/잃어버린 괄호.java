import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int solution(String str) {
        int num = 0;
        int sum = 0;
        int answer = 0;
        boolean minus = false;

        int n = str.length();
        int i = 0;
        for(i = 0; i < n; i++) { 
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                answer += num;
                num = 0;
                if(c == '-') {
                    minus = true;
                    break;
                }
            }
        }
        
        for(int j = i + 1; j < n; j++) {
            char c = str.charAt(j);
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                sum += num;
                num = 0;
                if(c == '-') {
                    answer -= sum;
                    sum = 0;
                }
            }
        }

        if(minus) {
            sum += num;
            answer -= sum;   
        } else {
            answer += num;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}