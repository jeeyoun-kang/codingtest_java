package org.example;

import java.util.*;

public class test {
    public static void main(String[] args) {

//        정수를 이어붙여 만들 수 있는 가장 큰수

        int[] numbers = {6,10,2};

        String[] arr = new String[numbers.length];

        for(int i=0;i<arr.length;i++){
            arr[i]=String.valueOf(numbers[i]);
        }

        //두수를 합친 값이 큰 순서대로(내림차순)

        //o1 : 10, o2 : 2 이면 102,210중 어떤게 더 큰지 비교
        Arrays.sort(arr,(o1,o2)->((o2+o1).compareTo(o1+o2)));

        System.out.println(String.join("",arr));

    }
}
