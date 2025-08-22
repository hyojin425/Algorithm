import java.util.*;



public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] ch;
    static int[] pm;
    static StringBuilder sb = new StringBuilder();
    public  void DFS(int l, int s){
        if(l == m) {
            for(int i = 0; i< m; i++){
                sb.append(pm[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for( int i = 0; i< n; i++){
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[l] = arr[i];
                    DFS(l + 1, i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);

        n  = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        ch = new int[n];
        pm = new int[n];
        t.DFS(0, 0);
        System.out.print(sb.toString());
    }

}