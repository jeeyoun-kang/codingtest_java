package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk_9663 {

    static int n; //체스판 크기 및 퀸 개수
    static int total = 0;
    static int[] chess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        chess = new int[n];

        dfs(0);
        System.out.println(total);

    }

    private static void dfs(int col) {
        if (col == n) { // 모든 열에 퀸이 배치된 경우
            total += 1;
            return;
        }

        for (int row = 0; row < n; row++) {
            chess[col] = row; //퀸 배치
            if (queen(col)) {
                dfs(col + 1);
            }
        }

    }

    private static boolean queen(int col) {
        for (int i = 0; i < col; i++) {

            //행 체크
            if (chess[col] == chess[i]) {
                return false;
            }

            //대각선 체크
            if (col - i == Math.abs(chess[col] - chess[i])) {
                return false;
            }

        }
        return true;
    }


}
