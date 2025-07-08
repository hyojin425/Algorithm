import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        BigInteger n = new BigInteger(arr[0]);

        String result = n.toString(Integer.parseInt(arr[1]));

        System.out.println(result.toUpperCase());
    }
}