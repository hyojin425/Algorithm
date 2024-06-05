class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        int m = n;
        while(m>1){
            if(m%2 == 1)  cnt++;
            m = m/2;
        }
        n = n+1;
        while(true){
            int tmp = n;
            int sum =0;
            while(tmp>1){
                if(tmp%2 == 1) sum++;
                tmp = tmp/2;
            
            }
            if(sum==cnt) {
                answer = n;
                break;
            }
            n++;
        }
        return answer;
    }
}