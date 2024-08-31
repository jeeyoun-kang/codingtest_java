package Greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//자신의 위치에서 거리가 K 이하인 햄버거를 먹을 수 있음
//식탁의 길이 햄버거를 선택할 수 있는 거리 사람과 햄버거의 위치가 주어졌을 때, 햄버거를 먹을 수 있는 사람의 최대 수
public class bk_19941 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        //햄버거 위치
        char[] board = br.readLine().toCharArray();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (board[i] == 'P') {
                // 왼쪽에서 가장 가까운 햄버거 찾기
                boolean ateBurger = false; // 햄버거를 먹었는지 확인하는 플래그
                for (int j = i - k; j <= i + k; j++) {
                    if (j < 0 || j >= n) {
                        continue; // 범위를 벗어난 인덱스는 무시
                    }

                    if (board[j] == 'H') {
                        count++;
                        board[j] = 'X'; // 햄버거가 먹혔음을 표시
                        ateBurger = true;
                        break;
                    }
                }

                // 왼쪽에서 햄버거를 못 먹었다면, 오른쪽에서 가장 가까운 햄버거를 찾기
                if (!ateBurger) {
                    for (int j = i + 1; j <= i + k; j++) {
                        if (j >= n) {
                            break; // 범위를 벗어난 인덱스는 무시
                        }

                        if (board[j] == 'H') {
                            count++;
                            board[j] = 'X'; // 햄버거가 먹혔음을 표시
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
