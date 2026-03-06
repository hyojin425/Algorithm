class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        input = q;
        answer = ans;
        dfs(n, 0, 1);
        return result;
    }
    
    static int[][] input;
    static int[] answer;
    static int result = 0;
    static int[] arr = new int[5];
    
    public static void dfs(int n, int l, int v) {
        if(l == 5) {
            for(int j = 0; j < input.length; j++) {
                int[] tmp = input[j];
                int cnt = 0;
                int idx = 0;
                for(int i = 0; i < 5; i++) {
                    while(idx < 5 && tmp[idx] < arr[i]) {
                        idx++;
                    }
                    if(idx >= 5) break;
                    if(tmp[idx] == arr[i]) cnt++;
                }
                if(cnt != answer[j]) return;
            }
            result++;
        } else {
            for(int i = v; i <= n; i++) {
                arr[l] = i;
                dfs(n, l + 1, i + 1);
            } 
        }
    }
}