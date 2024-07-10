import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int cnt = 0;
        for (int x : arr) {
            int index = list.indexOf(x);
            while(list.get(0) != x){
                if(index <= list.size()/2) {
                    int tmp = list.get(0);
                    list.add(tmp);
                    list.remove(0);
                    cnt++;
                } else {
                    int tmp = list.get(list.size()-1);
                    for(int i = list.size()-1; i>0; i--){
                        list.set(i,list.get(i-1));
                    }
                    list.set(0, tmp);
                    cnt++;
                }
            }
            if(list.get(0) == x) {
                list.remove(0);
            }
        }
        System.out.println(cnt);

    }
}
