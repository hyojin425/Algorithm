import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int rt = people.length - 1;
        int lt = 0;
        
        while(lt <= rt) {
            if(people[lt] + people[rt] <= limit) {
                lt++;
                rt--;
            } else if(limit - people[lt] < people[rt]) {
                rt--;
            }
            answer++;
        }
        
        return answer;
    }
}