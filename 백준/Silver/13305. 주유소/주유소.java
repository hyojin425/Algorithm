import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        List<Integer> distance = new ArrayList<>();
        List<Integer> cost = new ArrayList<>();
        for (int i = 0; i < cnt - 1; i++) {
            distance.add(sc.nextInt());
        }
        for (int i = 0; i < cnt; i++) {
            cost.add(sc.nextInt());
        }

        int answer = 0;
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < distance.size(); i++) {
            if (minCost > cost.get(i)) {
                minCost = cost.get(i);
            }
            answer += distance.get(i) * minCost;
        }
        System.out.println(answer);
    }
}