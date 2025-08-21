import java.util.*;



public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] ch;
    public  void DFS(int l){
        if(l == m) {
            for(int i = 0; i< m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for( int i = 1; i<= n; i++){
                if(ch[i] == 0) {
                    ch[i] = 1;
                    arr[l] = i;
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
        arr = new int[m];
        ch = new int[n + 1];
        t.DFS(0);
    }

}