package programmers.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class pg_154538 {
    public int solution(int x, int y, int n) {
        // BFS를 위한 큐 초기화
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0}); // 초기 상태를 큐에 추가합니다.

        boolean[] visited = new boolean[y + 1]; // 방문한 상태를 추적하기 위한 배열

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int count = current[1];

            // 현재 값이 목표 값과 같으면 연산 횟수를 반환합니다.
            if (value == y) {
                return count;
            }

            // 방문한 적이 없는 값에 대해서만 연산을 수행합니다.
            if (value > y || visited[value]) {
                continue;
            }

            // 현재 값을 방문한 것으로 표시합니다.
            visited[value] = true;

            // 세 가지 경우를 큐에 추가합니다.
            if (value + n <= y) {
                queue.offer(new int[]{value + n, count + 1});
            }
            if (value * 2 <= y) {
                queue.offer(new int[]{value * 2, count + 1});
            }
            if (value * 3 <= y) {
                queue.offer(new int[]{value * 3, count + 1});
            }
        }

        return -1; // 목표 값에 도달할 수 없는 경우
    }

}
