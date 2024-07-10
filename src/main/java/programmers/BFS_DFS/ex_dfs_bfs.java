package programmers.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ex_dfs_bfs {

    static int n =6;
    static boolean[] visited = new boolean[n]; //false로 초기화

    static int[][] graph = {
            {1, 4},    // 0번 노드와 연결된 노드들
            {0, 2, 3}, // 1번 노드와 연결된 노드들
            {1, 5},    // 2번 노드와 연결된 노드들
            {1, 4, 5}, // 3번 노드와 연결된 노드들
            {0, 3},    // 4번 노드와 연결된 노드들
            {2, 3}     // 5번 노드와 연결된 노드들
    };

    public static void main(String[] args) {

        BFS(0);

       for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            DFS(i,graph, visited);
        }
    }

    static void BFS(int num) {

        //상하좌우로 생각핧때
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    static void DFS(int now, int[][] computers, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(now);

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (visited[temp]) {
                continue;
            }
            visited[temp] = true;
            for (int i = 0; i < computers[temp].length; i++) {
                if (computers[temp][i] == 0) {
                    continue;
                }
                if (temp != i) {
                    stack.push(i);
                }
            }
        }
    }
}
