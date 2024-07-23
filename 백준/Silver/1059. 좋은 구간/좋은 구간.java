
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] arr = new int[l + 1];
        for (int i = 0; i < l; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        sc.close();

        arr[l] = n;
        Arrays.sort(arr);
        int idx = Arrays.binarySearch(arr, n);
        int start = (idx > 0) ? arr[idx - 1] : 0;
        int end = (idx < l) ? arr[idx + 1] : n;


        int answer = 0;
        for (int i = start+1; i <= n; i++) {
            for (int j = n; j < end; j++) {
                if(i < j){
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }


}
