import java.util.*;

class Solution {
    static int[][] dices;
    static int len;
    static int[] diceA;
    static int[] diceB;
    static ArrayList<Integer> arrA;
    static ArrayList<Integer> arrB;
    static int winMax;
    static int[] answer;


    static int[] solution(int[][] dice) {
        dices = dice;
        len = dice.length;
        diceA = new int[len / 2];
        diceB = new int[len / 2];
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();
        winMax = 0;
        answer = new int[len / 2];

        dfs(0, 0);
        return answer;
    }

    static void dfs(int l, int n) {
        if (l == len / 2) {
            // B가 가지는 주사위 선택
            int idx = 0;
            for (int i = 0; i < len; i++) {
                if(idx == len/2) break;
                boolean contain = false;
                for (int a : diceA) {
                    if (a == i) contain = true;
                }
                if (!contain) {
                    diceB[idx] = i;
                    idx++;
                }
            }

            arrA.clear();
            arrB.clear();
            // 각 주사위로 얻을 수 있는 모든 합 구하기
            calculateSum(0, 0, 0);
            Collections.sort(arrA);
            Collections.sort(arrB);

            int sum = 0;
            for (int a : arrA) {
                sum += binarySearch(a);
            }
            if (winMax < sum) {
                for(int i = 0; i < answer.length; i++){
                    answer[i] = diceA[i] + 1;
                }
                winMax = sum;
            }
        } else {
            for (int i = n; i < len; i++) {
                diceA[l] = i;
                dfs(l + 1, i + 1);
            }
        }
    }

    static void calculateSum(int l, int sumA, int sumB) {
        if (l == len / 2) {
            arrA.add(sumA);
            arrB.add(sumB);
        } else {
            for (int i = 0; i < 6; i++) {
                calculateSum(l + 1, sumA + dices[diceA[l]][i], sumB + dices[diceB[l]][i]);
            }
        }
    }
    
    static int binarySearch(int a) {
        int left = 0, right = arrB.size() - 1;
        int idx = -1;
        while(left <= right) {
            int middle = (left + right)/2;
            if(arrB.get(middle) < a) {
                left = middle + 1;
                idx = Math.max(idx, middle);
            } else {
                right = middle - 1;
            }
        }
        
        return idx + 1;
    }
}