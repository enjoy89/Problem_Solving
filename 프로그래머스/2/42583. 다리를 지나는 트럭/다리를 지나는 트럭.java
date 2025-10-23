import java.util.*;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0; // 다리 위의 트럭 무게의 합
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i=0; i<truck_weights.length; i++) {
            int truck = truck_weights[i];
            
            while(true) {
                // 다리가 꽉 차있는 경우
                // 가장 앞에 있는 트럭이 나간다
                if(bridge.size() == bridge_length) {
                    sum -= bridge.poll();
                }
                // 무게를 버틸 수 있는 경우
                else if(sum + truck <= weight) {
                    sum += truck;
                    bridge.offer(truck);
                    time++;
                    break; // 다음 트럭으로 넘어가기 때문에 여기서만 break
                } 
                // 더 올릴 수 없는 경우
                // 0으로 다리를 채운다
                else {
                    bridge.offer(0);
                    time++;
                }
            }   
        }
        
        int answer = time + bridge_length; // 마지막 트럭이 지나가는 시간을 더해줌
        return answer;
    }
}