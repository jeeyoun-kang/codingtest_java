package programmers.BFS_DFS;
import java.util.*;
public class pg_84512 {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static int[] weights = {781, 156, 31, 6, 1}; // 각 자리에서 가지는 가중치 (자리마다 5^n-1)

    public static void main(String[] args) {
        // 예시: 단어 "AAAAE"가 사전에서 몇 번째인지 계산
        String word = "AAAAE";
        System.out.println("Word: " + word + ", Position: " + getPosition(word));
    }

    // 단어의 위치를 계산하는 함수
    static int getPosition(String word) {
        int position = 0;

        for (int i = 0; i < word.length(); i++) {
            // 현재 문자의 위치를 찾고 가중치를 적용
            int index = findIndex(word.charAt(i));
            position += index * weights[i] + 1;
            System.out.println(position);
        }

        return position;
    }

    // 문자의 인덱스(A:0, E:1, I:2, O:3, U:4)를 반환
    static int findIndex(char c) {
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == c) {
                return i;
            }
        }
        return -1; // 오류 방지를 위한 기본 값
    }



    //문제에 정의한 리스트를 직접 만든 후 값 찾기
    class Solution1 {
        static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        static List<String> dictionary = new ArrayList<>();

        public int solution(String word) {
            // DFS로 모든 가능한 단어를 생성
            generateWords("", 0);
            System.out.println(dictionary);

            // 단어의 인덱스를 반환
            return dictionary.indexOf(word) + 1;  // 인덱스는 0부터 시작하므로 +1
        }

        // DFS 방식으로 단어 생성
        static void generateWords(String currentWord, int depth) {
            if (depth > 5) {
                return;  // 길이가 5를 넘으면 종료
            }

            if (!currentWord.isEmpty()) {
                dictionary.add(currentWord);  // 단어를 리스트에 추가
            }

            // 각 모음에 대해 다음 단어를 생성
            for (char vowel : vowels) {
                generateWords(currentWord + vowel, depth + 1);  // 재귀 호출로 다음 글자 추가
            }
        }
    }

    //수학적 가중치 계산을 이용한 값 찾기
    class Solution2 {
        static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        static int[] weights = {781, 156, 31, 6, 1};  // 각 자리가 가지는 가중치

        public int solution(String word) {
            int position = 0;

            for (int i = 0; i < word.length(); i++) {
                int index = findIndex(word.charAt(i));  // 현재 문자의 위치를 찾음
                position += index * weights[i] + 1;     // 가중치를 적용하여 위치를 계산
            }

            return position;  // 최종 위치 반환
        }

        // 주어진 문자가 'A', 'E', 'I', 'O', 'U' 중 몇 번째인지 반환하는 메소드
        static int findIndex(char c) {
            for (int i = 0; i < vowels.length; i++) {
                if (vowels[i] == c) {
                    return i;
                }
            }
            return -1;  // 오류 방지를  기본 값 (실제로는 발생하지 않음)
        }
    }

}
