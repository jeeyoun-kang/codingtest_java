package programmers;

import java.util.*;

public class pg_150370 {

    // static 변수로 선언된 today, terms, privacies
    static String today = "2022.05.19";
    static String[] terms = {"A 6", "B 12", "C 3"};
    static String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

    // solution 메서드에서 static 변수들을 사용
    public int[] solution() {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (map.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }

    public static void main(String[] args) {
        pg_150370 pg = new pg_150370();
        int[] result = pg.solution();
        System.out.println(Arrays.toString(result)); // 결과를 출력
    }
}