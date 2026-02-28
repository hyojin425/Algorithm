import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && 
                  prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int i = stack.pop();
            answer[i] = prices.length - 1 - i;
        }
        
        return answer;
    }
}