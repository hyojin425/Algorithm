import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static List<Integer> tree = new ArrayList<>();
    static int idx = 0;
    public static void dfs(int min, int max) {
        if(idx == tree.size()) return;
        if(tree.get(idx) > max || tree.get(idx) < min) return;
        int root = tree.get(idx);
        idx++;
        dfs(min, root);
        dfs(root, max);
        System.out.println(root);

        return;
    }
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      

       String line;
while ((line = br.readLine()) != null) {
    if (line.isEmpty()) break;   
    tree.add(Integer.parseInt(line));
}

        dfs(Integer.MIN_VALUE, Integer.MAX_VALUE);


    }
}
    