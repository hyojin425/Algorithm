import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static long pow(long a, long b, long c) {
        if(b == 0) return 1;

        long half = pow(a, b / 2, c);
        long answer = half * half % c;
        if(b% 2 == 1) answer = answer* a % c;
        return answer;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

        System.out.println(pow(arr[0], arr[1], arr[2]));
  
    }
}