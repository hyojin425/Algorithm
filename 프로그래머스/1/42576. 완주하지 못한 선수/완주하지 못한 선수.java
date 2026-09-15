import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new  HashMap<>();
        for(String p: participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for(String c: completion) {
            if(map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            String s = e.getKey();
            Integer i = e.getValue();
            return s;
        }
        String answer = "";
        return answer;
    }
}