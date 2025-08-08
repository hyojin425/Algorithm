import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static int solution(int n, char[][] arr) {
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] != arr[i][j]) {
                        char tmp = arr[nx][ny];
                        arr[nx][ny] = arr[i][j];
                        arr[i][j] = tmp;
                        result = Math.max(result, check(n, arr));
                        tmp = arr[nx][ny];
                        arr[nx][ny] = arr[i][j];
                        arr[i][j] = tmp;
                    }
                }
            }
        }
        return  result;
    }

    public static int check(int n, char[][] arr) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int sum = 1;
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && arr[i][j] == arr[i][j + 1]) {
                    sum += 1;
                } else {
                    result = Math.max(sum, result);
                    sum = 1;
                }
            }
            result = Math.max(sum, result);
        }

        for (int i = 0; i < n; i++) {
            int sum = 1;
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && arr[j][i] == arr[j+ 1][i]) {
                    sum += 1;
                } else {
                    result = Math.max(sum, result);
                    sum = 1;
                }
            }
            result = Math.max(sum, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        char[][] array = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] arr = scanner.next().toCharArray();
            for (int j = 0; j< n; j++) {
                array[i][j] = arr[j];
            }
        }
        System.out.println(solution(n, array));

    }

}