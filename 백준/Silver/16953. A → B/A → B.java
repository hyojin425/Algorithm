import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int solution(int a, int b) {
        int answer = 1;
        while(b > a) {
            if(b % 2 == 0) b /= 2;
            else if (b % 10 == 1) b = (b - 1)/ 10;
            else return -1;
            answer++;
        }

        if(a == b) return answer;
        return -1;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        System.out.println(solution(arr[0], arr[1]));

    }
}