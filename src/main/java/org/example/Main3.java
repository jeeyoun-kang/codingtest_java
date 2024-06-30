package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//k개중 6개를 골라 재귀
public class Main3 {
    static int k;
    static int[] S;
    static int[] num;
    static StringBuilder testcase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase =  new StringBuilder();

        while (true) {
            String line = br.readLine().trim();
            if (line.equals("0"))
                break;

            String[] input = line.split(" ");
            k = Integer.parseInt(input[0]);
            S = new int[k];
            num = new int[6];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(input[i + 1]);
            }

            combi(0, 0);
            testcase.append("\n");
        }

        System.out.print(testcase.toString());
    }
    static void combi(int idx, int cnt) {
            if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                testcase.append(num[i]).append(" ");
            }
            testcase.append("\n");
            return;
        }

        if (idx == k)
            return;

        for (int i = idx; i < k; i++) {
            num[cnt] = S[i];
            combi(i + 1, cnt + 1);
        }
    }

}