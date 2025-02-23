package org.example.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class bk_2448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] pattern = new char[n][2 * n - 1];
        for (char[] row : pattern) {
            Arrays.fill(row, ' ');  // 배열을 공백으로 초기화
        }

        // 재귀적으로 패턴을 채움
        createPattern(pattern, n, 0, n - 1);

        // 패턴 출력
        for (char[] row : pattern) {
            System.out.println(row);
        }
    }

    private static void createPattern(char[][] pattern, int size, int x, int y) {
        if (size == 3) {
            // 기본 패턴 설정
            pattern[x][y] = '*';
            pattern[x + 1][y - 1] = '*';
            pattern[x + 1][y + 1] = '*';
            pattern[x + 2][y - 2] = '*';
            pattern[x + 2][y - 1] = '*';
            pattern[x + 2][y] = '*';
            pattern[x + 2][y + 1] = '*';
            pattern[x + 2][y + 2] = '*';
            return;
        }

        int newSize = size / 2;

        // 위쪽 삼각형
        createPattern(pattern, newSize, x, y);

        // 아래 왼쪽 삼각형
        createPattern(pattern, newSize, x + newSize, y - newSize);

        // 아래 오른쪽 삼각형
        createPattern(pattern, newSize, x + newSize, y + newSize);
    }
}