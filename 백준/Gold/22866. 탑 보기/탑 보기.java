import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void solution(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] leftCnt = new int[n];
        int[] leftNear = new int[n];
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            
            leftCnt[i] = stack.size();
            if(stack.isEmpty()) leftNear[i] = Integer.MAX_VALUE;
            else leftNear[i] = stack.peek();

            stack.push(i);
            
        }

        stack.clear();
        int[] rightCnt = new int[n];
        int[] rightNear = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            
            rightCnt[i] = stack.size();
            if(stack.isEmpty()) rightNear[i] = Integer.MAX_VALUE;
            else rightNear[i] = stack.peek();

            stack.push(i);
        }

        for(int i = 0; i < n; i++) {
            if(leftCnt[i] + rightCnt[i] == 0) System.out.println(0);
            else if(Math.abs(i - leftNear[i]) <= Math.abs(i - rightNear[i])) 
                System.out.println((leftCnt[i] + rightCnt[i]) + " " + (leftNear[i] + 1));
            else System.out.println((leftCnt[i] + rightCnt[i]) + " " + (rightNear[i] + 1));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        solution(n, arr);
    }
}