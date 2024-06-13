import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int len = people.length;
        int[] ch = new int[len];
        int lt = 0, rt = len - 1;
        
        while(lt <= rt){
            if(limit >= people[rt] + people[lt]){
                answer++;
                lt++;
                rt--;
            }else {
                answer++;
                rt--;
            }
        }
        
        return answer;
    }
}