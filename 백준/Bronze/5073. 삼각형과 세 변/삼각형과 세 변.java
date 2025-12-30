import java.util.*;

public class Main {

    public static String solution(int[] arr) {
        Arrays.sort(arr);
        if (arr[2] >= arr[1] + arr[0]) {
            return "Invalid";
        } else if(arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[0]) {
            return "Equilateral";
        } else if(arr[0] != arr[1] && arr[1] != arr[2] && arr[2] != arr[0]) {
            return "Scalene";
        } else {
            return "Isosceles";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[3];
        while(true) {
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
            }
            if (arr[1] == 0 && arr[2] == 0 && arr[0] == 0) {
                break;
            }
            System.out.println(solution(arr));
        }
    }
}