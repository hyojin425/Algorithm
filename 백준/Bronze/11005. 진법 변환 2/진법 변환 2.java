import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static ArrayList<Integer> arr;
    public static void DFS(int n, int b){
        if(n<b) {
            arr.add(n);
        }
        else {
            DFS(n/b,b);
            arr.add(n % b);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int b = Integer.parseInt(str.split(" ")[1]);

        arr = new ArrayList<>();
        DFS(n, b);
        String answer = "";
        for(int x:arr) {
            if(x>=10) answer += Character.toString(x + 55);
            else answer+=x;
        }

        System.out.print(answer);
    }
}