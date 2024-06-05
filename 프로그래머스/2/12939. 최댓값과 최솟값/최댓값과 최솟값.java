class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            int a = Integer.parseInt(arr[i]);
            if(a > max) max = a;
            if(a < min) min = a;
        }
        answer = min + " " + max;
        return answer;
    }
}