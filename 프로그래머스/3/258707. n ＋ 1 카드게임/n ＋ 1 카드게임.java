import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;
        
        // 처음 가지고 있는 카드
        Set<Integer> myCards = new HashSet<>();
        for(int i = 0; i < n/3; i++) {
            myCards.add(cards[i]);
        }
        
        // 뽑은 카드
        Set<Integer> additional = new HashSet<>();
        
        // 뽑을 카드의 인덱스
        int idx = n/3;
        
        // 라운드
        int round = 0;
        
        while(true) {
            round++;
            // 카드 뽑기
            if(idx + 1 < n) {
                additional.add(cards[idx]);
                additional.add(cards[idx + 1]);
                idx += 2;
            } else break;
            
            boolean success = false;
            
            // 가지고 있는 카드 중 n + 1이 되는지
            for(int x: myCards) {
                int y = target - x;
                if(myCards.contains(y)) {
                    myCards.remove(x);
                    myCards.remove(y);
                    success = true;
                    break;
                }
            }
            if(success) continue;
            
            // 뽑은 카드 하나와 가지고 있는 카드 조합해서 n + 1이 되는 경우
            if(coin >= 1){
                for(int x : myCards) {
                    int y = target - x;
                    if(additional.contains(y)) {
                        coin -= 1;
                        additional.remove(y);
                        myCards.remove(x);
                        success = true;
                        break;
                    }
                }
            }
            if(success) continue;
            
            // 뽑은 카드 2개를 조합해서 n + 1이 되는 경우
            if(coin >= 2){
                for(int x : additional) {
                    int y = target - x;
                    if(additional.contains(y)) {
                        coin -= 2;
                        additional.remove(y);
                        additional.remove(x);
                        success = true;
                        break;
                    }
                }
            }            
            if(!success) break;
        }
        
        return round;
        
    }
    
}