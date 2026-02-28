import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            q.add(i);
            pq.add(priorities[i]);
        }
        
        while(!q.isEmpty()) {
            int tmp = q.poll();
            int max = pq.peek();
            if(priorities[tmp] < max) {
                q.add(tmp);
            } else {
                pq.poll();
                answer++;
                if(tmp == location) return answer;
            }
        }
        
        return answer;
    }
}