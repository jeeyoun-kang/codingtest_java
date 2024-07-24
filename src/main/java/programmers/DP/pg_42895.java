package programmers.DP;

import java.util.*;
public class pg_42895 {

    static int N = 2;
    static int number = 11;


    class Solution {
        public int solution(int N, int number) {
            if (N == number) {
                return 1;
            }

            // dp[i]는 N을 i번 사용해서 만들 수 있는 모든 숫자들의 집합
            List<Set<Integer>> dp = new ArrayList<>();

            // 초기화
            for (int i = 0; i < 9; i++) {
                dp.add(new HashSet<>());
            }

            // N을 i번 이어붙인 숫자
            int cnt = N;
            for (int i = 1; i <= 8; i++) {
                dp.get(i).add(cnt);
                cnt = cnt * 10 + N;
            }

            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j < i; j++) {
                    for (int a : dp.get(j)) {
                        for (int b : dp.get(i - j)) {
                            dp.get(i).add(a + b);
                            dp.get(i).add(a - b);
                            dp.get(i).add(a * b);
                            if (b != 0) {
                                dp.get(i).add(a / b);
                            }
                        }
                    }
                }
                // 현재 i 횟수로 number를 만들 수 있는지 확인
                if (dp.get(i).contains(number)) {
                    return i;
                }
            }

            // 최솟값이 8보다 크면 -1 반환
            return -1;
        }
    }

}

