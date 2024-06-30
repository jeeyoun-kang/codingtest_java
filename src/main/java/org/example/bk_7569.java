package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bk_7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]); // 가로 크기
        int n = Integer.parseInt(input[1]); // 세로 크기
        int h = Integer.parseInt(input[2]); // 높이
        int[][][] arr = new int[h][n][m]; // 토마토 창고

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                input = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(input[k]);
                }
            }
        }
        System.out.println(bfs(arr, h, n, m));
    }

    private static int bfs(int[][][] arr, int h, int n, int m) {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        Queue queue = new LinkedList();
        int day = 0;

        // 익은 토마토를 큐에 추가
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        // bfs
        while (!queue.isEmpty()) {
            int tomato[] = (int[]) queue.poll();
            int x = tomato[0];
            int y = tomato[1];
            int z = tomato[2];
            day = tomato[3];

            for (int i = 0; i < 6; i++) { // 6방향으로 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx >= 0 && nx < h && ny >= 0 && ny < n && nz >= 0 && nz < m) {
                    if (arr[nx][ny][nz] == 0) {
                        arr[nx][ny][nz] = 1;
                        queue.offer(new int[]{nx, ny, nz, day + 1});
                    }
                }
            }
        }

        // 익지 않은 토마토 체크
        if (check(arr, h, n, m)) {
            return day;
        } else {
            return -1;
        }
    }

    // 토마토의 상태 체크
    private static boolean check(int arr[][][] , int h, int n, int m) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
