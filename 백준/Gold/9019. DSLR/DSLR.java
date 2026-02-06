import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void solution(int n, int target) {
        Queue<Num> q = new LinkedList<>();
        int[] visited = new int[10000];
        visited[n] = 1;
        q.add(new Num(n, ""));

        while(!q.isEmpty()) {
            Num tmp = q.poll();
                int num = tmp.num;
                String op = tmp.op;
                if(num == target) {
                    System.out.println(op);
                    return;
                }
                
                int d = num * 2 % 10000;
                    if(visited[d] == 0) {
                         q.add(new Num(d, op + "D"));
                         visited[d] = 1;
                    }
                
                int s = num == 0 ? 9999 : num - 1;
                if(visited[s] == 0) {
                    q.add(new Num(s, op + "S"));
                    visited[s] = 1;
                }

                int L = (num % 1000) * 10 + (num / 1000);
                if(visited[L] == 0) {
                    q.add(new Num( L, op + "L"));
                    visited[L] = 1;
                }
                int R = (num  % 10) * 1000 + (num / 10);
                if(visited[R] == 0) {
                    q.add(new Num(R, op + "R"));
                    visited[R] = 1;
                }
        }
        return;
    }

    public static class Num {
        int num;
        String op;

        public Num(int num, String op){
            this.num = num;
            this.op = op;
        }
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i< t; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            solution(nums[0], nums[1]);
        }
    }
}