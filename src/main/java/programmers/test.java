package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {

    private static String today = "2020.01.01";
    private static String[] terms = {"A 1"};
    private static String[] privacies = {"2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.09 A", "2019.12.01 A"};

    public static void main(String[] args) {

        String[] strings = today.split("\\.");
        Integer[] today_arr = {Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2])};

        Map<String, Integer> map = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();

        for (String term : terms) {
            String[] split = term.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }

        for (int i=0;i<privacies.length;i++) {
            String[] split = privacies[i].split(" ");
            int date = Integer.parseInt(split[0].replaceAll("\\.",""));
            Integer[] period = period(date, map.get(split[1]));
            for (int j = 0; j < today_arr.length; j++) {
                if (today_arr[j] > period[j]) {
                    list.add(i + 1);
                    break;
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }

    }

    private static Integer[] period(int date, int term){

        int day = date % 100;
        int month = (date / 100) % 100;
        int year = date / 10000;


        if (day == 1) {
            day = 28;
            month += term - 1;
        }else{
            day -= 1;
            month += term;
        }

        year += month / 12;
        month %= 12;

        return new Integer[]{year, month, day};
    }
}
