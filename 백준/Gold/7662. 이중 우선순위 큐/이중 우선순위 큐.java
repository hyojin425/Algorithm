import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void solution(int n, String[] command) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i< n; i++) {
            String[] commands = command[i].split(" ");
            String c = commands[0];
            int v = Integer.parseInt(commands[1]);
            if(c.equals( "I")) {
                map.put(v, map.getOrDefault(v, 0) + 1);
            } else if(c.equals("D") && !map.isEmpty()) {
                if(v == -1) {
                    int key = map.firstKey();
                    if(map.get(key) == 1) map.remove(key);
                    else map.put(key, map.get(key) - 1);
                } else {
                    int key = map.lastKey();
                    if(map.get(key) == 1) map.remove(key);
                    else map.put(key, map.get(key) - 1);
                }
            }
        }

        if(map.isEmpty()){
            System.out.println("EMPTY");
            return;
        }

        System.out.println(map.lastKey() + " " + map.firstKey());
        return;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i< t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] commands = new String[n];
            for(int j =0 ; j< n; j++) {
                commands[j] = br.readLine();
            }
            solution(n, commands);
        }
    }
}