import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void solution(int n, char[][] arr) {
        int heartx = 0;
        int hearty = 0;
        boolean findHeart = false;

        // 머리
        for(int i = 0; i< n; i++) {
            if(findHeart) break;
            for(int j = 0; j< n; j++) {
                if(arr[i][j] == '*' && !findHeart) {
                    heartx = i + 1;
                    hearty = j;
                    findHeart = true;
                }
            }
        }

        System.out.println((heartx + 1) + " " + (hearty + 1));

        // 팔 길이
        int start = -1;
        int end = -1;
        boolean findStart = false;
        boolean findEnd = false;
        for(int i = 0; i< n; i++) {
            if(arr[heartx][i] == '*' && !findStart) {
                start = i;
                findStart = true;
            }
            if((!findEnd && i == n - 1) || (arr[heartx][i] == '*' && arr[heartx][i + 1] == '_')) {
                end = i;
                findEnd = true;
            }
        }

        System.out.print((hearty - start) + " " + (end - hearty) + " ");

        // 다리
        int leftLen = 0;
        int rightLen = 0;
        int waistEnd = -1;
        for(int i = heartx + 1; i < n; i++) {
            if(arr[i][hearty -1] == '*') {
                if(waistEnd == -1) {
                    waistEnd = i;
                }
                leftLen++;
            }
            if(arr[i][hearty +1] == '*') rightLen++;
        }
        System.out.println((waistEnd - 1 - heartx) + " " + leftLen  + " " + rightLen);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        solution(n, arr);

    }
}
