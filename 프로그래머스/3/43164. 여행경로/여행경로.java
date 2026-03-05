import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        ch = new int[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        answer[0] = "ICN";
        dfs("ICN", 0, tickets);
        return answer;
    }
    
    static int[] ch;
    static String[] answer;
    static boolean flag = false;
    public static void dfs(String start, int sum, String[][] tickets) {
        if(flag) return;
        if(sum == ch.length) {

            flag = true;
            return;
        } else {
            for(int i = 0; i < tickets.length; i++) {
                if(tickets[i][0].equals(start) && ch[i] == 0) {
                    ch[i] = 1;
                    answer[sum + 1] = tickets[i][1]; 
                    dfs(tickets[i][1], sum + 1, tickets);
                    
                    if(flag) return;
                    ch[i] = 0;
                }
            }
        }
    }
}