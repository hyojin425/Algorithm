import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int cnt = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< cnt; i++) {
            String[] commands = sc.nextLine().split(" ");
            String command = commands[0];
            int value;
            if (command.equals("add")) {
                value = Integer.parseInt(commands[1]);
                set.add(value);
            } else if (command.equals("remove")) {
                value = Integer.parseInt(commands[1]);
                set.remove(value);
            } else if (command.equals("check")) {
                value = Integer.parseInt(commands[1]);
                sb.append(set.contains(value) ? "1\n" : "0\n");
            } else if (command.equals("toggle")) {
                value = Integer.parseInt(commands[1]);
                if (set.contains(value)) {
                    set.remove(value);
                } else {
                    set.add(value);
                }
            } else if (command.equals("all")) {
                for (int j = 1; j < 21; j++) {
                    set.add(j);
                }
            } else if (command.equals("empty")) {
                set.clear();
            }
        }
        System.out.print(sb);
    }
}