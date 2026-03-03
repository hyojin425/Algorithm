import java.util.*;
class Solution {
    
    static int[] unf;
    public static int find(int v) {
        if(unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }
    
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        unf = new int[n];
        for(int i = 0; i <n; i++) {
            unf[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        for(int i = 0; i < costs.length; i++) {
            int a= costs[i][0];
            int b= costs[i][1];
            int cost = costs[i][2];
            
            if(find(a) != find(b)) {
                union(a, b);
                answer += cost;
            }
        }
        
        return answer;
    }
}