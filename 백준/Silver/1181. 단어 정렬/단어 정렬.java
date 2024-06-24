import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 단어의 개수 입력 받기
        int N = scanner.nextInt();
        scanner.nextLine();  // 줄바꿈 문자 소비

        // 단어들을 입력 받아 리스트에 저장
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(scanner.nextLine());
        }
        
        Set<String> uniqueWords = new TreeSet<>(words);

        // 중복 제거된 단어 리스트를 생성
        List<String> sortedWords = new ArrayList<>(uniqueWords);

        // 길이순 및 사전 순으로 정렬
        sortedWords.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 길이가 같으면 사전순으로 정렬
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                // 길이가 다르면 길이순으로 정렬
                return Integer.compare(o1.length(), o2.length());
            }
        });

        // 정렬된 단어들을 출력
        for (String word : sortedWords) {
            System.out.println(word);
        }

        scanner.close();
    }
}
