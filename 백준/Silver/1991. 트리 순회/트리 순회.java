import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static char[][] graph;

    public static void dfs1(char c) {
        if(graph[c - 'A'][0] == '.' && graph[c - 'A'][1] == '.') {
            System.out.print(c);
            return;
        }
        else {
            System.out.print(c);
            if(graph[c - 'A'][0] != '.') dfs1(graph[c - 'A'][0]);
            if(graph[c - 'A'][1] != '.') dfs1(graph[c - 'A'][1]);
        }
    }
    
    public static void dfs2(char c) {
        if(graph[c - 'A'][0] == '.' && graph[c - 'A'][1] == '.') {
            System.out.print(c);
            return;
        }
        else {
            if(graph[c - 'A'][0] != '.') dfs2(graph[c - 'A'][0]);
            System.out.print(c);
            if(graph[c - 'A'][1] != '.') dfs2(graph[c - 'A'][1]);
        }
    }

    public static void dfs3(char c) {
        if(graph[c - 'A'][0] == '.' && graph[c - 'A'][1] == '.') {
            System.out.print(c);
            return;
        }
        else {
            if(graph[c - 'A'][0] != '.') dfs3(graph[c - 'A'][0]);
            if(graph[c - 'A'][1] != '.') dfs3(graph[c - 'A'][1]);
            System.out.print(c);
        }
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new char[n][2];
        for(int i = 0; i< n; i++) {
            String s = br.readLine();
            char[] arr = s.replace(" ", "").toCharArray();
            graph[arr[0] - 'A'][0] = arr[1];
            graph[arr[0] - 'A'][1] = arr[2];
        }

        dfs1('A');
        System.out.println();
        dfs2('A');
        System.out.println();
        dfs3('A');
 
    }
}