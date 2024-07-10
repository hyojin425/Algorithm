import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            tmp[i] = arr[i];
        }

        Arrays.sort(arr);

        int[] index = new int[n];
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i] == tmp[j] && ch[j] != 1) {
                    index[i] = j;
                    ch[j] = 1;
                    break;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            arr[index[i]] = i;
        }

        for (int x : arr) {
            System.out.print(x +" ");
        }
    }
}
