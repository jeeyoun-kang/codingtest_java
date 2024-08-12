package programmers;
import java.util.*;

public class pg_42583 {
    public static void main(String[] args) {


        class Solution {
            public int solution(int bridge_length, int weight, int[] truck_weights) {
                int time = 0;

                Deque<Integer> deque = new LinkedList<>();  // 다리 위 트럭의 무게를 저장하는 덱
                int bridge_truck_weight = 0;  // 다리 위에 있는 트럭의 총 무게
                int index = 0;  // 현재 처리 중인 트럭의 인덱스

                // 트럭이 다리 위에서 보낸 시간을 저장하는 배열
                int[] truckTime = new int[truck_weights.length];

                // 초기 상태: 첫 번째 트럭을 다리에 올림
                deque.offerLast(truck_weights[index]);
                bridge_truck_weight = truck_weights[index];
                truckTime[index] = 1;  // 첫 번째 트럭이 다리 위에 있는 시간 초기화
                index++;
                time++;

                while (!deque.isEmpty()) {
                    time++;

                    // 트럭 시간 업데이트 및 다리를 다 건넌 트럭 제거
                    for (int i = 0; i < index; i++) {
                        if (truckTime[i] > 0) {
                            truckTime[i]++;
                            if (truckTime[i] > bridge_length) {
                                bridge_truck_weight -= deque.pollFirst();
                                truckTime[i] = 0;  // 해당 트럭 시간 초기화 (다리를 건넜으므로)
                            }
                        }
                    }

                    // 다음 트럭을 다리에 올릴 수 있는지 확인
                    if (index < truck_weights.length && bridge_truck_weight + truck_weights[index] <= weight) {
                        deque.offerLast(truck_weights[index]);
                        bridge_truck_weight += truck_weights[index];
                        truckTime[index] = 1;  // 새로 올라간 트럭의 시간 초기화
                        index++;
                    }
                }

                return time;
            }
        }
    }
}
