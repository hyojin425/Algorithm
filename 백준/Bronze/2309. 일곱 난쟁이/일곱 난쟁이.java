import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void solution(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        Arrays.sort(arr);

        outerLoop:
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int tmp = sum - (arr[i] + arr[j]);
                if (tmp == 100) {
                    for(int k = 0; k < 9; k++){
                        if (k != i && k != j) {
                            System.out.println(arr[k]);
                        }
                    }
                    break outerLoop;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            array[i] = scanner.nextInt();
        }
        solution(array);

    }

}