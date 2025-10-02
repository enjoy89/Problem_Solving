import java.util.*;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int bridgeWeight = 0;
        int idx = 0; // 다음 트럭 인덱스

        // 초기 다리 상태
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (idx < truck_weights.length) {
            time++;

            // 다리에서 한 칸 이동
            bridgeWeight -= bridge.poll();

            // 다음 트럭이 올라갈 수 있으면
            if (bridgeWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                bridgeWeight += truck_weights[idx];
                idx++;
            } else {
                // 못 올라가면 0 넣기 (빈 공간)
                bridge.offer(0);
            }
        }

   
        return time + bridge_length;
    }
}