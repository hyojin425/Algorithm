

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float sum=0;
        float pointSum=0;
        for(int i=0; i<20; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            float point =Float.parseFloat(arr[1]);
            pointSum += point;
            switch (arr[2]){
                case "A+": sum+= point * 4.5; break;
                case "A0": sum+= point * 4.0; break;
                case "B+": sum+= point * 3.5; break;
                case "B0": sum+= point * 3.0; break;
                case "C+": sum+= point * 2.5; break;
                case "C0": sum+= point * 2.0; break;
                case "D+": sum+= point * 1.5; break;
                case "D0": sum+= point * 1.0; break;
                case "F":  sum+= point * 0; break;
                case "P": pointSum-=point; break;
            }
        }
        System.out.println(sum/pointSum);
    }
}
