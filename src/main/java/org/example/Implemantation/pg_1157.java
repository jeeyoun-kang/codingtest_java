package org.example.Implemantation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class pg_1157 {
    public static void main(String[] args) throws IOException {
        int maxValue = 0;
        char answer = ' ';

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        //문자열을 char배열로 변환
        char[] charArray = st.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLowerCase(charArray[i])) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }


        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);

            int newValue = map.getOrDefault(charArray[i], 0) + 1;

            if (newValue > maxValue) {
                maxValue = newValue;
                answer = charArray[i];

            } else if (newValue == maxValue) {
                answer = '?';
            }

        }

        System.out.print(answer);

    }
}
