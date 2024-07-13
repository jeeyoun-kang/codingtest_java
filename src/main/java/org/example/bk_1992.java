package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// z방향으로 0,1끼리 압축
public class bk_1992 {

    static int[][] quadTree;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        quadTree = new int[n][n];

        for (int i = 0; i < n; i++) {
            String test = br.readLine();
            for (int j = 0; j < n; j++) {
                quadTree[i][j] = test.charAt(j) - '0';
            }
        }

        recursion(0, 0, n);
        System.out.println(answer.toString());
    }

    private static void recursion(int x, int y, int k) { // 왼쪽 위의 좌표
        int num = quadTree[x][y];
        boolean isSame = true;

        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                if (num != quadTree[i][j]) { //값 비교
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }

        if (isSame) {
            answer.append(num);
        } else {
            answer.append('(');
            recursion(x, y, k / 2);
            recursion(x, y + k / 2, k / 2);
            recursion(x + k / 2, y, k / 2);
            recursion(x + k / 2, y + k / 2, k / 2);
            answer.append(')');
        }
    }
}
