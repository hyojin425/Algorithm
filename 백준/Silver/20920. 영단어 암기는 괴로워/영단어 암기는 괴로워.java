import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void solution(int m, List<String> list) {
        Map<String, Integer> words = new HashMap<>();
        for (String word : list) {
            if (word.length() >= m) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        List<Word> note = new ArrayList<>();
        for(Map.Entry<String, Integer> word : words.entrySet()) {
            note.add(new Word(word.getKey(), word.getValue()));
        }

        Collections.sort(note);

        StringBuilder sb = new StringBuilder();
        for (Word w : note) {
            sb.append(w.word).append('\n');
        }
        System.out.print(sb);
    }

    public static class Word implements Comparable<Word> {
        String word;
        int freq;

        public Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }


        public int compareTo(Word o) {
            if(o.freq != this.freq) {
                return o.freq - this.freq;
            } else if(o.word.length() != this.word.length()) {
                return o.word.length() - this.word.length();
            } else {
                return this.word.compareTo(o.word);
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }
        solution(m, words);
    }
}