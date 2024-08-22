package programmers;

public class pg_17682 {
    public static void main(String[] args) {
        String test = "1S*2T*3";
        int[] scores = new int[3]; // 3번의 점수를 저장할 배열
        int index = -1; // 점수를 저장할 인덱스

        char[] char_test = test.toCharArray();

        for (int i = 0; i < test.length(); i++) {
            if (Character.isDigit(char_test[i])) {
                index++; // 새로운 점수 시작, 인덱스 증가
                if (char_test[i] == '1' && i + 1 < test.length() && char_test[i + 1] == '0') {
                    // '10' 처리
                    scores[index] = 10;
                    i++; // '0'를 건너뛰기 위해 인덱스 추가
                } else {
                    scores[index] = char_test[i] - '0';
                }
            } else if (char_test[i] == 'S') {
                scores[index] = (int) Math.pow(scores[index], 1);
            } else if (char_test[i] == 'D') {
                scores[index] = (int) Math.pow(scores[index], 2);
            } else if (char_test[i] == 'T') {
                scores[index] = (int) Math.pow(scores[index], 3);
            } else if (char_test[i] == '*') {
                scores[index] *= 2;
                if (index > 0) {
                    scores[index - 1] *= 2; // 이전 점수도 2배로
                }
            } else if (char_test[i] == '#') {
                scores[index] *= -1; // 현재 점수를 마이너스로
            }
        }

        int answer = 0;
        for (int score : scores) {
            answer += score;
        }

        System.out.println(answer);
    }
}
