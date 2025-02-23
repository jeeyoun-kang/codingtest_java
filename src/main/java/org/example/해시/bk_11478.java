package org.example.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성
public class bk_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Set<String> result = new HashSet<>();

        for(int i=0;i<s.length();i++){
            for(int j=i+1; j<=s.length();j++){
                result.add(s.substring(i,j));
            }
        }

        System.out.println(result.size());


    }
}
