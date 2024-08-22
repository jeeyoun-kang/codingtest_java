package programmers.BFS_DFS;

import java.util.*;

public class pg_42840 {

    //class Solution {
    public int[] solution(int[] answers) {
        //반복적 패턴
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) {
                a += 1;
            }
            if (answers[i] == two[i % two.length]) {
                b += 1;
            }
            if (answers[i] == three[i % three.length]) {
                c += 1;
            }

        }

        HashMap<Integer, Integer> scores = new HashMap<>();

        // ID와 점수를 HashMap에 저장
        scores.put(1, a);  // ID 1 -> 점수 a
        scores.put(2, b);  // ID 2 -> 점수 b
        scores.put(3, c);  // ID 3 -> 점수 c
        // 가장 높은 점수를 받은 사람의 ID를 저장할 리스트
        List<Integer> topScorers = new ArrayList<>();

        int maxScore = Collections.max(scores.values());

        // 가장 높은 점수를 받은 사람의 ID를 리스트에 추가
        for (HashMap.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (entry.getValue() == maxScore) {
                topScorers.add(entry.getKey());
            }
        }


        int[] topScorersArray = new int[topScorers.size()];
        for (int i = 0; i < topScorers.size(); i++) {
            topScorersArray[i] = topScorers.get(i);
        }

        return topScorersArray;



    }
    //}
}
