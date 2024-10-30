public class ny_1030 {
    public static void main(String[] args) {
        // 예제 map 초기화
        int[][] map = {
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 2, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };

        // simulate 메서드 호출하여 최종 map 상태 반환
        int[][] result = simulate(map);

        // 결과 출력
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] simulate(int[][] map) {
        int rows = map.length;
        int cols = map[0].length;

        // 결과를 담을 새로운 배열 초기화
        int[][] result = new int[rows][cols];

        // 기존 map을 result에 복사하고 접착 블럭 주변을 고정
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == 2) { // 접착 블럭은 바로 복사
                    result[i][j] = 2;

                    // 접착 블럭 주변의 1을 고정
                    if (i > 0 && map[i - 1][j] == 1) result[i - 1][j] = 1; // 위
                    if (i < rows - 1 && map[i + 1][j] == 1) result[i + 1][j] = 1; // 아래
                    if (j > 0 && map[i][j - 1] == 1) result[i][j - 1] = 1; // 왼쪽
                    if (j < cols - 1 && map[i][j + 1] == 1) result[i][j + 1] = 1; // 오른쪽
                }
            }
        }

        // 각 열에 대해 1 블럭을 아래로 이동
        for (int col = 0; col < cols; col++) {
            int dropPosition = rows - 1; // 블럭이 떨어질 수 있는 위치

            // 아래에서부터 위로 이동
            for (int row = rows - 1; row >= 0; row--) {
                if (map[row][col] == 2) { // 접착 블럭을 만나면 위치를 고정
                    dropPosition = row - 1;
                } else if (map[row][col] == 1 && result[row][col] != 1) { // 떨어지는 블럭인 경우
                    result[dropPosition][col] = 1; // dropPosition에 고정
                    dropPosition--; // 다음 블럭은 그 위에 고정
                }
            }
        }

        return result;
    }
}
