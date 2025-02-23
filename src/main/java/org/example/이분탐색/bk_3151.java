package org.example.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//세 팀원의 코딩실력 합 0, 팀 경우의수
public class bk_3151 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 학생 수 입력
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        // 두 번째 줄에서 배열 입력
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }


        // 배열 오름차순 정렬
        Arrays.sort(arr);


        // 두 개의 값을 먼저 선택하고, 나머지 값으로 0이 되는지 확인
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int lower = binarySearch(arr[i] + arr[j], j + 1, 0);
                int upper = binarySearch(arr[i] + arr[j], j + 1, 1);
                //ans += upper - lower;
            }
        }

        // 결과 출력
        //System.out.print(ans);
    }

    private static int binarySearch(int target, int start, int type) {
        int end = N;
        int mid;

        while (end > start) {
            mid = (start + end) / 2;

            if (type == 0 && arr[mid] + target >= 0) {
                end = mid;
            } else if (type == 1 && arr[mid] + target > 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}