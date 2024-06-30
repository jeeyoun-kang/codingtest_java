package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소
//Sii는 항상 0이고, 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수
public class bk_14889 {
    static int answer;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());

        int team[][] = new int[n][n]; //축구 능력치 배열

        for (int i = 0; i < n; i++) {
            String test[] = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                team[i][j] = Integer.parseInt(test[j]);
            }

        }

        int arr[] = new int[n];
        for(int k=0;k<n;k++){
            arr[k]=k+1;
        }

        boolean[] visited = new boolean[arr.length];


        //조합으로 경우의 수 구하기
        //뽑고자하는 집합,배열의 크기, 배열,숫자
        comb1(arr, visited, 0, n/2,team);

        //min값 비교하면서 최솟값 구하기

    }


    //1. 백트래킹을 이용해 구현
    static void comb1(int[] arr, boolean[] visited, int start, int r, int[][] team) {
        if(r == 0) {
            print(arr, visited,team);
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, r - 1,team);
                visited[i] = false;
            }
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int[][] team) {
        int[] test = new int[n / 2];
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
