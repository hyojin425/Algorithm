
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            q.add(scoville[i]);
        }
        
        while(q.size() >= 2 && q.peek() < K) {
            int min1 = q.poll();
            int min2 = q.poll();
            q.add(min1 + min2 *2);
            answer++;
        }
        
        if(q.peek() < K) return -1;
        return answer;
    }
}