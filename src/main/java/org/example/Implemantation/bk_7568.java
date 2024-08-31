package org.example.Implemantation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제의 핵심은 자신보다 덩치가 큰 사람이 기준 -> rank 업뎃

public class bk_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] person = new int[n][2];
        int[] result = new int[n];

        // 사람의 몸무게와 키 입력 받기
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            person[i][0] = Integer.parseInt(s[0]); // 몸무게
            person[i][1] = Integer.parseInt(s[1]); // 키
            result[i] = 1; // 초기 등수는 1로 설정
        }

        // 모든 사람을 서로 비교하여 등수 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
                    result[i]+=1; // 자신보다 덩치가 큰 사람이 있으면 등수 증가
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
