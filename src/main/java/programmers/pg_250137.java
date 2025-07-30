package programmers;

public class pg_250137 {
    public static void main(String[] args) {
        solution(new int[]{5,3,2}, 30, new int[][]{{1,1}, {4,12}});

    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int idx = 0;
        int baseHealth = health;
        int cntBandage = 0;
        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (i == attacks[idx][0]) {
                health -= attacks[idx][1];
                cntBandage=0;
                idx++;
            }
            else if(baseHealth!=health&&cntBandage!=bandage[0]){ //붕대감기
                health += bandage[1];
                if(health>baseHealth){
                    health=baseHealth;
                }
                cntBandage++;
            }
            if(baseHealth!=health&&cntBandage==bandage[0]){ //연속 붕대감기 성공시
                health+=bandage[2];
                cntBandage=0;
            }
            if (health <= 0) { //체력 0이하일때
                health = -1;
                break;
            }
        }
        return health;
    }

}