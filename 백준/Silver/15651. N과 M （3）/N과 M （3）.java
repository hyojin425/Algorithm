import java.util.*;



public class Main {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public  void DFS(int l){
        if(l == m) {
            for(int i = 0; i< m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for( int i = 1; i<= n; i++){
                arr[l] = i;
                DFS(l + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);

        n  = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[m];
        t.DFS(0);
        System.out.print(sb.toString());
    }

}