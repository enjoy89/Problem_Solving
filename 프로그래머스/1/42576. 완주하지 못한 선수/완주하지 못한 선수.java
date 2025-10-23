import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1); // 이름이 등장한 빈도수도 함께 저장
        }
        
        String answer = "";
        
        for(int i=0; i<completion.length; i++) {
            String cur = completion[i];
            if(map.containsKey(cur)) {
                if(map.get(cur) == 1) {
                    map.remove(cur);
                } else {
                    map.put(cur, map.get(cur) - 1);
                }
            }
        }
        
        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
            }
        }
        
        return answer;
        
    }
}