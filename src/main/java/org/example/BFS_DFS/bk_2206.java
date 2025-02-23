package org.example.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//최단 경로 , 시작하는 칸과 끝나는 칸도 포함해서 센다
//만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이
// 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.
public class bk_2206 {
    static int n = 0;
    static int m = 0;
    static int[][] arr;
    static int[][] visited1;
    static int[][] visited2;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n][m];
        visited1 = new int[n][m];
        visited2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0}); // {x, y, 벽을 뚫은 여부 (0: 안 뚫음, 1: 뚫음)}
        visited1[x][y] = 1; // 시작 지점 포함

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int currX = node[0];
            int currY = node[1];
            int wallBroken = node[2];

            // 도착 지점에 도달하면 경로의 길이 반환
            if (currX == n - 1 && currY == m - 1) {
                return wallBroken == 0 ? visited1[currX][currY] : visited2[currX][currY];
            }

            for (int i = 0; i < 4; i++) {
                int xx = currX + dx[i];
                int yy = currY + dy[i];

                if (0 <= xx && xx < n && 0 <= yy && yy < m) {
                    if (arr[xx][yy] == 0) {
                        // 벽이 없고, 방문하지 않은 경우
                        if (wallBroken == 0 && visited1[xx][yy] == 0) { // 벽을 뚫지 않은 상태에서 이동
                            visited1[xx][yy] = visited1[currX][currY] + 1;
                            queue.offer(new int[]{xx, yy, 0});
                        } else if (wallBroken == 1 && visited2[xx][yy] == 0) { // 벽을 한 번 뚫은 상태에서 이동
                            visited2[xx][yy] = visited2[currX][currY] + 1;
                            queue.offer(new int[]{xx, yy, 1});
                        }
                    } else if (arr[xx][yy] == 1 && wallBroken == 0 && visited2[xx][yy] == 0) {
                        // 벽이 있고, 아직 뚫지 않은 상태에서 벽을 뚫고 이동
                        visited2[xx][yy] = visited1[currX][currY] + 1;
                        queue.offer(new int[]{xx, yy, 1});
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}