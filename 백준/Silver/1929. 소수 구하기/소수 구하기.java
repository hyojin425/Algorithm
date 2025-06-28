import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Boolean> arr = new ArrayList<>();

        for (int i = 0; i <= nums[1]; i++) {
            arr.add(true);
        }

        for (int i = 2; i <= Math.sqrt(nums[1]); i++) {
            if(arr.get(i) == true) {
                int j = 2;
                while((i * j) <= nums[1]){
                    arr.set(i * j, false);
                    j++;
                }
            }
        }

        for(int i = nums[0] ; i <= nums[1]; i++){
            if(i > 1 && arr.get(i)) {
                System.out.println(i);
            }
        }
    }
}