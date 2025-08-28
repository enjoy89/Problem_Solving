import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        int left = 0;
        int right = d.length; // 모든 부서의 수
        while(left <= right) {
            int mid = (left+right) / 2;
            int sum = 0;
            for(int i=0; i<mid; i++) {
                sum += d[i];
            }
            
            if(sum <= budget) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return answer;
    }
}