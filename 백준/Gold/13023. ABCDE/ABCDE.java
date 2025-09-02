import java.util.*;



public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int n, m;
    static boolean found = false;
    public void DFS(int l, int s) {
        if(found) return;
        if(l == 5) {
            found = true;
        } else {
            for(int i = 0; i < graph.get(s).size(); i++) {
                if(ch[graph.get(s).get(i)] == 0) {
                    ch[graph.get(s).get(i)] = 1;
                    DFS(l + 1, graph.get(s).get(i));
                    ch[graph.get(s).get(i)] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);

        n  = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> newGraph = new ArrayList<>();
            graph.add(newGraph);
        }
        for(int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i < n; i++ ) {
            ch = new int[n];
            ch[i] = 1;
            t.DFS(1, i);
            if(found) break;
        }
        System.out.println(found? 1 : 0);
    }

}