import java.util.*;



public class Main {

    static int n;
    static int[] ch;
    static int[] pm;
    public void DFS(int l){
        if(l == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(pm[i] + " ");
            }
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++){
                if(ch[i] == 0) {
                    pm[l] = i;
                    ch[i] = 1;
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
        ch = new int[n + 1];
        pm = new int[n];
        t.DFS(0);
    }

}