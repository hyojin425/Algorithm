import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static String solution(String str, String target) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> tmp = new Stack<>();

        int targetLen = target.length();

        int idx = targetLen - 2;
        for(char c: str.toCharArray()) {
            if(c == target.charAt(targetLen - 1)) {
                while(!stack.isEmpty() && idx >= 0 && target.charAt(idx) == stack.peek()) {
                    tmp.push(stack.pop());
                    idx--;
                }

                if(idx != -1) {
                    while(!tmp.isEmpty()) {
                         stack.push(tmp.pop());   
                    }
                    stack.push(c);
                    
                } else tmp.clear();
                idx = targetLen - 2;
            } else {
                stack.push(c);
            }
        }
        

        if(stack.isEmpty()) return "FRULA";

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String target = br.readLine();
        System.out.println(solution(str, target));
    }
}