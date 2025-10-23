import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.offer(days);
        }
        
        List<Integer> result = new ArrayList<>();
        int count = 1;
        int cur = queue.poll();
        while(!queue.isEmpty()) {
            int next = queue.poll();
            if(cur < next) {
                result.add(count);
                cur = next;
                count = 1;
            } else {
                count++;
            }
        }
        result.add(count);
        
        
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = result.get(i);
        }
              
        return answer;
    }
}