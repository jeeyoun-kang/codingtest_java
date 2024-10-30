package programmers.BFS_DFS;

import java.util.*;

public class pg_12909 {


    class Solution {
        boolean solution(String s) {
            Queue<Character> queue = new LinkedList<>();

            // 문자열을 큐에 추가
            for(int i = 0; i < s.length(); i++) {
                queue.offer(s.charAt(i));
            }

            int balance = 0;

            while (!queue.isEmpty()) {
                char test = queue.poll();

                // 여는 괄호일 때
                if (test == '(') {
                    balance++;
                }
                // 닫는 괄호일 때
                else {
                    balance--;
                    if (balance < 0) {
                        return false; // 닫는 괄호가 여는 괄호보다 많을 때 false
                    }
                }
            }

            String test= "1234";


            // 모든 괄호가 짝이 맞으면 balance는 0
            return balance == 0;
        }
    }

}
