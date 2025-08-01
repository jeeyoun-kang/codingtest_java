package programmers.level1;

//1/1 : 금요일 , a/b = ?
public class pg_12901 {
    public static void main(String[] args) {
        solution(9,1);
    }

    private static String solution(int a, int b) {
        int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] result = {"FRI", "SAT","SUN", "MON", "TUE", "WED", "THU"};
        int cnt=0;
        for(int i=0;i<monthDays.length;i++){
            if(i+1 == a){
                cnt+=b;
                break;
            }
            cnt+=monthDays[i];
        }
        System.out.println(result[cnt%7==0?result.length-1:cnt%7-1]);
        return result[cnt%7==0?result.length-1:cnt%7-1];
    }
}
