import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;
        while(n != 1){
            if(n % 2 == 0){
                n = n/2;
            }
            else {
                n = n - 1;
                ans ++;
            }
        }

        return ans;
    }
}