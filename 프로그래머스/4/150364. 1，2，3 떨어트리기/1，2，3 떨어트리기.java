import java.util.*;
class Solution {
    
    static List<List<Integer>> tree;
    static int[] next;
    static int[] cnt;
    static List<Integer> order;
    
    public int[] solution(int[][] edges, int[] target) {
        tree = new ArrayList<>();
        order = new ArrayList<>();
        int n = target.length;
        for(int i = 0; i <=n; i++) {
            tree.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i = 1; i <= n; i++) {
            Collections.sort(tree.get(i));
        }
        
        next = new int[n + 1];
        cnt = new int[n + 1];
        
        while(true) {
            int leaf = drop();
            cnt[leaf]++;
            order.add(leaf);
            
            if(cnt[leaf] > target[leaf - 1]) {
                return new int[]{-1};
            }
            
            boolean find = true;
            for(int i = 1; i <= n; i++) {
                if(tree.get(i).size() == 0 && cnt[i] * 3 < target[i - 1]) {
                    find = false;
                    break;
                }
            }
            
            if(find) break;
        }
        
        List<Integer> result = new ArrayList<>();
        for(int o: order) {
            cnt[o]--;
            for(int i = 1; i <=3; i++) {
                if(target[o - 1] - i <= cnt[o] * 3) {
                    result.add(i);
                    target[o - 1] -= i;
                    break;
                }
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    
    public static int drop() {
        int node = 1;
        while(tree.get(node).size() > 0) {
            int idx = next[node];
            int ch = tree.get(node).get(idx);
            next[node] = (idx + 1) % tree.get(node).size();
            node = ch;
        }
        
        return node;
    }
}