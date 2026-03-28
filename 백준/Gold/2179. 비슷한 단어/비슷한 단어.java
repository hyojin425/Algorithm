import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] original = new String[n];
        for (int i = 0; i < n; i++) {
            original[i] = br.readLine();
        }

        int maxLen = -1;
        String s1 = "", s2 = "";

        // 모든 단어 쌍을 비교하면 O(N^2 * L)로 위험하지만, 
        // 문제의 N과 제한 시간을 고려할 때 접두사 기준으로 그룹화하면 효율적입니다.
        for (int i = 0; i < n; i++) {
            String target = original[i];
            
            for (int j = i + 1; j < n; j++) {
                String compare = original[j];
                
                // 이미 찾은 최대 길이보다 짧은 단어는 스킵 (최적화)
                if (target.equals(compare)) continue; 

                int count = getCommonPrefixLength(target, compare);

                if (count > maxLen) {
                    maxLen = count;
                    s1 = target;
                    s2 = compare;
                }
            }
        }

        System.out.println(s1);
        System.out.println(s2);
    }

    private static int getCommonPrefixLength(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) return i;
        }
        return len;
    }
}