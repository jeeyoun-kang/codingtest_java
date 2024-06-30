package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//N개의 센서가 적어도 하나의 집중국과는 통신이 가능
//각 집중국의 수신 가능 영역의 길이의 합을 최소화
public class bk_2212 {
    public static void main(String[] args) throws IOException {
// BufferedReader를 사용하기 위해서는 throws IOException을 해 주어야 함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());


        List<Integer> list = new ArrayList<>();
        String line = br.readLine();

        String[] numbers = line.split(" ");
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }

        if (k >= n) {
            // 집중국의 수가 센서 수보다 많거나 같으면 모든 센서에 집중국을 설치할 수 있음
            System.out.println(0);
            return;
        }

        Collections.sort(list); //정렬
        List<Integer> sortedList = new ArrayList<>(list);

        // 인접한 인덱스간 거리를 계산
        List<Integer> distances = new ArrayList<>();
        for (int i = 1; i < sortedList.size(); i++) {
            distances.add(sortedList.get(i) - sortedList.get(i - 1));
        }
        Collections.sort(distances,Comparator.reverseOrder()); //인접한 인덱스 간 거리가 먼 기준으로 정렬
        int long_index= 0;
        for (int i = 0; i < k-1; i++) {
            long_index+=distances.get(i);
        }
        //센서거리 - 인접한 인덱스의 먼 간격들의 묶음
        System.out.println(list.get(list.size()-1)-list.get(0)-long_index);

    }
}