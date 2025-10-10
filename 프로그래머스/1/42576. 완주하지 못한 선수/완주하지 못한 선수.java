import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1); // 이름이 등장한 빈도수 저장
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }

        return "";
    }
}