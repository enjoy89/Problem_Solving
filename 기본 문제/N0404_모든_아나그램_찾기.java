import java.io.*;
import java.util.*;

/**
 * 2024-02-20
 */
public class N0404_모든_아나그램_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        // T 문자열 해시맵
        HashMap<Character, Integer> t_map = new HashMap<>();
        for(char c : t.toCharArray()) {
            t_map.put(c, t_map.getOrDefault(c, 0) + 1);
        }

        // S 문자열 해시맵
        HashMap<Character, Integer> s_map = new HashMap<>();
        int w = t.length() - 1;   // 윈도우의 크기
        int lt = 0;
        int count = 0;

        for(int rt=0; rt<s.length(); rt++) {
            s_map.put(s.charAt(rt), s_map.getOrDefault(s.charAt(rt), 0) + 1);

            // 처음부터 w까지는 초기 해시맵 구성
            // rt가 w랑 같아지면서 T 문자열 해시맵과 비교하기 시작한다.
            if(rt >= w) {
                if(s_map.equals(t_map)) {
                    count++;
                }

                // rt 값이 증가함에 따라 lt 값의 빈도수도 하나씩 줄여준다.
                // 이때 lt 값의 빈도수가 0이 된다면 해시맵에서 삭제한다.
                s_map.put(s.charAt(lt), s_map.get(s.charAt(lt)) - 1);
                if(s_map.get(s.charAt(lt)) == 0) {
                    s_map.remove(s.charAt(lt));
                }
                lt++;
            }
        }

        System.out.println(count);
    }
}
