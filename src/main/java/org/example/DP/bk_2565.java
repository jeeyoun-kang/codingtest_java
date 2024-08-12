package org.example.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해
// 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성
public class bk_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int elecCnt = Integer.parseInt(br.readLine());

        int[][] elec = new int[elecCnt][2];

        for (int i = 0; i < elecCnt; i++) {
            String[] elecSplit = br.readLine().split(" ");
            elec[i][0] = Integer.parseInt(elecSplit[0]);
            elec[i][1] = Integer.parseInt(elecSplit[1]);
        }

        //A전봇대 기준으로 정렬
        Arrays.sort(elec, Comparator.comparingInt(o -> o[0]));
        //Arrays.sort(elec,(o1,o2) -> o1[0]-o2[0]);


        //B전봇대에 있는 전기줄 위치 따로 추출
        int[] elecB = new int[elecCnt];
        for (int i = 0; i < elecCnt; i++) {
            elecB[i] = elec[i][1];
        }
        int[] dp = new int[elecCnt]; //인덱스 : 전기줄 위치 기준 최대값 세팅
        Arrays.fill(dp, 1); //1로 초기화
        for (int i = 1; i < elecCnt; i++) {
            for (int j = 0; j < i; j++) {
                //A로 정렬된 특정 B전봇대의 위치를 기준으로 작은값들 비교 후 최대값 업데이트
                if (elecB[j] < elecB[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result =0;
        for (int i = 0; i < elecCnt; i++){
            if(dp[i]>result){
                result=dp[i];
            }
        }
        System.out.println(elecCnt-result);
    }
}
