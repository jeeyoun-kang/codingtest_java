package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


//백준이가 얻을 수 있는 최대 수익을 구하는 프로그램
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        int[][] advice = new int[testcase][2];
        for (int i = 0; i < testcase; i++) {
            String[] a = br.readLine().split(" ");

            for (int j = 0; j < a.length; j++) {
                advice[i][j] = Integer.parseInt(a[j]);
            }
        }
    //현재 기준으로 상담을 하는 경우/ 하지 않는  경우
        //퇴사일 고려
    }
    
}

