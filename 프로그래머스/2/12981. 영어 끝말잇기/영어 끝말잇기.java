import java.util.*;

class Solution {
    public int[] solution(int n, String[] arr) {
        int[] answer = new int[2];
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i>0 && (list.contains(arr[i]) ||
                    arr[i - 1].charAt(arr[i - 1].length() - 1) != arr[i].charAt(0))) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            list.add(arr[i]);
        }
        return answer;
    }
}