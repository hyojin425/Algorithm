import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void solution(int n, int[] arr) {
        int lt = 0;
        int rt = n - 1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while(lt < rt) {
            if(min > Math.abs(arr[lt] + arr[rt])){
                min = Math.abs(arr[lt] + arr[rt]);
                answer[0] = arr[lt];
                answer[1] = arr[rt];
            }
            
            if(Math.abs(arr[lt]) > Math.abs(arr[rt])) {
                lt++;
            } else if(Math.abs(arr[lt]) < Math.abs(arr[rt])) {
                rt--;
            } else {
                break;
            }
        }

        System.out.print(answer[0] + " " + answer[1]);
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        solution(n, intArr);
    }
}