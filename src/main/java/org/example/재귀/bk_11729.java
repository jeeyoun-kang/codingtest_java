package org.example.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk_11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //원판 개수

        System.out.println((int)Math.pow(2,n)-1);

        hanoi(n, 1, 3, 2); // 1번 장대에서 3번 장대로 옮기기, 2번 장대는 보조 장대


    }
    public static void hanoi(int n, int from, int to, int mid) {
        if (n == 1) {
            System.out.println(from+" "+to);
            return;
        }

        // N-1개의 원판을 중간 장대로 옮기는 과정
        hanoi(n - 1, from, mid, to);

        // 가장 큰 원판을 목표 장대로 옮기기
        System.out.println(from+" "+to);

        //N-1개의 원판을 중간 장대에서 목표 장대로 옮기는 부분
        hanoi(n-1,mid,to,from);

    }
}
