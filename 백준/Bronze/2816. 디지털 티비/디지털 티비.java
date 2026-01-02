import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static String solution(List<String> list) {
        String answer = "";
        int KBS1Idx = list.indexOf("KBS1");
        answer += "1".repeat(KBS1Idx);
        answer += "4".repeat(KBS1Idx);
        for (int i = KBS1Idx; i > 0; i--) {
            swap(list, i, i - 1);
        }

        int KBS2Idx = list.indexOf("KBS2");
        answer += "1".repeat(KBS2Idx);
        answer += "4".repeat(KBS2Idx - 1);

        return answer;
    }

    public static void swap(List<String> list, int curIdx, int idx) {
        list.set(curIdx, list.get(idx));
        String tmp = list.get(curIdx);
        list.set(idx, tmp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        List<String> list = new ArrayList<>();
        for(int i = 0; i< cnt; i++) {
            list.add(sc.next());
        }
        System.out.println(solution(list));
    }
}