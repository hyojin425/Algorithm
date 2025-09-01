import java.util.*;



public class Main {

    static int n, m;
    static char[] arr;
    static char[] pm;
    public void DFS(int l, int s){
        if(l == n) {
            if(check(pm)) {
                for (int i = 0; i < n; i++) {
                    System.out.print(pm[i]);
                }
                System.out.println();
            }
        } else {
            for(int i = s; i < m; i++){
                pm[l] = arr[i];
                DFS(l + 1, i + 1);
            }
        }
    }

    public static boolean check(char[] pm) {
        int vowel = 0;
        int consonant = 0;
        for(char a: pm) {
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }
        return vowel >= 1 && consonant >= 2;
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);

        n  = scanner.nextInt();
        m = scanner.nextInt();
        arr = new char[m];
        pm = new char[n];

        for(int i = 0; i < m; i++) {
            arr[i] = scanner.next().charAt(0);

        }

        Arrays.sort(arr);
        t.DFS(0, 0);
    }

}