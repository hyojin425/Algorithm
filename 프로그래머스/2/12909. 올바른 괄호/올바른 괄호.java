import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}