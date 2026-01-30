import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int solution(int n, int[][] arr) {
        Arrays.sort(arr, (a ,b) -> a[0] - b[0]);
        List<List<Integer>> totalbuildings = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for(int i = 0; i< n; i++) {
            if(arr[i][1] != 0) {
                cur.add(arr[i][1]);
            } else {
                if(!cur.isEmpty()) {
                    totalbuildings.add(new ArrayList<>(cur));
                    cur.clear();
                }
            }
        }
        if(!cur.isEmpty()) {
            totalbuildings.add(cur);
        }

        int answer = 0;
        for(int i = 0 ; i< totalbuildings.size(); i++) {
            answer += countBuilding(totalbuildings.get(i));
        }

        return answer;
        
    }

    public static int countBuilding(List<Integer> arr) {
        int answer = 0;
        Stack<Integer>stack = new Stack<>();
        stack.add(0);
        for(int i = 0; i<arr.size(); i++) {
            int tmp = arr.get(i);
            while(stack.peek() > tmp){
                stack.pop();
                answer++;
            }
            if(stack.peek() != tmp) {
                stack.add(tmp);
            }
        }
        answer += stack.size() -1;
        return answer;
    }
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0 ; i< n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray(); 
        }


        System.out.println(solution(n, arr));
    }
}