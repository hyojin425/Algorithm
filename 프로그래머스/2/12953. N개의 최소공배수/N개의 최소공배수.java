import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        answer = max;
        while(true){
            boolean flag = true;
            for(int c : arr){
                if(answer % c != 0) flag = false;
            }
            if(flag) break;
            else answer += max;
        }
        return answer;
    }
}