import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void solution(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int[] dis = new int[100001];
        Arrays.fill(dis, -1);
        dis[start] = 0;
        int[] cnt =new int[100001];
 cnt[start] = 1;

        while(!q.isEmpty()) {
            int tmp = q.poll();

            for(int next: new int[]{ tmp + 1, tmp - 1, tmp * 2}) {
                if(next >= 0 &&  next <= 100000) {
                    if(dis[next] == -1) {
                        dis[next] = dis[tmp] + 1;
                        q.add(next);
                        cnt[next] = cnt[tmp];
                    } else if(dis[next] == dis[tmp] + 1) {
                        cnt[next]+= cnt[tmp];
                    }
                }
            }
        }

        System.out.println(dis[end]);
        System.out.println(cnt[end]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        solution(arr[0], arr[1]);
    }
}