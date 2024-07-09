package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pg_2447 {
    static String[][] arr = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        arr = new String[size][size];

        star(0, 0, size);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // null 상태로 있는 빈공간을 채워주기
                answer.append(arr[i][j] != null ? arr[i][j] : " ");
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }

    public static void star(int x, int y, int size) {
        // 최소 단위(1)로 분할했으면 별 저장
        if (size == 1) {
            arr[x][y] = "*";
            return;
        }

        // size가 1이 될 때까지 3X3 크기로 계속해서 분할
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 가운데 빈공간이면 건너뛰기 (null 상태로 유지하기)
                if (!(i == 1 && j == 1))
                    // x, y 값을 계속 유지하며 재귀 호출
                    star(x + i * size / 3, y + j * size / 3, size / 3);
            }
        }
    }
}