package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk_15658 {
    static int[] num;
    static int[] operators = new int[4]; // +, -, *, /
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        num = new int[n];

        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(split[i]);
        }

        String[] split2 = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(split2[i]);
        }

        dfs(1, num[0]);

        System.out.println(maxResult);
        System.out.print(minResult);
    }

    private static void dfs(int index, int current) {
        if (index == num.length) {
            maxResult = Math.max(maxResult, current);
            minResult = Math.min(minResult, current);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                if (i == 0) {
                    dfs(index + 1, current + num[index]);
                } else if (i == 1) {
                    dfs(index + 1, current - num[index]);
                } else if (i == 2) {
                    dfs(index + 1, current * num[index]);
                } else if (i == 3) {
                    if (num[index] != 0) {
                        if (current < 0) {
                            dfs(index + 1, -(-current / num[index]));
                        } else {
                            dfs(index + 1, current / num[index]);
                        }
                    }
                }

                operators[i]++;
            }
        }
    }
}