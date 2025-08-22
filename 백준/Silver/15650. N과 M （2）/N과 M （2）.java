import java.util.*;



public class Main {
    static int n;
    static int m;
    static int[] arr;
    public  void DFS(int l, int s){
        if(l == m) {
            for(int i = 0; i< m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for( int i = s; i<= n; i++){
                arr[l] = i;
                DFS(l + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);

        n  = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[m];
        t.DFS(0, 1);
    }

}