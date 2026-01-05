import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    public static int[] solution(int n, int[][] arr) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Person(arr[i][0], arr[i][1]));
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for(int j = 0; j < n; j++) {
                if(list.get(i).compareTo(list.get(j)) < 0) {
                    rank++;
                }
            }
            answer[i] = rank;
        }
        return answer;
    }

    public static class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int compareTo(Person o) {
            if(this.height > o.height && this.weight > o.weight) {
                return 1;
            } else if(this.height < o.height && this.weight < o.weight){
                return -1;
            } else {
                return 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            arr[i][0] = a[0];
            arr[i][1] = a[1];
        }
//        String s = br.readLine();
//        String n = br.readLine();
        int[] answer = solution(n, arr);
        for(int a: answer) {
            System.out.print(a + " ");
        }
    }
}
