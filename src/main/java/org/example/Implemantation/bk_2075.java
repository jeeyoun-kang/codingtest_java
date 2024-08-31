package org.example.Implemantation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bk_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 2차원 배열을 1차원 배열로 변환
        int[] flatArray = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flatArray[index++] = board[i][j];
            }
        }

//        // 내림차순 정렬
//        Integer[] arr2 = Arrays.stream(flatArray).boxed().toArray(Integer[]::new);
//
//        Arrays.sort(arr2, Collections.reverseOrder());
//
//        // N번째로 큰 수 출력
//        System.out.println(arr2[n-1]);

        // 오름차순
        Arrays.sort(flatArray);
        System.out.println(flatArray[n * n - n]);



    }
}
