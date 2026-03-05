import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long min = 1;
        long max = (long)Arrays.stream(times).max().getAsInt() * n;
        while(min <= max) {
            long mid = (min + max) / 2;
            if(check(mid, times, n)) {
                max = mid - 1;
                answer = mid;
            } else min = mid + 1;
        }
        
        return answer;
    }
    
    public static boolean check(long mid, int[] times, int n) {
        long cnt = 0;
        for(int t: times) {
            cnt += mid / (long)t;
        }
        
        return cnt >= n;
    }
}