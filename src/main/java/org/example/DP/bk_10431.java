package org.example.DP;

import java.util.*;
import java.util.stream.Collectors;

//순서의 중복 제거를 위한 dp 이차원 점화식 세우기
// 2차원인덱스를 마지막 더해진 숫자를 의미 dp[n][a] , a: 마지막 더한 숫자
//or dp[i][j]일때, 숫자i를 만들때 , j개의 숫자를 사용한 경우의 수
public class bk_10431 {
    public static void main(String[] args) {


        int[] list = {1,2,3};

        Integer[] arr2 = Arrays.stream(list).boxed().toArray(Integer[]::new);
        System.out.println(arr2);

        List<Integer> arr3 = Arrays.stream(list).boxed().collect(Collectors.toList());


    }
}
