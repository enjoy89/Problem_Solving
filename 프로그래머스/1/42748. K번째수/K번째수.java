import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();
        for(int a=0; a<commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            List<Integer> list = new ArrayList<>();
            for(int b=i-1; b<=j-1; b++) {
                list.add(array[b]);
            }
            
            Collections.sort(list);
            answerList.add(list.get(k-1));
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}