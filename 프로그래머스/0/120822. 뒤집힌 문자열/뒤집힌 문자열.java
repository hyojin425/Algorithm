class Solution {
    public String solution(String my_string) {
        String answer = "";
        answer = new StringBuilder(my_string).reverse().toString();
        return answer;
    }
}