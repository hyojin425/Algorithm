import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        if(a.charAt(0) == b.charAt(0)) dp[0][0] = 1;
        for(int i = 1; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(0)) dp[i][0] = 1;
            else dp[i][0] = dp[i - 1][0];
        }

        for(int i = 1; i < b.length(); i++) {
            if(b.charAt(i) == a.charAt(0)) dp[0][i] = 1;
            else dp[0][i] = dp[0][i - 1];
        }

        for(int i = 1; i < a.length(); i++) {
            char aChar = a.charAt(i);
            for(int j = 1; j < b.length(); j++) {
                if(b.charAt(j) == aChar) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                
            }
        }
        return dp[a.length() - 1][b.length() - 1];
    }
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      

        String a = br.readLine();
        String b = br.readLine();
        System.out.println(solution(a, b));


    }
}
    