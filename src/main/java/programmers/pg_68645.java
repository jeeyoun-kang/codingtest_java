package programmers;

public class pg_68645 {
    class Solution {
        public int[] solution(int n) {
            int[] answer = new int[n*(n+1) / 2]; // 삼각형의 크기 ( 1 ~ n 까지 합)
            int[][] tri = new int[n][n];

            int x = -1;
            int y = 0;
            int num = 1;
            int index = 0;

            for(int i = 0; i < n; i++) {
                for(int j = i; j < n; j++) {
                    if(i % 3 == 0) { // 아래
                        x+=1;
                    }
                    else if(i % 3 == 1) { // 가로
                        y+=1;
                    }
                    else if(i % 3 == 2) { // 위
                        x-=1;
                        y-=1;
                    }
                    tri[x][y] = num;
                    num+=1;
                }
            }


            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(tri[i][j] == 0) break;
                    answer[index] = tri[i][j];
                    index+=1;
                }
            }

            return answer;
        }
    }
}
