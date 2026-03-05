import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        for(int i = 0; i < n + 1; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        
        for(int i = 0; i < results.length; i++) {
            win.get(results[i][0]).add(results[i][1]);
            lose.get(results[i][1]).add(results[i][0]);
        }
        
        for(int i = 1; i<=n; i++) {
            if(check(i,n)) answer++;
        }
        
        return answer;
    }
    
    static List<List<Integer>> win = new ArrayList<>(); // 이긴 애들
    static List<List<Integer>> lose = new ArrayList<>(); // 진 애들
    public static boolean check(int s, int n) {
        int[] ch = new int[n + 1];
        ch[s] = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : win.get(cur)){
                if(ch[next] == 0) {
                    ch[next] = 1;
                    q.add(next);
                }
            }
        }
        
        q.add(s);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : lose.get(cur)){
                if(ch[next] == 0) {
                    ch[next] = 1;
                    q.add(next);
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(ch[i] == 0) return false;
        }
        return true;
    }
}