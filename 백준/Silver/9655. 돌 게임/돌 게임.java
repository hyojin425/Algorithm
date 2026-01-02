import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        if (cnt % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}