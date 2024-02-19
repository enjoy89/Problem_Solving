import java.io.*;
import java.util.*;

public class N0401_학급_회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        HashMap<Character, Integer> m = new HashMap<>();

        for(char c : str.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0)+1);   // 키가 없으면 새로운 값을 생성하여 1을 더한다.
        }

        int max = Integer.MIN_VALUE;
        char result = ' ';

        // keySet 이용
        for(char key : m.keySet()) {
            if(m.get(key) > max) {
                max = m.get(key);
                result = key;
            }
        }
        
        // 또다른 HashMap 순회 방법
        // entrySet 이용
        // key와 value 모두 동시에 접근할 수 있다.
//        for(Map.Entry<Character, Integer> entry : m.entrySet()) {
//            char key = entry.getKey();
//            int value = entry.getValue();
//
//            if(value > max) {
//                max = value;
//                result = key;
//            }
//        }
        System.out.println(result);

    }

}
