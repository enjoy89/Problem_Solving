import java.util.*;

class Solution {
    class Process {
        int index;
        int priority;
        
        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위
        
        for(int i=0; i<priorities.length; i++) {
            Process process = new Process(i, priorities[i]);
            queue.offer(process);
            pq.offer(priorities[i]);
        }

        int answer = 0;
        int count = 0;
        while(!queue.isEmpty()) {
            Process cur = queue.poll();
            
            if(cur.priority < pq.peek()) {
                queue.offer(cur); // 현재 문서가 1순위가 아니면 뒤로 보냄
            } else {
                pq.poll(); // 현재 우선순위를 빼준다
                count++;
                if(cur.index == location) {
                    answer = count;
                }
            }
        }
        
        return answer;
    }
}