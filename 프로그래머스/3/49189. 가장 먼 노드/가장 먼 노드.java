import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i <=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{1, 0});
        
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int next: graph.get(tmp[0])){
                if(dis[tmp[0]] + 1 < dis[next]) {
                    q.add(new int[]{next, tmp[1] + 1});
                    dis[next] = tmp[1] + 1;
                    max = Math.max(max, dis[next]);
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(dis[i] == max) answer++;
        }
        
        return answer;
    }
}