import java.util.*;



public class Main {

    static int n;
    static int[] arr;
    static int[] ch;
    static int[] pm;
    static int result;
    public void DFS(int l){
        if(l == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(pm[i] - pm[i + 1]);
            }
            result = Math.max(result, sum);
        } else {
            for(int i = 0; i < n; i++){
                if(ch[i] == 0) {
                    pm[l] = arr[i];
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
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        ch = new int[n];
        pm = new int[n];
        result = Integer.MIN_VALUE;
        t.DFS(0);
        System.out.println(result);
    }

}