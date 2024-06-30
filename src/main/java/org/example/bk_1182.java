package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서
// 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성
public class bk_1182 {
    static int s;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        s = Integer.parseInt(split[1]);

        String[] numbers = br.readLine().split(" ");
        int[] test = new int[n];
        for (int i = 0; i < n; i++) {
            test[i] = Integer.parseInt(numbers[i]);
        }


        boolean[] visited = new boolean[test.length];

        for(int r = 1; r <= test.length; r++) {
            combi(test, visited, 0, r);
        }

        System.out.println(answer);
    }


    static void combi(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                combi(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited) {
        int cnt=0;
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true) {
                cnt+=arr[i];
            }
        }
        if(cnt==s){//부분수열이 s인 경우 구하기
            answer+=1;
        }
    }

}
