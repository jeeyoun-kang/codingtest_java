package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//bk_1655문제
public class PriorityQueueAlgorithm {

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // N 입력
            int N = Integer.parseInt(br.readLine());

            // 최대 힙 (중간값 이하의 수를 저장) -> 내림차순 정렬
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            // 최소 힙 (중간값 이상의 수를 저장)
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());

                // 최대 힙에 새로운 숫자 추가
                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }

                // 최대 힙과 최소 힙의 크기를 조절하여 최대 힙이 최소 힙보다 많거나 같도록 유지
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }

                // 중간값은 최대 힙의 루트
                sb.append(maxHeap.peek()).append("\n");
            }

            // 결과 출력
            System.out.print(sb.toString());
        }
    }
}
