import java.io.*;
import java.util.*;

/**
 * 2024-02-15
 */
public class N0110_가장_짧은_문자거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        char t = st.nextToken().charAt(0);

        int[] result = new int[s.length()];

        // 거리의 최소값을 구해야되므로 일단 기본값은 가장 큰 값으로 설정한다.
        int index = 100;

        // 왼쪽에 있는 t로부터 떨어진 거리를 구한다.
        // t 문자와 같다면 0으로 인덱스를 넣어주고,
        // t 문자와 다르다면 인덱스를 1 증가시켜서 넣어준다.
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == t) {
                index = 0;  // t 문자와 같으므로 다시 0으로 설정해준다.
            } else {
                index++;
            }
            result[i] = index;
        }

        // 오른쪽에 있는 t로부터 떨어진 거리를 구해서, 왼쪽에 있는 t와의 거리보다 작으면 바꿔준다.
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == t) {
                index = 0;
            } else  {
                index++;
            }

            if(result[i] > index) {
                result[i] = index;
            }
        }

        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
