import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
    
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else {
                char ch = s.charAt(i); 

                if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        
        return stack.isEmpty() ? 1:0;
    }
}