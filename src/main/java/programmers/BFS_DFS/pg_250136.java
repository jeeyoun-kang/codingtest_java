package programmers.BFS_DFS;

import java.util.*;

//candidiate에 방문한 좌표의 열을 set으로 더한뒤, 탐색이 끝난뒤, 해당 덩어리의 석유의 값을 열에 더해준다.
public class pg_250136 {

    private boolean[][] visited;
    private int cnt;

    public int solution(int[][] land) {
        int[] answer = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];

        for (int x = 0; x < land.length; x++) {
            for (int y = 0; y < land[0].length; y++) {
                if (land[x][y] == 1 && !visited[x][y]) {
                    cnt = 0; // cnt 초기화
                    Set<Integer> candidates = new HashSet<>();
                    //saveStone(y, x, land, candidates);
                    saveStone2(y, x, land, candidates);
                    for (int candidate : candidates) {
                        answer[candidate] += cnt;
                    }
                }
            }
        }

        // 가장 많은 석유량 반환
        return Arrays.stream(answer).max().orElse(0);
    }

    private void saveStone(int startY, int startX, int[][] land, Set<Integer> candidates) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startY);
        stack.push(startX);

        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};

        while (!stack.isEmpty()) {
            int x = stack.pop();
            int y = stack.pop();

            if (visited[x][y]) continue;

            visited[x][y] = true;
            cnt++;
            candidates.add(y);

            for (int z = 0; z < 4; z++) {
                int newY = y + dy[z];
                int newX = x + dx[z];
                if (0 <= newY && 0 <= newX && newY < land[0].length && newX < land.length && land[newX][newY] == 1 && !visited[newX][newY]) {
                    stack.push(newY);
                    stack.push(newX);
                }
            }
        }
    }

    private void saveStone2(int startY, int startX, int[][] land, Set<Integer> candidates) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});

        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int y = pos[0];
            int x = pos[1];

            if (visited[x][y]) continue;

            visited[x][y] = true;
            cnt++;
            candidates.add(y);

            for (int z = 0; z < 4; z++) {
                int newY = y + dy[z];
                int newX = x + dx[z];
                if (0 <= newY && 0 <= newX && newY < land[0].length && newX < land.length && land[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.offer(new int[]{newY, newX});
                }
            }
        }
    }
}
