import java.util.Arrays;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int[] give = new int[friends.length];
        int[] receive = new int[friends.length];
        int[][] m = new int[friends.length][friends.length];
        
        for(int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            int idx1 = Arrays.asList(friends).indexOf(gift[0]);
            int idx2 = Arrays.asList(friends).indexOf(gift[1]);
            give[idx1]++;
            receive[idx2]++;
            m[idx1][idx2]++;
        }
        
        int[] answers = new int[friends.length];
        for(int i = 0; i < friends.length; i++) {
            for(int j = i + 1; j < friends.length; j++) {
                if((m[i][j] == 0 && m[j][i] == 0) ||
                   m[j][i] == m[i][j]) {
                    int a = give[i] - receive[i];
                    int b = give[j] - receive[j];
                    if(a < b) answers[j]++; 
                    else if (a > b) answers[i]++;
                } else if(m[i][j] > m[j][i]) {
                    answers[i]++;
                } else if(m[i][j] < m[j][i]) {
                    answers[j]++;
                }
            }
        }
            
        int answer = answers[0];
        for(int a: answers) {
            answer = Math.max(a, answer);
        }
        return answer;
    }
}