package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class bk_1931 {

//1931
//회의실 사용할 수 있는 회의의 최대갯수 찾아보기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //회의의 수
        int n = Integer.parseInt(br.readLine());

        int[][]array = new int[n][2];

        for(int i=0;i<n;i++) {
            String[] elements = br.readLine().split(" ");
            for(int j=0;j<2;j++) {
                array[i][j] = Integer.parseInt(elements[j]);
            }
        }

        // 종료 시간을 기준으로 정렬, 종료 시간이 같으면 시작 시간을 기준으로 정렬
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int count = 0;
        int endTime = 0;

        for (int i = 0; i<n; i++) {
            if (array[i][0] >= endTime) {
                endTime = array[i][1];
                count++;
            }
        }
        System.out.println(count);
    }

}

