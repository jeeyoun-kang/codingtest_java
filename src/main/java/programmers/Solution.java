package programmers;

import java.util.Arrays;

public class Solution {
    private boolean[][] visited;
    private int cnt;

    public int solution(int[][] land) {
        int[] answer = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];

        for (int y = 0; y < land[0].length; y++) {
            // 각 열에 대한 탐색을 시작할 때 visited 배열 초기화
            resetVisited();
            for (int x = 0; x < land.length; x++) {
                if (land[x][y] == 1 && !visited[x][y]) {
                    cnt = 0; // cnt 초기화
                    saveStone(y, x, land);
                    answer[y] += cnt; // 결과 저장
                }
            }
        }

        // 가장 많은 석유량 반환
        return Arrays.stream(answer).max().orElse(0);
    }

    private void saveStone(int y, int x, int[][] land) {
        visited[x][y] = true; // 방문 표시
        cnt++;
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};

        for (int z = 0; z < 4; z++) {
            int newY = y + dy[z];
            int newX = x + dx[z];
            if (0 <= newY && 0 <= newX && newY < land[0].length && newX < land.length && land[newX][newY] == 1 && !visited[newX][newY]) {
                saveStone(newY, newX, land);
            }
        }
    }

    private void resetVisited() {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }
}
