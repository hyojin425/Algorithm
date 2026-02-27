import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Music>> map = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            if(!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>());
            }
            map.get(genres[i]).add(new Music(i, plays[i]));
            sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        int max = Integer.MIN_VALUE;
        List<Genre> genreList = new ArrayList<>();
        for(Map.Entry<String, Integer> e: sumMap.entrySet()) {
            genreList.add(new Genre(e.getKey(), e.getValue()));
        }
        genreList.sort(null);
        
        List<Integer> result = new ArrayList<>();
        for(Genre g: genreList) {
            List<Music> tmp = map.get(g.genre);
            tmp.sort(null);
            result.add(tmp.get(0).idx);
            if(tmp.size() > 1) {
                result.add(tmp.get(1).idx);
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public static class Genre implements Comparable<Genre> {
        String genre;
        int totalPlay;
        
        public Genre (String genre, int totalPlay) {
            this.genre = genre;
            this.totalPlay = totalPlay;
        }
        
        public int compareTo(Genre o) {
            return Integer.compare(o.totalPlay, this.totalPlay);
        }
    }
    
    public static class Music implements Comparable<Music>{
        int idx;
        int play;
        
        public Music(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        
        public int compareTo(Music o) {
            if(this.play == o.play) {
                return this.idx - o.idx;
            }
            return o.play - this.play;
        }
    }
}