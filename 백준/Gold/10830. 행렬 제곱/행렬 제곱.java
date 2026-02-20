import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int n;

    public static long[][] multiply(long[][] a, long[][] b) {
    	long[][] result = new long[n][n];
	
    	for(int i = 0;  i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			for(int k = 0; k < n; k++) {
    				result[i][j] += a[i][k] * b[k][j];
    				result[i][j] %= 1000;
    			}
    		}
    	}

        return result;
    }
	
	
	public static long[][] pow(long[][] a, long b) {
		if(b == 1) return a;
		
		long[][] half = pow(a, b / 2);
		long[][] result = multiply(half, half);
		
		if(b % 2 == 1) {
			result = multiply(result, a);
		}
		
		return result;
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        n = (int) intArr[0];
        long b = intArr[1];
        long[][] a = new long[n][n];
        for(int i = 0; i < n; i++) {
            a[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToLong(Long::parseLong)
                        .map(x -> x % 1000)
                        .toArray();
        }

        long[][] result = pow(a, b);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}