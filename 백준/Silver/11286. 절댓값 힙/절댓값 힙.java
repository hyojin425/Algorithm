import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void solution(int[] arr) {
        PriorityQueue<Integer> q= new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b)) return Integer.compare(a, b);
            else return Integer.compare(Math.abs(a), Math.abs(b));
        });

        for(int i : arr) {
            if(i == 0) {
                if(q.isEmpty()) System.out.println(0);
                else System.out.println(q.poll());
            } else {
                q.add(i);
            }
        }
        
    }
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i< n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        solution(arr);

    }
}