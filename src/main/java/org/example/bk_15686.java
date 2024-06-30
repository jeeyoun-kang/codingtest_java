package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class bk_15686 {
    private static int N, M;
    private static int[][] city;
    private static List<int[]> chickenHouses = new ArrayList<>();
    private static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);

        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(line[j]);
                if (city[i][j] == 2) {
                    chickenHouses.add(new int[]{i, j}); // 치킨집 위치 저장
                }
            }
        }

        // 모든 경우에 수에 대한 최소 치킨 거리 계산
        List<int[]> combinations = new ArrayList<>();
        combi(combinations, new int[M], 0, 0);
        System.out.println(minDistance);
    }

    // 조합 생성 함수
    private static void combi(List<int[]> combinations, int[] selected, int start, int depth) {
        if (depth == M) {
            minDistance = Math.min(minDistance, Distance(selected));
            return;
        }

        for (int i = start; i < chickenHouses.size(); i++) {
            selected[depth] = i;
            combi(combinations, selected, i + 1, depth + 1);
        }
    }

    // 치킨집 조합에 대한 치킨 거리 계산
    private static int Distance(int[] selected) {
        int totalDistance = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 1) { // 집인 경우
                    int minHouseDistance = Integer.MAX_VALUE;
                    for (int index : selected) {
                        int[] chicken = chickenHouses.get(index);
                        int distance = Math.abs(chicken[0] - i) + Math.abs(chicken[1] - j);
                        minHouseDistance = Math.min(minHouseDistance, distance);
                    }
                    totalDistance += minHouseDistance;
                }
            }
        }
        return totalDistance;
    }
}
