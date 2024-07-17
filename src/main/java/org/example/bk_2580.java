package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//0으로 채워진 칸을 스토쿠 답을 채워서 출력
public class bk_2580 {
    static int[][] arr = new int[9][9];

    static boolean[] horizontal= new boolean[9];
    static boolean[] vertical= new boolean[9];
    static boolean[] box= new boolean[9];
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i=0;i<9;i++){
            String[] test = br.readLine().split(" ");
            for(int j=0;j<9;j++){
                arr[i][j]= Integer.parseInt(test[j]);

            }
        }
        //0의 갯수를 토대로 반복문 실행
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(arr[i][j]==0){
                    cnt++;
                }
            }
        }
        //값은 숫자는 9개씩 존재 -> 숫자갯수가 9개에 가까운 숫자 기준으로 박스 안 숫자 채우기
        //같은 행,렬,박스 기준에서 넣으려는 값이 존재한다면 롤백
        while (cnt!=0){
            square();
            horizon();
            verti();
        }

        System.out.println(Arrays.deepToString(arr));

    }

    //3*3 정사각형에 0이 한개일 경우 체크
    private static void square() {
        int[][] coordinate ={{0,0},{0,3},{0,6},
                            {3,0},{3,3},{3,6},
                            {6,0},{6,3},{6,6}};
        for(int k=0;k<9;k++) {
            int testCnt = 0;
            int arrSum = 0;
            int sqareX = 0;//특정 인덱스 저장
            int sqareY = 0;//특정 인덱스 저장
            if (!box[k]) { //방문안한 리스트만 for문 돌게 형성

                for (int i = coordinate[k][0]; i <= coordinate[k][0] + 2; i++) {
                    for (int j = coordinate[k][1]; j <= coordinate[k][1] + 2; j++) {
                        if (arr[i][j] == 0) {
                            testCnt++;
                            sqareX = i;
                            sqareY = j;
                        }
                        arrSum += arr[i][j];
                    }
                }
                if (testCnt == 1) { //박스 한개에 0값이 하나일때
                    arr[sqareX][sqareY] = 45 - arrSum;
                    cnt--;
                }

                if(arrSum==45){ // 모든 값 채워진 가로 한줄 방문처리
                    box[k]=true;
                }

            }
        }

    }

    //세로 한줄에 0이 한개일 경우 체크
    private static void verti() {
        for(int i=0;i<9;i++) {
            int testCnt = 0;
            int arrSum = 0;
            int verti = 0;//특정 인덱스 저장
            if (!vertical[i]) { //방문안한 리스트만 for문 돌게 형성
                for (int j = 0; j < 9; j++) {
                    if (arr[j][i] == 0) {
                        testCnt++;
                        verti = j;
                    }
                    arrSum += arr[j][i];
                }
                if (testCnt == 1) { //가로한줄에 0값이 하나일때
                    arr[verti][i] = 45 - arrSum;
                    cnt--;
                }

                if(arrSum==45){ // 모든 값 채워진 가로 한줄 방문처리
                    vertical[i]=true;
                }
            }
        }
    }

    //가로 한 줄애 0이 한개일 경우 체크, 0이 없는 경우는 방문처리
    private static void horizon() {
        for(int i=0;i<9;i++) {
            int testCnt = 0;
            int arrSum = 0;
            int horizon = 0;//특정 인덱스 저장
            if (!horizontal[i]) { //방문안한 리스트만 for문 돌게 형성
                for (int j = 0; j < 9; j++) {
                    if (arr[i][j] == 0) {
                        testCnt++;
                        horizon = j;
                    }
                    arrSum += arr[i][j];
                }
                if (testCnt == 1) { //가로한줄에 0값이 하나일때
                    arr[i][horizon] = 45 - arrSum;
                    cnt--;
                }

                if(arrSum==45){ // 모든 값 채워진 가로 한줄 방문처리
                    horizontal[i]=true;
                }
            }
        }
    }
}
