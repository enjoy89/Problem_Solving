import java.io.*;
import java.util.*;

/**
 * 2024-02-19
 * 아나그램: 알파벳의 나열 순서는 다르지만 알파벳과 그 개수가 모두 일치하며,
 * 재배열 시 상대편 단어가 될 수 있다.
 */
public class N0402_아나그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        // 각각의 단어의 알파벳 빈도수를 해쉬맵에 저장하고,
        // 이를 비교하여 일치한다면 아나그램
        for(char c : s1.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0)+1);
        }

        for(char c : s2.toCharArray()) {
            m2.put(c, m2.getOrDefault(c, 0)+1);
        }

        boolean check = true;

        for(Map.Entry<Character, Integer> entry : m1.entrySet()) {
            Character key = entry.getKey();
            Integer value1 = entry.getValue();
            Integer value2 = m2.get(key);

            // 아나그램이 아닌 경우만 체크
            if(value2 == null || !value1.equals(value2)) {
                check = false;
                break;
            }
        }

        if(check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
