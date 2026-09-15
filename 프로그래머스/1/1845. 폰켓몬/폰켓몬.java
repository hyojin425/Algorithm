import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        if(nums.length/2 > map.size()) {
            return map.size();
        } else return nums.length/2;
    }
}