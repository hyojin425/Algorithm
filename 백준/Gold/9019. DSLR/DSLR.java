import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static String solution(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int[] ch = new int[10000];
        ch[start] =1;

        int[] prev = new int[10000];
        char[] how = new char[10000];
        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == target) break;

            // d
            int d = cur * 2 % 10000;
            if(ch[d] == 0) {
                ch[d] = 1;
                q.add(d);
                prev[d] = cur;
                how[d] = 'D';
            }

            // s
            int s = (cur == 0)? 9999 : cur - 1;
            if(ch[s] == 0) {
                ch[s] = 1;
                q.add(s);
                prev[s] = cur;
                how[s] = 'S';
            }

            // l
            int l = (cur % 1000) * 10 + cur / 1000;
            if(ch[l] == 0) {
                ch[l] = 1;
                q.add(l);
                prev[l] = cur;
                how[l] = 'L';
            }

            // r
            int r = (cur % 10) * 1000 + cur / 10;
            if(ch[r] == 0) {
                ch[r] = 1;
                q.add(r);
                prev[r] = cur;
                how[r] = 'R';
            }
        }


        StringBuilder sb = new StringBuilder();
        while(target != start) {
             sb.append(how[target]);
            target = prev[target];
        }

        return sb.reverse().toString();

    }
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i< t; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            System.out.println(solution(nums[0], nums[1]));
        }
    }
}