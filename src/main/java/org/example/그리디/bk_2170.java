package org.example.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//그려진 선(들)의 총 길이를 구하는 프로그램을 작성하시오.
//선이 여러 번 그려진 곳은 한 번씩만 계산
public class bk_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] line = new int[n][2];

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            String[] s = br.readLine().split(" ");
            line[i][0]= Integer.parseInt(s[0]);
            line[i][1] =Integer.parseInt(s[1]);
            if(i==0){
                result.add(line[i][0]);
                result.add(line[i][1]);
            }
        }

        Arrays.sort(line, Comparator.comparingInt(a -> a[0]));

        for(int i=1;i<n;i++) {
            int lastEnd = result.get(result.size() - 1); // 현재 저장된 마지막 끝 지점

            if (lastEnd >= line[i][0]) { // 겹치는 구간이 있을 때
                result.set(result.size() - 1, Math.max(lastEnd, line[i][1])); // 끝 지점을 최대값으로 확장
            }
            else{
                result.add(line[i][0]);
                result.add(line[i][1]);

            }
        }

        int sum=0;

        for(int i=1; i<result.size();i+=2){
            sum+= result.get(i)-result.get(i-1);
        }

        System.out.println(sum);


    }
}
