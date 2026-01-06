import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static long solution(int k, int[][] arr) {

        List<Nation> nations = new ArrayList<>();
        Nation target = null;
        for(int[] a: arr) {
            Nation newNation = new Nation(a[0], a[1], a[2], a[3]);
            nations.add(newNation);
            if(a[0] == k) target = newNation;
        }

        int rank = 1;
        for(Nation nation: nations) {
            if(target.compareTo(nation) < 0) {
                rank++;
            }
        }


        return rank;
    }

    public static class Nation implements Comparable<Nation> {
        int idx;
        int gold;
        int silver;
        int bronze;

        public Nation(int idx, int gold, int silver, int bronze) {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int compareTo(Nation o) {
            if(this.gold > o.gold) {
                return 1;
            } else if(this.gold == o.gold && this.silver > o.silver) {
                return 1;
            } else if(this.gold == o.gold && this.silver == o.silver
                    && this.bronze > o.bronze){
                return 1;
            } else if(this.gold == o.gold && this.silver == o.silver
                    && this.bronze == o.bronze){
                return 0;
            } else {
                return -1;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = intArr[0];
        int k = intArr[1];
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            int[] a = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            arr[i] = a;
        }
        System.out.println(solution(k, arr));

//        String s = br.readLine();
//        String n = br.readLine();
    }
}
