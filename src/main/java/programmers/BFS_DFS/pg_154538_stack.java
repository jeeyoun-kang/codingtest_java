package programmers.BFS_DFS;
import java.util.Stack;
public class pg_154538_stack {
    public int solution(int x, int y, int n) {
        // 스택을 사용하여 각 상태를 저장합니다. 배열의 첫 번째 요소는 현재 값, 두 번째 요소는 연산 횟수입니다.
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, 0}); // 초기 상태를 스택에 추가합니다.

        int answer = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int value = current[0];
            int count = current[1];

            if (value == y) {
                answer = Math.min(answer, count);
                continue;
            }

            if (value > y) {
                continue;
            }

            stack.push(new int[]{value + n, count + 1});
            stack.push(new int[]{value * 2, count + 1});
            stack.push(new int[]{value * 3, count + 1});
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

}
