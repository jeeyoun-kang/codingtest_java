package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지,
// 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력
public class bk_2583 {
    static boolean graph[][]
            ;
    static int m, n;
    static int count; //영역 넓이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        List<Integer> list = new ArrayList<>();
        graph = new boolean[m][n];

        //직사각형 좌표 설정
        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int m1 = Integer.parseInt(input[1]);
            int n2 = Integer.parseInt(input[2]) - 1;
            int m2 = Integer.parseInt(input[3]) - 1;
            for (int j = m1; j <= m2; j++) {
                for (int l = n1; l <= n2; l++) {
                    graph[j][l] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!graph[i][j]) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list); //오름차순 정렬
        sb.append(list.size()).append("\n");
        for (int area : list) {
            sb.append(area).append(" ");
        }
        System.out.print(sb);

        //// 리스트를 정렬한 후, 스트림을 사용하여 문자열로 변환하고 결합
        //String result = list.stream()
        //                    .sorted() // 정렬
        //                    .map(String::valueOf) // 문자열로 변환
        //                    .reduce(list.size() + "\n", (acc, s) -> acc + s + " "); // 리스트 크기와 함께 결합
        //
        //System.out.print(result.trim()); // 마지막 공백 제거 후 출력
    }

    private static void dfs(int y, int x) {
        // 방문 처리
        graph[y][x] = true;
        count++;
        
        if (y > 0 && !graph[y - 1][x]) { // 위
            dfs(y - 1, x);
        }
        if (y < m - 1 && !graph[y + 1][x]) { // 아래
            dfs(y + 1, x);
        }
        if (x > 0 && !graph[y][x - 1]) { // 왼쪽
            dfs(y, x - 1);
        }
        if (x < n - 1 && !graph[y][x + 1]) { // 오른쪽
            dfs(y, x + 1);
        }
    }
}
