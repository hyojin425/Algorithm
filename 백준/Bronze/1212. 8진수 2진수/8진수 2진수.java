import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        BigInteger n = new BigInteger(str, 8);
        String result = n.toString(2);

        System.out.println(result);
    }
}