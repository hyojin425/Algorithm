import java.util.*;

public class Main {
    public void solution(int[] arr, int n){
        int i = n - 1;
        // 1. 뒤에서부터 arr[i-1] < arr[i] 찾기
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i <= 0) { // 마지막 순열인 경우
            System.out.println(-1);
            return;
        }

        // 2. arr[i-1]보다 큰 원소 중 가장 오른쪽 원소 찾기
        int j = n - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }

        // 교환
        int tmp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = tmp;

        // 3. arr[i..n-1] 구간 뒤집기
        int left = i, right = n - 1;
        while (left < right) {
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }

        // 결과 출력
        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        t.solution(arr, n);
    }
}
