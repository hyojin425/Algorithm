import java.util.*;



public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] pm;
    static int[] ch;
    static StringBuilder sb = new StringBuilder();
    public  void DFS(int l){
        if(l == m) {
            for(int i = 0; i< m; i++){
                sb.append(pm[i]).append(" ");
            }
            sb.append("\n");
        } else {
            int lastN = 10001;
            for(int i = 0; i< n; i++){
                if(arr[i] != lastN && ch[i] == 0) {
                    pm[l] = arr[i];
                    ch[i] = 1;
                    lastN = arr[i];
                    DFS(l + 1);
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
        pm = new int[n];
        ch = new int[n];
        t.DFS(0);
        System.out.print(sb.toString());
    }

}