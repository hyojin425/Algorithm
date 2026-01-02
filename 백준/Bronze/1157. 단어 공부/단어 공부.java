import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static char solution(String str) {
        String upStr = str.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: upStr.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = map.values().stream()
                .max(Integer::compare)
                .orElseThrow();

        List<Character> list = map.entrySet().stream()
                .filter(v -> v.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if(list.size() > 1) {
            return '?';
        } else {
            return list.get(0);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}