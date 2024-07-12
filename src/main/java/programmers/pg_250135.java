package programmers;

//1초 초침 6도, 분침 0.1도, 시침 1/120도
public class pg_250135 {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

        //시작 시간과 종료 시간을 초 단위로 변환
        int start = toSec(h1, m1, s1);
        int end = toSec(h2, m2, s2);

        //총 초 단위로 계산된 시간을 사용하여 알람 횟수를 계산
        int num = end * 59 / 3600 + end * 719 / 43200 - start * 59 / 3600 - start * 719 / 43200;

        //시작 시간이 12시간(43200) 이상이면 알람 횟수를 조정
        if (start >= 43200) {
            num += 1;
        }

        //종료 시간이 12시간(43200) 이상이면 알람 횟수를 조정
        if (end >= 43200) {
            num -= 1;
        }

        //시작 시간이 정각이거나 알람이 울리는 특별 조건이면 알람횟수 추가
        if (start * 59 % 3600 == 0 || start * 719 % 43200 == 0) {
            num += 1;
        }

        return num;
    }

    //시침/분침/초침을 초단위로 변환
    private static int toSec(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

}
