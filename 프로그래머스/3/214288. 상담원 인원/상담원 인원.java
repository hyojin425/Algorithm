import java.util.*;
class Solution {
    public int solution(int K, int n, int[][] reqs) {
        k = K;
        arr = new int[k];
        for(int i = 1; i <= K; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] r: reqs) {
            map.get(r[2]).add(new int[]{r[0], r[1]});
        }
        for(int i = 1; i <= K; i++) {
            map.get(i).sort((a, b) -> {
                    if(a[0] == b[0]) return a[1] - b[1];
                    else return a[0] - b[0];
                });
        }
        dfs(0, n, 0);
        return answer;
    }
    
    static int answer = Integer.MAX_VALUE;
    static int[] arr;
    static int k;
    static Map<Integer, List<int[]>> map = new HashMap<>();
    public static void dfs(int sum, int n, int l) {
        if(l == k - 1) {
            arr[k - 1] = n - sum;
            if (arr[k - 1] < 1) return;
            
            List<PriorityQueue<Integer>> queues = new ArrayList<>();
            for(int i= 0; i < k; i++) {
                queues.add(new PriorityQueue<>());
            }
            
            int total = 0;
            for(int i = 0; i < k; i++) {
                PriorityQueue<Integer> q = queues.get(i);
                List<int[]> menti = map.get(i + 1);
                
                int limit = Math.min(arr[i], menti.size());
                for(int j = 0; j < limit; j++) {
                    q.add(menti.get(j)[0] + menti.get(j)[1]);
                }
                
                for(int j = limit; j < menti.size(); j++) {
                  
                    int[] cur = menti.get(j);
                    
                    if(q.isEmpty()) {
                        q.add(cur[0] + cur[1]);
                        continue;
                    }
                    int endTime = q.poll();
                    if(endTime > cur[0]) {
                        total += endTime - cur[0];
                        q.add(endTime + cur[1]);
                    } else {
                        q.add(cur[0] + cur[1]);
                    }              
                }
            }
            answer = Math.min(answer, total);
        } else {
            for(int i = 1; i <= n - sum; i++) {
                arr[l] = i;
                dfs(sum + i, n, l + 1);
            }
        }
    }
}