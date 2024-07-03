package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class pg_172927 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 입력
        int[] picks = {1,0,1};
        String[] minerals = {"stone", "stone", "stone", "stone", "stone", "iron", "iron", "iron", "iron", "iron", "diamond", "diamond"};

        // 결과 출력
        int result = solution.solution(picks, minerals);
        System.out.println("최소 피로도: " + result);
    }

    static class Solution {
        static int answer = 0;

        public int solution(int[] picks, String[] minerals) {
            List<MineInfo> mineInfoList = new ArrayList<>();

            // 각 5개의 광물 묶음별 피로도 계산
            for (int i = 0; i < minerals.length; i += 5) {
                int diamondCount = 0, ironCount = 0, stoneCount = 0;
                for (int j = i; j < i + 5 && j < minerals.length; j++) {
                    switch (minerals[j]) {
                        case "diamond":
                            diamondCount++;
                            break;
                        case "iron":
                            ironCount++;
                            break;
                        case "stone":
                            stoneCount++;
                            break;
                    }
                }
                mineInfoList.add(new MineInfo(diamondCount, ironCount, stoneCount));
            }

            // 피로도 합 기준으로 내림차순 정렬
            Collections.sort(mineInfoList, Comparator.comparingInt(MineInfo::getTotalFatigue).reversed());

            // 각 곡괭이를 사용해 광물을 캘 때의 피로도를 계산
            int pickIndex = 0;
            for (MineInfo mineInfo : mineInfoList) {
                while (pickIndex < picks.length && picks[pickIndex] == 0) {
                    pickIndex++;
                }

                if (pickIndex >= picks.length) {
                    break;
                }

                // 피로도를 최소화하는 곡괭이를 선택
                int minFatigue = Integer.MAX_VALUE;
                int bestPick = -1;
                for (int i = 0; i < picks.length; i++) {
                    if (picks[i] > 0) {
                        int fatigue = mineInfo.calculateFatigue(i);
                        if (fatigue < minFatigue) {
                            minFatigue = fatigue;
                            bestPick = i;
                        }
                    }
                }

                if (bestPick != -1) {
                    picks[bestPick]--;
                    answer += mineInfo.calculateFatigue(bestPick);
                }
            }

            return answer;
        }

        // 광물 묶음의 정보를 저장하는 클래스
        static class MineInfo {
            int diamondCount;
            int ironCount;
            int stoneCount;

            public MineInfo(int diamondCount, int ironCount, int stoneCount) {
                this.diamondCount = diamondCount;
                this.ironCount = ironCount;
                this.stoneCount = stoneCount;
            }

            // 총 피로도를 계산하는 메서드
            public int getTotalFatigue() {
                return diamondCount * 25 + ironCount * 5 + stoneCount;
            }

            // 해당 곡괭이로 캘 때의 피로도를 계산하는 메서드
            public int calculateFatigue(int pickType) {
                int fatigue = 0;
                switch (pickType) {
                    case 0: // 다이아 곡괭이
                        fatigue = diamondCount + ironCount + stoneCount;
                        break;
                    case 1: // 철 곡괭이
                        fatigue = diamondCount * 5 + ironCount + stoneCount;
                        break;
                    case 2: // 돌 곡괭이
                        fatigue = diamondCount * 25 + ironCount * 5 + stoneCount;
                        break;
                }
                return fatigue;
            }
        }
    }
}
