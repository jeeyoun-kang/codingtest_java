package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class pg_142086 {
    public static void main(String[] args) {
        //solution("banana");
    }

    private static int solution(String s) throws IOException {
        int[] result = new int[s.length()];
        Arrays.fill(result, -1);
        for(int i=0;i<s.length();i++) {
            for(int j=0; j<i; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    result[i]=i-j;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        return 0;

    }
}
