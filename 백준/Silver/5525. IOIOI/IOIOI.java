import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static int solution(int n, int m, String str) {
        int answer = 0;

        List<Integer>  idx = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            if(str.charAt(i) == 'I') idx.add(i);
        }


        int j = n;
        int i = 0;
        while(j < idx.size()) {
            boolean flag = true;
            while(i < j) {
                if(idx.get(j) - idx.get(j - 1) != 2) {
                    flag = false;
                      break;  
                }
                j--;
            }
            if(flag) {
                answer++;
                i++;
            } else {
                i = j;
            }
            j = i + n;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(solution(n, m, str));

    }
}