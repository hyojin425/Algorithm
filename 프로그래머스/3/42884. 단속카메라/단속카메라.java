import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        int min = routes[0][0];
        int max = routes[0][1];
        for(int i = 1; i < routes.length; i++) {
            int[] cur = routes[i];
            if(cur[0] > max) {
                answer++;
                min = cur[0];
                max = cur[1];
            } else {
                min = Math.max(min, cur[0]);
                max = Math.min(max, cur[1]);
            }
        }
        return answer;
    }
}