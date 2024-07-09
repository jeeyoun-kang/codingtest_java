package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk_2630 {
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                answer[i][j] = Integer.parseInt(a[j]);
            }
        }

        color(n, 0, 0, answer); // 정사각형의 크기, 왼쪽상단의 좌표

        System.out.println(white);
        System.out.print(blue);
    }

    private static void color(int k, int x, int y, int[][] answer) {
        // k길이의 정사각형으로 나눌 때 정사각형의 색이 동일한 경우
        int colorblue = 0;
        int colorwhite = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (answer[x + i][y + j] == 1) {
                    colorblue += 1;
                } else {
                    colorwhite += 1;
                }
            }
        }

        if (colorblue == 0) {
            white += 1;
        } else if (colorwhite == 0) {
            blue += 1;
        } else {
            color(k / 2, x, y, answer);
            color(k / 2, x + k / 2, y, answer);
            color(k / 2, x, y + k / 2, answer);
            color(k / 2, x + k / 2, y + k / 2, answer);
        }
    }
}