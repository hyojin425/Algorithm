import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void solution(String str) {
        int cntX = 0;
        int cntO = 0;
        for(char c: str.toCharArray()) {
            if(c == 'X') {
                cntX++;
            }
            if(c == 'O') {
                cntO++;
            }
        }

        if(cntO > cntX) {
            System.out.println("invalid");
        } else if(cntO == cntX && cntO != 0) {
            if(check(str, 'O') && !check(str, 'X')) {
                System.out.println("valid");
            } else System.out.println("invalid");
        } else if(cntX - cntO == 1) {
            if(check(str, 'X') && !check(str, 'O')) {
                System.out.println("valid");
            } else if(cntX == 5 && cntO == 4 && !check(str,'O')) {
                System.out.println("valid");
                      } else System.out.println("invalid");
        } else System.out.println("invalid");
    }

    public static boolean check(String str, char c) {
        // 가로
        for(int i =0; i< 7; i+=3) {
            if(str.charAt(i) == c && 
               str.charAt(i+1) == c&&
               str.charAt(i+2) == c){
                return true;
               }
        }

        // 세로
        for(int i =0; i< 3; i++) {
            if(str.charAt(i) == c && 
               str.charAt(i+3) == c&&
               str.charAt(i+6) == c) {
                return true;
               }
        }

        // 대각선
        if(str.charAt(0) == c && 
               str.charAt(4) == c&&
               str.charAt(8) == c) {
                return true;
               }

        if(str.charAt(2) == c && 
               str.charAt(4) == c &&
               str.charAt(6) == c) {
                return true;
               }

        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while(!str.equals("end")) {
            str = br.readLine();
            if(!str.equals("end")) {
                solution(str);
            }
        }
    }
}