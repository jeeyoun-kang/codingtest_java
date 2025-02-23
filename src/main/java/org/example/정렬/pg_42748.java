package org.example.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pg_42748 {

        public int[] solution(int[] array, int[][] commands) {

            List<Integer> result = new ArrayList<>();

            for (int[] command : commands) {
                for (int j = 0; j < command.length; j++) {
                    int[] test = Arrays.copyOfRange(array, command[0] - 1, command[1]);
                    Arrays.sort(test);
                    int k = command[2] - 1;
                    result.add(test[k]);
                    break;
                }
            }
            int[] arr = result.stream().mapToInt(Integer::intValue).toArray();
            return arr;
        }
}
