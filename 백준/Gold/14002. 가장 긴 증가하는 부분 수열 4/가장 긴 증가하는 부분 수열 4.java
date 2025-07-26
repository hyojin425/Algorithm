import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            ArrayList<Integer> inner = new ArrayList<>();
            inner.add(arr[i]);
            dp.add(inner);
        }

        for(int i = 1; i < n; i++) {
              for(int j = 0; j < i; j++) {
                  if (arr[i] > arr[j]) {
                      if(dp.get(i).size() < dp.get(j).size() + 1) {
                          ArrayList<Integer> inner = new ArrayList<>(dp.get(j));
                          inner.add(arr[i]);
                          dp.set(i, inner);
                      }
                  }
              }
        }

        int answer = 0;
        int idx = 0;
        for (int i = 0; i < n; i++){
            if(dp.get(i).size() > answer) {
                answer = dp.get(i).size();
                idx = i;
            }
        }

        System.out.println(answer);
        for (int num : dp.get(idx)) {
            System.out.print(num + " ");
        }
    }
}