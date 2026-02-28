import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            q.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        while(!q.isEmpty()) {
            int tmp = q.poll();
            int cnt = 1;
            while(!q.isEmpty() && tmp >= q.peek()) {
                q.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        
        return answer;
    }
}