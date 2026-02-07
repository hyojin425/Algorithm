import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] unf;
    public static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static int solution(int n, int m, int[] truth, List<List<Integer>> party) {
        unf = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        // 묶기
        for(int i = 0; i< m; i++) {
            List<Integer> list = party.get(i);
            for(int j = 0; j < list.size() - 1; j++) {
                union(list.get(j), list.get(j + 1));
            }
        }

        int answer = 0;
        for(int i = 0; i < m; i++) {
            List<Integer> list = party.get(i);
            boolean flag = true;
            for(int j = 0; j < list.size(); j++) {
                for(int k = 0; k < truth.length; k++) {
                    if(find(truth[k]) == find(list.get(j))) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
            if(flag) answer++;
        }

        return answer;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());

        int[] truthPeople = new int[truthCount];
        for (int i = 0; i < truthCount; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        System.out.println(solution(n, m, truthPeople, parties));

    }
}