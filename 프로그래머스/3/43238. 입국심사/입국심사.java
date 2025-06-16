import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0; // 심사를 받는데 시간의 최솟값
        
        long left = 0;
        long right = (long) n * Arrays.stream(times).max().getAsInt(); // 심사 시간의 최댓값과 입국 심사를 기다리는 사람의 수를 곱한 최악의 시간
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0; // 심사 받을 수 있는 사람의 수
            for(int i=0; i<times.length; i++) {
                count += mid / times[i];
            }
            if(count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}