package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수 -> bfs
public class bk_2178 {

    static int n;
    static int m;
    static boolean[][] visited;

    //static int[][] clone;

    static int[][] miro;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" "); //n,m
        n = Integer.parseInt(xy[0]);
        m = Integer.parseInt(xy[1]);

        miro = new int[n][m];
        //clone = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String test = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = Character.getNumericValue(test.charAt(j)); // 각 문자를 숫자로 변환하여 저장
            }
        }

        int [][]clone = miro.clone();
        visited[0][0] = true;
        bfs(0, 0,clone);

        System.out.println(clone[n - 1][m - 1]);
    }

    private static void bfs(int x, int y,int[][] clone) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});


        while (!queue.isEmpty()) {
            int[] testQueue = queue.poll();

            if (testQueue[0] == n && testQueue[1] == m) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = dx[i] + testQueue[0];
                int newY = dy[i] + testQueue[1];
                if (0 <= newX && newX < n && 0 <= newY && newY < m && !visited[newX][newY] && miro[newX][newY] == 1) {
                    clone[newX][newY] = clone[testQueue[0]][testQueue[1]] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
