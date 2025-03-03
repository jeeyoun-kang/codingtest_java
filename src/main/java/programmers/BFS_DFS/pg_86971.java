package programmers.BFS_DFS;

import java.util.Stack;

public class pg_86971 {

    class Solution {
        public int solution(int n, int[][] wires) {
            int minDifference = Integer.MAX_VALUE;

            // 1. 모든 간선을 하나씩 끊고 DFS 탐색
            for (int i = 0; i < wires.length; i++) {
                // 간선을 하나 끊고 DFS로 한쪽 서브트리 크기 구하기
                int count = dfsStack(wires, n, wires[i][0], wires[i]);

                // 두 서브트리의 차이 계산 후 최소값 갱신
                minDifference = Math.min(minDifference, Math.abs((n - count) - count));
            }

            return minDifference;
        }

        // dfs
        private int dfsStack(int[][] wires, int n, int start, int[] removed) {
            boolean[] visited = new boolean[n + 1];
            Stack<Integer> stack = new Stack<>();
            stack.push(start);
            visited[start] = true;
            int count = 1;

            while (!stack.isEmpty()) {
                int node = stack.pop();
                for (int[] wire : wires) {
                    // 삭제한 간선은 무시
                    if (wire == removed) continue;

                    // 연결된 노드 찾기
                    int next = (wire[0] == node) ? wire[1] : (wire[1] == node) ? wire[0] : -1;
                    if (next != -1 && !visited[next]) {
                        visited[next] = true;
                        stack.push(next);
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
